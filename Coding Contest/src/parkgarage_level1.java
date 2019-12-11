import java.util.ArrayList;
import java.util.Arrays;

public class parkgarage_level1 {
	static ArrayList<Integer> cars = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,-11,-12,-13,-14,-15,-16,-17,-18,-19,-20,-21,-22,-23,-24,-25,-26,-27,-28,-29,-30,-31,-32,-33,-34,-35,-36,-37,-38,-39,-40,-41,-42,-43,-44,-45,-46,-47,-48,-49,-50));
	static ArrayList<Integer> zwi = new ArrayList<>();
	static ArrayList<Integer> result = new ArrayList<>();
	static int zaehler = 0;
	
	public static int Autoszaehlen(ArrayList cars) {
		for(int i = 0; i < cars.size(); i++) {
			if(!zwi.contains(Math.abs((int) cars.get(i)))) {
				zwi.add(Math.abs((int) cars.get(i)));
				zaehler++;
			}else {
				result.add(zaehler);
				zaehler = 0;
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
		System.out.println(Autoszaehlen(cars));
	}
}
