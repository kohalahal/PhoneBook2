package org.hal.phonebook.model;

public class PeopleVO {
	
	private int id;
	private String name;
	private String phone;
	
	public PeopleVO() {}
	public PeopleVO( String name, String phone) {
		id=-1;
		this.name=name;
		this.phone=phone;
	}
	public PeopleVO(int id, String name, String phone) {
		this.id=id;
		this.name=name;
		this.phone=phone;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "\t"+name + "\t\t" + phone;
	}
	public PeopleVO copy(PeopleVO p) {
		return new PeopleVO(p.getId(), p.getName(), p.getPhone());
	}
	

}
