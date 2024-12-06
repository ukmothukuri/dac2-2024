package springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String a[]) {
		ApplicationContext con = new ClassPathXmlApplicationContext("spring-config.xml");
		
		DBOperations dob = con.getBean(DBOperations.class,"dbops");
		
		Employee emp = con.getBean(Employee.class, "emp");
		emp.setName("ABC");
		emp.setQualification("BTECH");
		
		dob.insertEmployeeDetails(emp);
	}
	
}

