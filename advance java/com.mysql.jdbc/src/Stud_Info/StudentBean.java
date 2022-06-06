package Stud_Info;

import java.util.Date;

public class StudentBean {
	private int id;
	private String Name;
	private String MobNo;
	private Date   dob;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getMobNo() {
		return MobNo;
	}
	public void setMobNo(String mobNo) {
		MobNo = mobNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	} 
	
}
