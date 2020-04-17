package Schaltung;

import javax.naming.Context;

public interface IState {
	public void Next(Context context);
	public void Act();
}