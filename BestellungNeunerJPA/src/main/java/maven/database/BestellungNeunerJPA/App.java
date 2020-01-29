package maven.database.BestellungNeunerJPA;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	public static void run() {
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("MyUnit");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		Scanner s = new Scanner(System.in);
		System.out.println("Bitte geben Sie CREATE, DELETE, READ oder UPDATE ein");
		String method = s.nextLine();
		if (method.equalsIgnoreCase("CREATE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNGARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String a = s.nextLine();
			if (a.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("KundenID: ");
				long kundenID = s.nextLong();
				Kunde kunde = entitymanager.find(Kunde.class, kundenID);
				System.out.println("LieferadresseID: ");
				long lieferID = s.nextLong();
				Adresse adresseliefer = entitymanager.find(Adresse.class, lieferID);
				System.out.println("RechnungsadresseID: ");
				long rechnungID = s.nextLong();
				Adresse adresserechnung = entitymanager.find(Adresse.class, rechnungID);
				Bestellung bestellung = new Bestellung(kunde, adresseliefer, adresserechnung);
				entitymanager.getTransaction().begin();
				entitymanager.persist(bestellung);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("BESTELLUNGARTIKEL")) {
				System.out.println("BestellID: ");
				long bestellID = s.nextLong();
				Bestellung bestellung = entitymanager.find(Bestellung.class, bestellID);
				System.out.println("ArtikelID: ");
				long artikelID = s.nextLong();
				Artikel artikel = entitymanager.find(Artikel.class, artikelID);
				System.out.println("Menge: ");
				int menge = s.nextInt();
				Bestellung_Artikel bestellungartikel = new Bestellung_Artikel(bestellung, artikel, menge);
				entitymanager.getTransaction().begin();
				entitymanager.persist(bestellungartikel);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("Artikelname: ");
				String artikelname = s.next();
				System.out.println("Preis: ");
				double preis = s.nextDouble();
				Artikel artikel = new Artikel(artikelname, preis);
				entitymanager.getTransaction().begin();
				entitymanager.persist(artikel);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("ADRESSE: ")) {
				System.out.println("Stadt: ");
				String stadt = s.next();
				System.out.println("Strasse: ");
				String strasse = s.next();
				System.out.println("PLZ: ");
				int plz = s.nextInt();
				System.out.println("Hausnummer: ");
				int hnr = s.nextInt();
				Adresse adresse = new Adresse(stadt, strasse, plz, hnr);
				entitymanager.getTransaction().begin();
				entitymanager.persist(adresse);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("KUNDE")) {
				System.out.println("Titel Vorname: ");
				String titelvorname = s.next();
				System.out.println("Vorname:  ");
				String vorname = s.next();
				System.out.println("Nachname:  ");
				String nachname = s.next();
				System.out.println("Titel Nachname: ");
				String titelnachname = s.next();
				Kunde kunde = new Kunde(titelvorname, vorname, nachname, titelnachname);
				entitymanager.getTransaction().begin();
				entitymanager.persist(kunde);
				entitymanager.getTransaction().commit();
			}
			System.out.println("Durchführen einer weiteren Aktion? (JA/NEIN)");
			String janein = s.next();
			if (janein.equalsIgnoreCase("JA")) {
				run();
			} else {
				s.close();
			}
		} else if (method.equalsIgnoreCase("DELETE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNGARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String a = s.next();
			if (a.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("ID: ");
				long ID = s.nextLong();
				Bestellung bestellung = entitymanager.find(Bestellung.class, ID);
				entitymanager.getTransaction().begin();
				entitymanager.remove(bestellung);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("BESTELLUNGARTIKEL")) {
				System.out.println("BestellID: ");
				long bestellID = s.nextLong();
				Bestellung_Artikel bestellungartikel = entitymanager.find(Bestellung_Artikel.class, bestellID);
				System.out.println("ArtikelID: ");
				long artikelID = s.nextLong();
				entitymanager.getTransaction().begin();
				entitymanager.remove(bestellungartikel);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("ID: ");
				long ID = s.nextLong();
				Artikel artikel = entitymanager.find(Artikel.class, ID);
				entitymanager.getTransaction().begin();
				entitymanager.remove(artikel);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("ADRESSE: ")) {
				System.out.println("ID: ");
				long ID = s.nextLong();
				Adresse adresse = entitymanager.find(Adresse.class, ID);
				entitymanager.getTransaction().begin();
				entitymanager.remove(adresse);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("KUNDE")) {
				System.out.println("ID:  ");
				long ID = s.nextLong();
				Kunde kunde = entitymanager.find(Kunde.class, ID);
				entitymanager.getTransaction().begin();
				entitymanager.remove(kunde);
				entitymanager.getTransaction().commit();
			}
			System.out.println("Durchführen einer weiteren Aktion? (JA/NEIN)");
			String janein = s.next();
			if (janein.equalsIgnoreCase("JA")) {
				run();
			} else {
				s.close();
			}
		} else if (method.equalsIgnoreCase("UPDATE")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNGARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String a = s.next();
			if (a.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				Bestellung bestellung = entitymanager.find(Bestellung.class, ID);
				System.out.println("KundenID: ");
				int kundenID = s.nextInt();
				Kunde kunde = entitymanager.find(Kunde.class, kundenID);
				System.out.println("LieferadresseID: ");
				int lieferID = s.nextInt();
				Adresse adresseliefer = entitymanager.find(Adresse.class, lieferID);
				System.out.println("RechnungsadresseID: ");
				int rechnungID = s.nextInt();
				Adresse adresserechnung = entitymanager.find(Adresse.class, rechnungID);
				bestellung.setKunde(kunde);
				bestellung.setLieferung(adresseliefer);
				bestellung.setRechnung(adresserechnung);
				entitymanager.getTransaction().begin();
				entitymanager.persist(bestellung);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("BESTELLUNGARTIKEL")) {
				System.out.println("BestellID: ");
				int bestellID = s.nextInt();
				Bestellung_Artikel bestellungartikel = entitymanager.find(Bestellung_Artikel.class, bestellID);
				System.out.println("ArtikelID: ");
				int artikelID = s.nextInt();
				Artikel artikel = entitymanager.find(Artikel.class, artikelID);
				System.out.println("Menge: ");
				int menge = s.nextInt();
				bestellungartikel.setArtikel(artikel);
				bestellungartikel.setMenge(menge);
				entitymanager.getTransaction().begin();
				entitymanager.persist(bestellungartikel);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				Artikel artikel = entitymanager.find(Artikel.class, ID);
				System.out.println("Artikelname: ");
				String artikelname = s.next();
				System.out.println("Preis: ");
				double preis = s.nextDouble();
				artikel.setArtikelname(artikelname);
				artikel.setPreis(preis);
				entitymanager.getTransaction().begin();
				entitymanager.persist(artikel);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("Adresse: ")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				Adresse adresse = entitymanager.find(Adresse.class, ID);
				System.out.println("Stadt: ");
				String stadt = s.next();
				System.out.println("Strasse: ");
				String strasse = s.next();
				System.out.println("PLZ: ");
				int plz = s.nextInt();
				System.out.println("Hausnummer: ");
				int hnr = s.nextInt();
				adresse.setStadt(stadt);
				adresse.setStrasse(strasse);
				adresse.setPLZ(plz);
				adresse.setHnr(hnr);
				entitymanager.getTransaction().begin();
				entitymanager.persist(adresse);
				entitymanager.getTransaction().commit();
			} else if (a.equalsIgnoreCase("KUNDE")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				Kunde kunde = entitymanager.find(Kunde.class, ID);
				System.out.println("Titel Vorname: ");
				String titelvorname = s.next();
				System.out.println("Vorname:  ");
				String vorname = s.next();
				System.out.println("Nachname:  ");
				String nachname = s.next();
				System.out.println("Titel Nachname: ");
				String titelnachname = s.next();
				kunde.setTitelVorname(titelvorname);
				kunde.setVorname(vorname);
				kunde.setNachname(nachname);
				kunde.setTitleNachname(titelnachname);
				entitymanager.getTransaction().begin();
				entitymanager.persist(kunde);
				entitymanager.getTransaction().commit();
			}
			System.out.println("Durchführen einer weiteren Aktion? (JA/NEIN)");
			String janein = s.next();
			if (janein.equalsIgnoreCase("JA")) {
				run();
			} else {
				s.close();
			}
		} else if (method.equalsIgnoreCase("READ")) {
			System.out.println("Bitte geben Sie BESTELLUNG, BESTELLUNGARTIKEL, ARTIKEL, ADRESSE oder KUNDE ein: ");
			String a = s.next();
			if (a.equalsIgnoreCase("BESTELLUNG")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				Bestellung bestellung = entitymanager.find(Bestellung.class, ID);
				System.out.println(bestellung.toString());
			} else if (a.equalsIgnoreCase("BESTELLUNGARTIKEL")) {
				System.out.println("BestellID: ");
				int bestellID = s.nextInt();
				Bestellung bestellung = entitymanager.find(Bestellung.class, bestellID);
				System.out.println("ArtikelID: ");
				int artikelID = s.nextInt();
				System.out.println(bestellung.toString());
			} else if (a.equalsIgnoreCase("ARTIKEL")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				Artikel artikel = entitymanager.find(Artikel.class, ID);
				System.out.println(artikel.toString());
			} else if (a.equalsIgnoreCase("Adresse: ")) {
				System.out.println("ID: ");
				int ID = s.nextInt();
				Adresse adresse = entitymanager.find(Adresse.class, ID);
				System.out.println(adresse.toString());
			} else if (a.equalsIgnoreCase("KUNDE")) {
				System.out.println("ID:  ");
				int ID = s.nextInt();
				Kunde kunde = entitymanager.find(Kunde.class, ID);
				System.out.println(kunde.toString());
			}
			System.out.println("Durchführen einer weiteren Aktion? (JA/NEIN)");
			String janein = s.next();
			if (janein.equalsIgnoreCase("JA")) {
				run();
			} else {
				s.close();
			}
		}
	}

	public static void main(String[] args) {
		run();
	}
}