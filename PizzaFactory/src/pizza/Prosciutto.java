package pizza;

import java.util.Arrays;

public class Prosciutto implements IPizza{
	
	private String name = "Prosciutto";
	private String zutaten[] = {"Tomaten", "Käse", "Schinken"};
	
	public String getName() {
		return name;
	}

	public String[] getZutaten() {
		return zutaten;
	}

	public Prosciutto(String name, String[] zutaten) {
		super();
		this.name = name;
		this.zutaten = zutaten;
	}

	public Prosciutto() {

	}

	public String toString() {
		return "Prosciutto [name=" + name + ", zutaten=" + Arrays.toString(zutaten) + "]";
	}
}
