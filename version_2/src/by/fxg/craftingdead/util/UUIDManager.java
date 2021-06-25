package by.fxg.craftingdead.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

public class UUIDManager {
   private static final String PROFILE_URL = "https://api.mojang.com/profiles/minecraft";
   private static HashMap playerUUIDMapping = new HashMap();
   private static JsonParser jsonParser = new JsonParser();

   public static void getMultiplePlayerUUIDs(String... par1) {
      UUIDManager.UUIDFetcher uuidFetcher = new UUIDManager.UUIDFetcher();
      String[] var2 = par1;
      int var3 = par1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var1 = var2[var4];
         uuidFetcher.addUsername(var1);
      }

      uuidFetcher.start();
   }

   public static String getPlayerUUID(String par1) {
      if (!playerUUIDMapping.containsKey(par1)) {
         UUIDManager.UUIDFetcher uuidFetcher = new UUIDManager.UUIDFetcher();
         uuidFetcher.addUsername(par1);
         uuidFetcher.start();
         return null;
      } else {
         return (String)playerUUIDMapping.get(par1);
      }
   }

   public static String getPlayerUUIDForced(String par1) {
      if (!playerUUIDMapping.containsKey(par1)) {
         System.out.println("[Forcing] Fetching UUID for '" + par1 + "'...");
         String var1 = fetchUUID(par1);
         playerUUIDMapping.put(par1, fetchUUID(par1));
         System.out.println("[Forcing] UUID Fetched for '" + par1 + "': " + var1);
      }

      return (String)playerUUIDMapping.get(par1);
   }

   private static String fetchUUID(String par1) {
      try {
         HttpURLConnection connection = createConnection();
         String body = "[\"" + par1 + "\"]";
         writeBody(connection, body);
         JsonArray array = (JsonArray)jsonParser.parse(new InputStreamReader(connection.getInputStream()));
         Iterator var4 = array.iterator();
         if (var4.hasNext()) {
            Object profile = var4.next();
            JsonObject jsonProfile = (JsonObject)profile;
            String id = jsonProfile.get("id").getAsString();
            String name = jsonProfile.get("name").getAsString();
            UUID uuid = getUUIDFromString(id);
            return uuid.toString();
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

      return null;
   }

   private static void writeBody(HttpURLConnection connection, String body) throws Exception {
      OutputStream stream = connection.getOutputStream();
      stream.write(body.getBytes());
      stream.flush();
      stream.close();
   }

   private static UUID getUUIDFromString(String id) {
      return UUID.fromString(id.substring(0, 8) + "-" + id.substring(8, 12) + "-" + id.substring(12, 16) + "-" + id.substring(16, 20) + "-" + id.substring(20, 32));
   }

   private static HttpURLConnection createConnection() throws Exception {
      URL url = new URL("https://api.mojang.com/profiles/minecraft");
      HttpURLConnection connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setUseCaches(false);
      connection.setDoInput(true);
      connection.setDoOutput(true);
      return connection;
   }

   private static class UUIDFetcher extends Thread {
      private ArrayList usernames;

      private UUIDFetcher() {
         this.usernames = new ArrayList();
      }

      public void addUsername(String par1) {
         if (!this.usernames.contains(par1)) {
            this.usernames.add(par1);
         }

      }

      public void run() {
         try {
            for(int i = 0; i < this.usernames.size(); ++i) {
               String username = (String)this.usernames.get(i);
               System.out.println("Fetching UUID for '" + username + "'...");
               String var1 = UUIDManager.fetchUUID(username);
               System.out.println("UUID Fetched for '" + username + "': " + var1);
               UUIDManager.playerUUIDMapping.put(username, var1);
            }

            this.usernames.clear();
         } catch (Exception var4) {
            var4.printStackTrace();
         }

      }

      // $FF: synthetic method
      UUIDFetcher(Object x0) {
         this();
      }
   }
}
