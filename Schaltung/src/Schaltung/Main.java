package Schaltung;

public class Main {
	public static void main(String[] args) {
		Context context = new Context(50, 100, true);
		
		context.beschleunigung(150, 100, true);
		System.out.println("Die Geschwindigkeit des Fahrzeugs wird auf 150 km/h erhöht und der Turbo wird geladen!!!");
		
		context.beschleunigung(30, 100, false);
		System.out.println("Die Geschwindigkeit des Fahrzeugs wird auf 30 km/h reduziert und der Turbo wird entladen!!!");
	}
}