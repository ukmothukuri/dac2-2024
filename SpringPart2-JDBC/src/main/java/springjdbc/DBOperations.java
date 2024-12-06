package springjdbc;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBOperations {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public void insertEmployeeDetails(Employee emp) {
		String query = "insert into employee (name, qualification) values('"+emp.getName()+"','"+emp.getQualification()+"')";
		jdbcTemplate.execute(query);
	}
	
}
