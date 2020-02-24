package pizza;

import java.util.Arrays;

public class Salami implements IPizza{
	
	private String name = "Salami";
	private String zutaten[] = {"Tomaten", "Käse", "Salami"};
	
	public String getName() {
		return name;
	}
	
	public String[] getZutaten() {
		return zutaten;
	}

	public Salami(String name, String[] zutaten) {
		super();
		this.name = name;
		this.zutaten = zutaten;
	}

	public Salami() {

	}

	public String toString() {
		return "Salami [name=" + name + ", zutaten=" + Arrays.toString(zutaten) + "]";
	}
}
