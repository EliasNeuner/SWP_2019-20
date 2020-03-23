package commandpattern;

public class Client {
	public static void main(String[] args) throws InterruptedException {
		Invoker invoker = new Invoker(new SystemDaten());
		invoker.run();
		Thread.sleep(200);
		invoker.run();
		Thread.sleep(200);
		invoker.redo();
	}
}