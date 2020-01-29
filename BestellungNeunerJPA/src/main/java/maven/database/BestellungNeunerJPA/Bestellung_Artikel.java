package maven.database.BestellungNeunerJPA;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "bestellung_artikel")
@Table (name = "bestellung_artikel")
public class Bestellung_Artikel {
	
	private static final long serialVersionID = 1L;
	@Id
	@Getter
	@Setter
	private long id;
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	private Bestellung bestellung;
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	private Artikel artikel;
	@Getter
	@Setter
	private int menge;
	
	public Bestellung_Artikel(Bestellung bestellung, Artikel artikel, int menge) {
		super();
		this.menge = menge;
		this.bestellung = bestellung;
		this.artikel = artikel;
	}

	public Bestellung_Artikel() {
		
	}

	@Override
	public String toString() {
		return "Bestellung_Artikel [id=" + id + ", menge=" + menge + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artikel == null) ? 0 : artikel.hashCode());
		result = prime * result + ((bestellung == null) ? 0 : bestellung.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + menge;
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
		Bestellung_Artikel other = (Bestellung_Artikel) obj;
		if (artikel == null) {
			if (other.artikel != null)
				return false;
		} else if (!artikel.equals(other.artikel))
			return false;
		if (bestellung == null) {
			if (other.bestellung != null)
				return false;
		} else if (!bestellung.equals(other.bestellung))
			return false;
		if (id != other.id)
			return false;
		if (menge != other.menge)
			return false;
		return true;
	}
}

