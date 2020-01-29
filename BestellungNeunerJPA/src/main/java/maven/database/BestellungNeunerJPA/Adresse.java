package maven.database.BestellungNeunerJPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "adresse")
@Table(name = "adresse")
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private long id;
	@Getter
	@Setter
	private String Stadt;
	@Getter
	@Setter
	private String Strasse;
	@Getter
	@Setter
	private int PLZ;
	@Getter
	@Setter
	private int Hnr;


	public Adresse(String stadt, String strasse, int plz, int hnr) {
		super();
		Stadt = stadt;
		Strasse = strasse;
		PLZ = plz;
		Hnr = hnr;
	}

	public Adresse() {

	}
}
