package maven.database.BestellungNeunerJPA;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "kunde")
@Table(name = "kunde")
public class Kunde {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private long id;
	@Getter
	@Setter
	private String TitelVorname;
	@Getter
	@Setter
	private String Vorname;
	@Getter
	@Setter
	private String Nachname;
	@Getter
	@Setter
	private String TitleNachname;
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "kunde")
	private List<Bestellung> bestellungen;

	public Kunde(String titelVorname, String vorname, String nachname, String titleNachname) {
		super();
		TitelVorname = titelVorname;
		Vorname = vorname;
		Nachname = nachname;
		TitleNachname = titleNachname;
	}
	
	public Kunde() {
		
	}
	
	@Override
	public String toString() {
		return "Kunde [id=" + id + ", TitelVorname=" + TitelVorname + ", Vorname=" + Vorname + ", Nachname=" + Nachname
				+ ", TitleNachname=" + TitleNachname + "]";
	}
}
