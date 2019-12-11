package Heizung;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Heizung{

	Map<Observer, Integer> v = new HashMap<>();
	int value;
	
	public void setValue(int v) {
		value = v;
		notifyAllObservers();
	}
	
	public void notifyAllObservers() {
		for(Entry<Observer, Integer> e : v.entrySet()) {
			if(e.getValue() < value) {
				e.getKey().update(value);
			}
		}
	}
	
	public void register(Observer ob, int minTemp) {
		if(!v.containsKey(ob)) {
			v.put(ob, minTemp);
		}
	}
	
	public void unRegister(Observer ob) {
		v.remove(ob);
	}
	
}
