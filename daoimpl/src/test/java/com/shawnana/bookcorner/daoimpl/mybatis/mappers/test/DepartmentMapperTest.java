package com.shawnana.bookcorner.daoimpl.mybatis.mappers.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.shawnana.bookcorner.daoimpl.mybatis.mappers.DepartmentMapper;
import com.shawnana.bookcorner.domain.Department;


@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:mybatis-spring-unittest.xml")
public class DepartmentMapperTest {
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Test
	public void testFindAllDepartments() {
		List<Department> departments = departmentMapper.findAllDepartments();
		assertNotNull(departments);
		assertTrue(departments.size() > 0);
		for (Department department : departments) {
			assertNull(department.getChildrenDepartment());
		}
	}
	
	@Test
	public void testFindDepartmentById() {
		List<Department> departments = departmentMapper.findAllDepartments();
		Department expected = departments.get(0);
		Department department = departmentMapper.findDepartmentById(expected.getId());
		assertTrue(expected.equals(department));
		assertNotNull(department.getChildrenDepartment());
		
		Department unExistDepartment = departmentMapper.findDepartmentById(-1);
		assertNull(unExistDepartment);
	}
	
	@Test
	public void testInsertDepartment() {
		int rowCount = departmentMapper.findAllDepartments().size();
		Department newDepartment = new Department();
		newDepartment.setCode("NewDepCode");
		newDepartment.setName("NdwDepName");
		Department fatherDepartment = departmentMapper.findAllDepartments().get(0);
		newDepartment.setFatherDepartment(fatherDepartment);
		int insertRowCount = departmentMapper.insertDepartment(newDepartment);
		assertEquals(1, insertRowCount);
		assertEquals(rowCount + insertRowCount, departmentMapper.findAllDepartments().size());
	}
	
	@Test
	public void testUpdateDepartment() {
		String newCode = "newCode";
		Department department = departmentMapper.findAllDepartments().get(1);
		assertTrue(!newCode.equals(department.getCode()));
		department.setCode(newCode);
		assertEquals(1, departmentMapper.updateDepartment(department));
		Department updatedDepartment = departmentMapper.findDepartmentById(department.getId());
		assertEquals(newCode, updatedDepartment.getCode());
	}
}
