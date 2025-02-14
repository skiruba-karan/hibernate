import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student(101,"Alice");
		Student s2 = new Student(102,"Alex");
		Student s3 = new Student(103,"Albert");
		
		SessionFactory sf = new Configuration().addAnnotatedClass(Student.class).configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(s1);
		session.merge(s2);
		session.merge(s3);
		transaction.commit();
		session.close();
		sf.close();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}
}
