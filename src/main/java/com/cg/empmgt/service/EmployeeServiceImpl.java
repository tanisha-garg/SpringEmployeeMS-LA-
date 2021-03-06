package com.cg.empmgt.service;

import java.util.List;
import com.cg.empmgt.dao.*;
import com.cg.empmgt.exceptions.*;

import com.cg.empmgt.dao.IEmployeeDao;
import com.cg.empmgt.entities.Employee;

public class EmployeeServiceImpl implements IEmployeeService{
	
	private IEmployeeDao dao = new EmployeeDaoImpl();
	
	@Override
	public Employee add(String name, String department) {
		validateName(name);
		validateDepartment(department);
		Employee employee = new Employee(name, department);
		dao.add(employee);
		return employee;
	}
	
	@Override
	public Employee findById(int id) {
		validateId(id);
		Employee employee = dao.findById(id);
		return employee;
		
	}
	
	@Override
	public void removeById(int id) {
		validateId(id);
		dao.removeById(id);
		
	}
	
	@Override
	public List<Employee> findAll(){
		List<Employee> employees = dao.findAll();
		return employees;
	}
	
	public void validateId(int id) {
		if(id < 0) {
			throw new InvalidIdException("Given Id is invalid");
		}
	}
	
	public void validateName(String name) {
		if(name == null || name.isEmpty() || name.length()>10) {
			throw new InvalidEmployeeNameException("Name cannot be null or empty or less than 10");
		}
	}
	
	public void validateDepartment(String department) {
		if(department == null || department.isEmpty()) {
			throw new InvalidDepartmentException("Department cannot be null or empty");
		}
	}

}
