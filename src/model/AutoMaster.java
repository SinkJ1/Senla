package model;

public class AutoMaster {
	
	private int id;

	private String name;
	
	private int age;
	
	private String address;
	
	private Boolean employment;
	
	
	public AutoMaster(int id, String name, int age, String address,Boolean employment) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.employment = employment;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Boolean getEmployment() {
		return employment;
	}


	public void setEmployment(Boolean employment) {
		this.employment = employment;
	}
	
	public String toString() {
		return "Man [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", employment=" + employment +"]";
	}
	
}
