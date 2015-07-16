package com.shawnana.bookcorner.dao;

import java.util.List;

import com.shawnana.bookcorner.domain.Department;

public interface DepartmentDao {
	List<Department> findAllDepartments();
	Department findDepartmentById(int id);
	int insertDepartment(Department department);
	int updateDepartment(Department department);
}
