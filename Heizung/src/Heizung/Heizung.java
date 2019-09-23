package Heizung;

import java.util.ArrayList;

public class Heizung{

	ArrayList<Observer> o = new ArrayList<>();
	int value;
	
	public void setValue(int v) {
		value = v;
		notifyAllObservers();
	}
	
	public void notifyAllObservers() {
		for(int i = 0; i < o.size(); i++) {
			o.get(i).update(value);
		}
	}
	
	public void register(Observer ob) {
		if(!o.contains(ob)) {
			o.add(ob);
		}
	}
	
	public void unRegister(Observer ob) {
		o.remove(ob);
	}
	
}
