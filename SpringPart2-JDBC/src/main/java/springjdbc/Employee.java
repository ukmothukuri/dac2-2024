package springjdbc;

public class Employee {
	private int employeeId;
	private String name;
	private String qualification;
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", qualification=" + qualification + "]";
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
}
