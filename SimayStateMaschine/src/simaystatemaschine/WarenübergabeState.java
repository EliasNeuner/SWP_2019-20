package simaystatemaschine;

public class WarenübergabeState implements IState{

	@Override
	public void goNext(Context c) {
		c.setIstate(new HaschGezahltState());
	}

	@Override
	public void printMsg() {
		System.out.println("Da hasch dei Pizza!!!");
	}
}
