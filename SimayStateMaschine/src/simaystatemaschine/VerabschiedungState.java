package simaystatemaschine;

public class VerabschiedungState implements IState{

	@Override
	public void goNext(Context c) {
		c.setIstate(this);
	}

	@Override
	public void printMsg() {
		System.out.println("Passt danke tschau!!!");
	}
}
