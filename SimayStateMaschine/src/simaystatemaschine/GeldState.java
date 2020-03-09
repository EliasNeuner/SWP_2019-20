package simaystatemaschine;

public class GeldState implements IState{

	@Override
	public void goNext(Context c) {
		if(c.isValid() == true) {
			c.setIstate(new WarenübergabeState());
		}
		else
		{
			c.setIstate(new AufnahmeState());
		}
	}

	@Override
	public void printMsg() {
		System.out.println("4,20 bitte");
	}
}
