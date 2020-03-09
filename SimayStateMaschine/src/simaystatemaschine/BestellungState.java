package simaystatemaschine;

public class BestellungState implements IState{

	@Override
	public void goNext(Context c) {
		if(c.isValid() == true) {
			c.setIstate(new GeldState());
		}
		else
		{
			c.setIstate(new AufnahmeState());
		}
	}

	@Override
	public void printMsg() {
		System.out.println("Was willsch du gwaggl?");
	}
}