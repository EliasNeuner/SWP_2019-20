public class Controller implements Observer{

	private int brokespeed;

	public Controller(int broke) {
		brokespeed = broke;
	}
	
	@Override
	public void update(int update) {
		if(update >= brokespeed) {
			System.out.println("Broken!!!");
		}
	}
}