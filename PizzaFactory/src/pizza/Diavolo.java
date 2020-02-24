package pizza;

import java.util.Arrays;

public class Diavolo implements IPizza {
	
	private String name = "Diavolo";
	private String zutaten[] = {"Tomaten", "Käse", "Chilli", "Paprika", "Salami"};
	
	public String getName() {
		return name;
	}
	
	public String[] getZutaten() {
		return zutaten;
	}

	public Diavolo(String name, String[] zutaten) {
		super();
		this.name = name;
		this.zutaten = zutaten;
	}

	public Diavolo() {
	
	}

	public String toString() {
		return "Diavolo [name=" + name + ", zutaten=" + Arrays.toString(zutaten) + "]";
	}
}
