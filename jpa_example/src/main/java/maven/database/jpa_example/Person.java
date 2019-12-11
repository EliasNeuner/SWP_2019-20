package maven.database.jpa_example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String vorname;
	private String nachname;
	private int alter;
	private Hobby hobby;
	
	@Transient
	private long aliveSince;
	
	public Person(long id, String vorname, String nachname, int alter) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.alter = alter;
		this.aliveSince = System.currentTimeMillis();
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", alter=" + alter
				+ ", aliveSince=" + aliveSince + this.hobby.toString() + "]";
	}

	public Person() {}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	public Hobby getHobby() {
		return hobby;
	}
	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
}
