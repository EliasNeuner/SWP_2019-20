package simaystatemaschine;

public class AufnahmeState implements IState{

	@Override
	public void goNext(Context c) {
		c.setIstate(new BestellungState());
	}

	@Override
	public void printMsg() {
		System.out.println("Servus Kongosauger");
	}
}
