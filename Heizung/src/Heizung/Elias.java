package Heizung;

public class Elias implements Observer {

	@Override
	public void update(int x) {
		System.out.printf("Elias, es hat jetzt %d Grad!!! \n", x);
	}
}
