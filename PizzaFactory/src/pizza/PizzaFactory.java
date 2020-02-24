package pizza;

public class PizzaFactory{
	public static IPizza getPizza(String pizza) {
		if (pizza == "Diavolo") {
			return new Diavolo();
		} 
		else if (pizza == "Salami") {
			return new Salami();
		} 
		else if (pizza == "Prosciutto") {
			return new Prosciutto();
		} 
		else
			return null;
	}
}
