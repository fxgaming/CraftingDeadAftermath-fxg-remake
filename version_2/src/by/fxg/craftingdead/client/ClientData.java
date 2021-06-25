package by.fxg.craftingdead.client;

public class ClientData {
	public static float swing = 0.0F;
	public static float smoothSwing = 0.0F;

	public static class SmoothSwingTicker implements Runnable {
		private final double amountOfTicks = 60.0D;
		private final double ns = 1.6666666666666666E7D;
		private long lastTime = System.nanoTime();
		private double delta = 0.0D;

		public void run() {
			while (true) {
				long now = System.nanoTime();
				this.delta += (double) (now - this.lastTime) / 1.6666666666666666E7D;

				for (this.lastTime = now; this.delta >= 1.0D; --this.delta) {
					++smoothSwing;
				}
			}
		}
	}
}
