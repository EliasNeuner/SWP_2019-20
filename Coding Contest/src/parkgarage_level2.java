import java.util.ArrayList;
import java.util.Arrays;

public class parkgarage_level2 {
	static ArrayList<Integer> cars = new ArrayList<>(Arrays.asList());
	static ArrayList<Integer> zwi = new ArrayList<>();
	static ArrayList<Integer> result = new ArrayList<>();
	static int zaehler = 0;
	
	public static int Autoszaehlen(ArrayList cars, int parkhausVoll) {
		int warteschlange = 0;
		int voll = parkhausVoll;
		for(int i = 0; i < cars.size(); i++) {
			if(!zwi.contains(Math.abs((int) cars.get(i)))) {
				zwi.add(Math.abs((int) cars.get(i)));
				zaehler++;
				if(parkhausVoll > 0) {
					parkhausVoll--;
				}
				else
				{
					warteschlange++;
				}
			}	else {
				result.add(zaehler);
				zaehler = 0;
				if(warteschlange > 0) {
					warteschlange--;
				}
				else if(parkhausVoll <= voll)
				{
					parkhausVoll++;
				}
			}
		}
		zaehler = 0;
		for(int i = 0; i < result.size(); i++) {
			if(zaehler < result.get(i)) 
			{
				zaehler = result.get(i);
			}
		}
		return zaehler;
	}
	
	public static void main(String[] args) {
		System.out.println(Autoszaehlen(cars, 5));
	}
}
