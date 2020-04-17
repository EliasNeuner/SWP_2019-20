package Schaltung;

import javax.naming.Context;

public class Sport implements IState{

	@Override
	public void Next(Context context) {
		if(context.isGültig()) {
			context.setState(new Standard());
		}
	}

	@Override
	public void Act() {
		System.out.println("Sport Modus");
	}
	
}
