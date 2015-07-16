package com.shawnana.bookcorner.domain;

import java.util.Set;

public class Department {
	private Integer id; // id
	private String code; // 部门编码
	private String name; // 部门名称
	private Department fatherDepartment; // 上级部门
	private Set<Department> childrenDepartment; // 下级部门
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getFatherDepartment() {
		return fatherDepartment;
	}
	public void setFatherDepartment(Department fatherDepartment) {
		this.fatherDepartment = fatherDepartment;
	}
	public Set<Department> getChildrenDepartment() {
		return childrenDepartment;
	}
	public void setChildrenDepartment(Set<Department> childrenDepartment) {
		this.childrenDepartment = childrenDepartment;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Department)) return false;
		Department dep = (Department) o;
		if (!dep.getCode().equals(this.getCode())) 
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		if (this.getCode() != null) {
			result = 31 * result + this.getCode().hashCode();
		}
		return result;
	}
	
	@Override
	public String toString() {
		return new StringBuilder("[Department(").append(this.getCode()).
				append(":").append(this.getName()).append(")]").toString();
	}
}
