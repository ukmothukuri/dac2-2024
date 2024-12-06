package springexample;

public class Student {
	private int rollnumber;
	private String name;
	private String branch;
	private Address addrs;
	
	public Address getAddrs() {
		return addrs;
	}
	public void setAddrs(Address addrs) {
		this.addrs = addrs;
	}
	public int getRollnumber() {
		return rollnumber;
	}
	
	@Override
	public String toString() {
		return "Student [rollnumber=" + rollnumber + ", name=" + name + ", branch=" + branch + ", addrs=" + addrs + "]";
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
}
