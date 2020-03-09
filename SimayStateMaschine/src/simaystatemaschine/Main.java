package simaystatemaschine;

public class Main {

	public static void main(String[] args) {
		Context c = new Context();
		for(int i = 0; i < 6; i++) {
			c.getIstate().printMsg();
			c.getIstate().goNext(c);
		}
	}
}