package by.fxg.craftingdead.client.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelBush extends ModelBase
{
    ModelRenderer Bush1;
    ModelRenderer Bush2;
    ModelRenderer Bush3;
    ModelRenderer Leaf1;
    ModelRenderer Leaf2;
  
  public ModelBush()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Bush1 = new ModelRenderer(this, 0, 0).addBox(0F, 0F, 0F, 6, 3, 3);
      Bush1.setTextureSize(64, 32).setRotationPoint(0F, 0F, 0F);
	  a(Bush1, 0F, 0F, 0F);
	  Bush1.mirror = true;
      Bush2 = new ModelRenderer(this, 0, 6).addBox(0F, 0F, 0F, 8, 5, 5);
      Bush2.setTextureSize(64, 32).setRotationPoint(-1F, -1F, -1F);
	  a(Bush2, 0F, 0F, 0F);
	  Bush2.mirror = true;
      Bush3 = new ModelRenderer(this, 26, 0).addBox(0F, 0F, 0F, 10, 7, 7);
      Bush3.setTextureSize(64, 32).setRotationPoint(-2F, -2F, -2F);
	  a(Bush3, 0F, 0F, 0F);
	  Bush3.mirror = true;
      Leaf1 = new ModelRenderer(this, 26, 14).addBox(0F, 0F, 0F, 16, 16, 0);
      Leaf1.setTextureSize(64, 32).setRotationPoint(0F, 0F, 0F);
	  a(Leaf1, 0F, 0F, 0F);
	  Leaf1.mirror = true;
      Leaf2 = new ModelRenderer(this, 0, 16).addBox(0F, 0F, 0F, 8, 8, 0);
      Leaf2.setTextureSize(64, 32).setRotationPoint(0F, 0F, 0F);
	  a(Leaf2, 0F, 0F, 0F);
	  Leaf2.mirror = true;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Bush1.render(f5);
    Bush2.render(f5);
    Bush3.render(f5);
    Leaf1.render(f5);
    Leaf2.render(f5);
  }
  
  public void renderSmall(float var1) {
	  Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("craftingdead:textures/models/bush.png"));
	  Bush1.render(var1);
  }
  
  public void renderMedium(float var1) {
	  Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("craftingdead:textures/models/bush.png"));
	  Bush2.render(var1);
  }
  
  public void renderLarge(float var1) {
	  Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("craftingdead:textures/models/bush.png"));
	  Bush3.render(var1);
  }
  
  public void renderLeafLarge(float var1) {
	  Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("craftingdead:textures/models/bush.png"));
	  Leaf1.render(var1);
  }
  
  public void renderLeafSmall(float var1) {
	  Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("craftingdead:textures/models/bush.png"));
	  Leaf2.render(var1);
  }
  
  private void a(ModelRenderer a, float b, float c, float d)
  {
    a.rotateAngleX = b;
    a.rotateAngleY = c;
    a.rotateAngleZ = d;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
