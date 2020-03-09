package simaystatemaschine;

public class State implements IState {

	@Override
	public void goNext(Context c) {
		c.setIstate(this);
	}

	@Override
	public void printMsg() {
		
	}
}