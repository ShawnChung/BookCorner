package com.shawnana.bookcorner.domain;

public class User {

	private Integer id;
	private String userno;
	private String username;
	private Gender gender;
	private Department department;
	private String password;
	
	public enum Gender {
		MALE("男"),
		FEMALE("女");
		
		private String chinese;
		private Gender(String chinese) {
			this.chinese = chinese;
		}
		public String getChinese() {
			return this.chinese;
		}
	}

	public void setId(Integer id) {
		// if (null != this.id) throw new RuntimeException();
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return this.id;
	}

	public String getUserno() {
		return userno;
	}

	public void setUserno(String userno) {
		this.userno = userno;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		if (!user.getUserno().equals(this.getUserno()))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		if (this.getUserno() != null) {
			result = 34 * result + this.getUserno().hashCode();
		}
		return result;
	}
	
	@Override
	public String toString() {
		return new StringBuilder("[User(").append(this.getUserno()).
				append(":").append(this.getUsername()).append(")]").toString();
	}
}
