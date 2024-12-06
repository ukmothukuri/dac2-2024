package springexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
	
	public static void main(String a[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		Student st1 = (Student)context.getBean("stdBean1");		
		System.out.println(st1);
		
		Student st2 = (Student)context.getBean("stdBean2");		
		System.out.println(st2);	
		
		
	}

}
