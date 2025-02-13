import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        // Open Hibernate session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        // Create new Employee
        Employee emp1 = new Employee("Alice Johnson", "Software Engineer", 60000);
        Employee emp2 = new Employee("Bob Williams", "Project Manager", 80000);

        // Save to database
        session.persist(emp1);
        session.persist(emp2);

        // Commit and close session
        transaction.commit();
        session.close();

        System.out.println("Employees added:\n" + emp1 + "\n" + emp2);
    }
}
