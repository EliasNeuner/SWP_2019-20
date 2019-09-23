package Heizung;

public class Main {
	public static void main(String[] args) {
		Heizung h = new Heizung();
		Elias e = new Elias();
		Noah n = new Noah();
		
		h.register(e);
		h.register(n);
		h.setValue(20);
		h.setValue(30);
		h.unRegister(n);
		h.setValue(40);
	}
}
