package in.cdac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import in.cdac.model.Book;

public class DBOperations {

	private final String url ="jdbc:mysql://localhost:3306/bms";
	private final String username = "root";
	private final String password = "root";
	Connection con = null;
	
	static {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException ce) {
			System.out.println("Driver Class Not Found"+ce);
		}
	}
	
	public void getDBConnection() {		
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Got the DB Connection");
		}catch(SQLException se) {
			System.out.println("Unable to connect to the DB Server"+se);
		}		
	}
	
	public DBOperations() {
		getDBConnection();
	}
	
	public static void main(String a[]) {
		DBOperations dob = new DBOperations();
	//	dob.getDBConnection();
//		Book b1 = new Book();
//		b1.setName("Hibernate");
//		b1.setAuthor("Rod Johnson");
//		b1.setPrice(450);
//		b1.setPublication("DEF");
//		
//		dob.addBookDetails(b1);
		
		//dob.getBookDetailsById(1);
		dob.getBookDetailsByName("Java' OR '1'='1");
		
//		Book b1 = new Book();
//		b1.setId(1);
//		b1.setName("Java");
//		b1.setAuthor("James Gosling");
//		b1.setPrice(670);
//		b1.setPublication("ABC");
//		dob.updateBookDetails(b1);
	
		//dob.deleteBookById(2);
	}
	
	
	/* For deleting the book */
	public void deleteBookById(int id) {
		String query = "delete from books where id="+id;
		try(Statement st = con.createStatement()){
			int rowseffected = st.executeUpdate(query);
			if(rowseffected != 1) {
				System.out.println("Error occurred while deleting the record");
			}else 
			{
				System.out.println("Successfully Book details were deleted");
			}
			con.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	/* Update the book details */
	public void updateBookDetails(Book bk) {
		//String query = "update books set name='"+bk.getName()+"', author='"+bk.getAuthor()+"', price="+bk.getPrice()+",publication='"+bk.getPublication()+"' where id="+bk.getId()+"";
		String query = "update books set name=?, author=?,"
				+ " price=?,publication=? where id=?";
		//try(Statement st = con.createStatement()){
		try(PreparedStatement pst = con.prepareStatement(query)){
			pst.setString(1, bk.getName());
			pst.setString(2, bk.getAuthor());
			pst.setFloat(3, bk.getPrice());
			pst.setString(4, bk.getPublication());
			pst.setInt(5, bk.getId());
			
			int rowseffected = pst.executeUpdate();
			if(rowseffected != 1) {
				System.out.println("Error occurred while updating the record");
			}else 
			{
				System.out.println("Successfully Book details were updated");
			}
			con.close();
		}catch(SQLException se) {
			se.printStackTrace();
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	/*To Retrieve all books */
	public ArrayList<Book> getAllBookDetails() {
		ArrayList<Book> books = new ArrayList(); 		
		String query = "select * from books";
		try(Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query)){
			while(rs.next()) {
				Book bk = new Book();
				bk.setId(rs.getInt("id"));
				bk.setName(rs.getString("name"));
				bk.setAuthor(rs.getString("author"));
				bk.setPrice(rs.getFloat("price"));
				bk.setPublication(rs.getString("publication"));
				books.add(bk);
			}
			con.close();			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return books;
	}
	
	
	
	
	
	
	/* Retrieve the book details by ID */
	public void getBookDetailsById(int id) {
		Book bk = null;
		//String query = "select * from books where id="+id;
		String query = "select * from books where id=?";
//		try(Statement st = con.createStatement();
		try(PreparedStatement pst = con.prepareStatement(query)){
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				bk = new Book();
				bk.setId(rs.getInt("id"));
				bk.setName(rs.getString("name"));
				bk.setAuthor(rs.getString("author"));
				bk.setPrice(rs.getFloat("price"));
				bk.setPublication(rs.getString("publication"));
			}
			con.close();
			System.out.println(bk.toString());
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	/* Retrieve the book details by Name */
	public void getBookDetailsByName(String name) {
		Book bk = null;
		String query = "select * from books where name=?";
//		String query = "select * from books where id=?";
//		try(Statement st = con.createStatement()){
		try(PreparedStatement pst = con.prepareStatement(query)){
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();
//			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				bk = new Book();
				bk.setId(rs.getInt("id"));
				bk.setName(rs.getString("name"));
				bk.setAuthor(rs.getString("author"));
				bk.setPrice(rs.getFloat("price"));
				bk.setPublication(rs.getString("publication"));
				System.out.println(bk.toString());
			}
			con.close();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
	}
	
	
	
	
	/* Insertion of Book Details */
	public void addBookDetails(Book bk) {
//		String query = "insert into books (name, author, price, publication)"
//				+ " values('"+bk.getName()+"','"+bk.getAuthor()+"',"+bk.getPrice()+",'"+bk.getPublication()+"')";
//		//Statement st = null;
		
		String query = "insert into books (name, author, price, publication) "
				+ "values (?,?,?,?)";
		PreparedStatement pst = null;
		try {
			//st = con.createStatement();
			pst = con.prepareStatement(query);
			pst.setString(1, bk.getName());
			pst.setString(2, bk.getAuthor());
			pst.setFloat(3, bk.getPrice());
			pst.setString(4, bk.getPublication());
			
			//boolean status = st.execute(query);
			int id = pst.executeUpdate();				
			System.out.println("Book added successfully"+id);
			pst.close();
			con.close();
			//return status;
		}catch(SQLException se) 
		{
			System.out.println("Error occurred while storing books");
			se.printStackTrace();
		}
		//return false;
	}
	
	
	
	
	
	
	
	
	
}
