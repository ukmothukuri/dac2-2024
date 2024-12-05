package in.cdac.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DBOperations {

	SessionFactory sf = null;
	
	public void saveBookDetails(Book bk) {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tns = session.beginTransaction();
		session.persist(bk);
		tns.commit();		
	}
	
	public void getBookDetails(int id) {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Book bk = session.get(Book.class, id);
		System.out.println(bk);
	}
	
	public void updateBookDetails(Book bk) {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tns = session.beginTransaction();
		
		Book originalBook =session.get(Book.class, bk.getId());
		originalBook.setName(bk.getName());
		originalBook.setAuthor(bk.getAuthor());
		originalBook.setPrice(bk.getPrice());
		
		session.persist(originalBook);
		tns.commit();		
	}
	
	public void deleteBookDetails(int id) {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		
		Book originalBook =session.get(Book.class, id);
		if(originalBook != null) {
			Transaction tns = session.beginTransaction();
			session.remove(originalBook);	
			tns.commit();
		}
	}
	
	
	
	public void saveStudentDetails(Student std) {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tns = session.beginTransaction();
		
		session.persist(std);
		tns.commit();
	}
	
	public void getStudentDetails(int rollnumber) {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Student std = session.get(Student.class, rollnumber);
		System.out.println(std);		
	}
	
	public void allotBooksToStudent(List<Integer> bookids, 
			int rollnumber) {
		sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tns = session.beginTransaction();
		List<Book> books = new ArrayList<Book>();
		for(int id : bookids) {
			books.add(session.get(Book.class, id));			
		}
		
		Student std = session.get(Student.class, rollnumber);
		
		std.setBooks(books);
		
		session.persist(std);
		tns.commit();
		
	}
	
	
	public static void main(String aa[]) {
		DBOperations dbs = new DBOperations();
		
//		Book bk = new Book();
//		bk.setName("Hibernate");
//		bk.setAuthor("Gaven King");
//		bk.setPrice(595);
//		
//		dbs.saveBookDetails(bk);
		
dbs.getBookDetails(2);
		
//		Book updatedbook = new Book();
//		updatedbook.setId(1);
//		updatedbook.setName("J2SE V2");
//		updatedbook.setAuthor("James Gosling");
//		updatedbook.setPrice(600);
//		
//		dbs.updateBookDetails(updatedbook);
		
	//	dbs.deleteBookDetails(3);
		
		
//		Student st = new Student();
//		st.setName("ABC");
//		st.setBranch("DAC");
//		st.setPercentage(75);
//		
//		Address ad = new Address();
//		ad.setCity("HYD");
//		ad.setState("TG");
//		ad.setPincode(500100);	
//		
//		st.setAddress(ad);
//		
//		dbs.saveStudentDetails(st);
//		
	//	dbs.getStudentDetails(1);
		
//		List<Integer> bookids = new ArrayList<Integer>();
//		bookids.add(1);
//		bookids.add(2);
//		dbs.allotBooksToStudent(bookids, 1);
	}
}
