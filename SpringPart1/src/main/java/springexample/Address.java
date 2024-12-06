package springexample;

public class Address {
	private String lane;
	private String City;
	private String State;
	private int pincode;
	
	@Override
	public String toString() {
		return "Address [lane=" + lane + ", City=" + City + ", State=" + State + ", pincode=" + pincode + "]";
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
