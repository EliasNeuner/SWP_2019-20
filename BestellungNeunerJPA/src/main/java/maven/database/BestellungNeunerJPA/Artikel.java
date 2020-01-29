package maven.database.BestellungNeunerJPA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity (name = "artikel")
@Table (name = "artikel")
public class Artikel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	@Column(insertable = false)
	private long id;
	@Getter
	@Setter
	private String artikelname;
	@Getter
	@Setter
	private double preis;
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<Bestellung_Artikel> bestellung_artikel = new ArrayList<Bestellung_Artikel>();

	public Artikel(String artikelname, double preis) {
		super();
		this.artikelname = artikelname;
		this.preis = preis;
	}
	
	public Artikel() {
		
	}

	@Override
	public String toString() {
		return "Artikel [id=" + id + ", artikelname=" + artikelname + ", preis=" + preis + "]";
	}
}
