package maven.database.BestellungNeunerJPA;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "bestellung_v3")
@Table(name = "bestellung_v3")
public class Bestellung {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private long id;
	@Getter
	@Setter
	private Kunde kunde;
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	private Adresse rechnung;
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	private Adresse lieferung;
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "bestellung")
	private List<Bestellung_Artikel> bestellung_artikel;

	public Bestellung(Kunde kunde, Adresse rechnung, Adresse lieferung) {
		super();
		this.kunde = kunde;
		this.rechnung = rechnung;
		this.lieferung = lieferung;
	}

	public Bestellung() {

	}

	@Override
	public String toString() {
		return "Bestellung [id=" + id + ", kunde=" + kunde + ", rechnung=" + rechnung + ", lieferung=" + lieferung
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bestellung_artikel == null) ? 0 : bestellung_artikel.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((kunde == null) ? 0 : kunde.hashCode());
		result = prime * result + ((lieferung == null) ? 0 : lieferung.hashCode());
		result = prime * result + ((rechnung == null) ? 0 : rechnung.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestellung other = (Bestellung) obj;
		if (bestellung_artikel == null) {
			if (other.bestellung_artikel != null)
				return false;
		} else if (!bestellung_artikel.equals(other.bestellung_artikel))
			return false;
		if (id != other.id)
			return false;
		if (kunde == null) {
			if (other.kunde != null)
				return false;
		} else if (!kunde.equals(other.kunde))
			return false;
		if (lieferung == null) {
			if (other.lieferung != null)
				return false;
		} else if (!lieferung.equals(other.lieferung))
			return false;
		if (rechnung == null) {
			if (other.rechnung != null)
				return false;
		} else if (!rechnung.equals(other.rechnung))
			return false;
		return true;
	}
}
