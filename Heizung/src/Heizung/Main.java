package Heizung;

public class Main {
	public static void main(String[] args) {
		Heizung h = new Heizung();
		Elias e = new Elias();
		Noah n = new Noah();
		
		h.register(e, 19);
		h.register(n, 27);
		h.setValue(20);
		h.setValue(30);
		h.unRegister(n);
		h.setValue(40);
	}
}
