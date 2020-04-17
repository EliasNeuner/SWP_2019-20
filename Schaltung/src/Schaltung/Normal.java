package Schaltung;

import javax.naming.Context;

public class Normal implements IState{

	@Override
	public void Next(Context context) {
		if(context.isGültig()) {
			context.setState(new Sport());
		}
		else
		{
			context.setState(new Normal());
		}
	}

	@Override
	public void Act() {
		System.out.println("Standard Modus");
	}
}