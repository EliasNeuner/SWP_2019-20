import java.util.ArrayList;

public class Motor implements Observable{

	private ArrayList<Observer> o =new ArrayList<Observer>();
	int speed = 1000;
	
	public void accelerate() {
		try {
			Thread.sleep(1000);
			speed = speed + 1000;
			System.out.println(speed);
		}
		catch (InterruptedException e){
			System.out.println("An dem Motor scheint etwas nicht korrekt zu sein!!!");
		}
		this.notifyObserver();
	}
	
	
	@Override
	public void addObserver(Observer observer) {
		o.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		o.remove(observer);
	}

	@Override
	public void notifyObserver() {
		for(int i = 0; i < o.size(); i++) {
			o.get(i).update(speed);
		}
	}
	
	public static void main(String[] args) {
		Motor motor = new Motor();
		motor.addObserver(new Controller(6000));
		for(int i = 0; i < 15; i++) {
			motor.accelerate();
		}
	}
}