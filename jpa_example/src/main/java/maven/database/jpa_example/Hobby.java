package maven.database.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Hobby {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private long id;
	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private int stundenProWoche;
	@Setter
	@Getter
	private double ausgaben;
	
	public Hobby() {
		super();
	}

	public Hobby(String name, int stundenProWoche, double ausgaben) {
		super();
		this.name = name;
		this.stundenProWoche = stundenProWoche;
		this.ausgaben = ausgaben;
	}
}
