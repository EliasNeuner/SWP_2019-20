package simaystatemaschine;

public class HaschGezahltState implements IState{

	@Override
	public void goNext(Context c) {
		if(c.isValid() == true) {
			c.setIstate(new VerabschiedungState());
		}
		else
		{
			c.setIstate(new GeldState());
		}
	}

	@Override
	public void printMsg() {
		System.out.println("Hasch wirklich scho zahlt?");
	}
}
