package Heizung;

public class Noah implements Observer{
	
	@Override
	public void update(int x) {
		System.out.printf("Noah, es hat jetzt %d Grad!!! \n", x);
	}
	
}
