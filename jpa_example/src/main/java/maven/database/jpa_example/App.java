package maven.database.jpa_example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class App {

	public static void main(String[] args) {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("MyUnit");
		EntityManager manager = f.createEntityManager();

		// create Person
//    	Person p1 = new Person();
//    	p1.setId(3);
//    	p1.setVorname("Jonas");
//    	p1.setNachname("Ladner");
//    	p1.setAlter(18);
//    	manager.getTransaction().begin();
//    	manager.persist(p1);
//    	manager.getTransaction().commit();

		// update Person
//    	Person p2 = manager.find(Person.class, 10L);
//    	p2.setVorname("Noah");
//    	p2.setNachname("Siegele");
//    	System.out.println(p2);
//    	
//    	manager.getTransaction().begin();
//    	manager.getTransaction().commit();
//    	
//    	//delete Person
//    	Person p3 = manager.find(Person.class, 12L);
//    	
//    	manager.getTransaction().begin();
//    	manager.remove(p3);
//    	manager.getTransaction().commit();

		//create Hobby
//    	Person p4 = manager.find(Person.class, 15L);
//    	Hobby h = new Hobby ("Autofahren", 12, 5000);
//    	
//    	System.out.println("New Hobby - before persist");
//    	System.out.println(h);
//    	
//    	manager.getTransaction().begin();
//    	manager.persist(h);
//    	manager.getTransaction().commit();
//    	
//    	p4.setHobby(h);
//    	manager.getTransaction().begin();
//    	manager.getTransaction().commit();
//    	
//    	System.out.println("New hobby - after persist");
//    	System.out.println(h);

//    	Person p5 = manager.find(Person.class, 1L);
//    	System.out.println(p5);

		// delete Hobby
//		Hobby h3 = manager.find(Hobby.class, 9L);
//
//		manager.getTransaction().begin();
//		manager.remove(h3);
//		manager.getTransaction().commit();
	}
}
