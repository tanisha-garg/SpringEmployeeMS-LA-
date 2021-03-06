package com.cg.empmgt.dao;

import com.cg.empmgt.entities.*;
import java.util.*;

public class EmployeeDaoImpl implements IEmployeeDao{
	
	private int generatedId;
	
	public int generateId() {
		generatedId++;
		return generatedId;
	}

	
	@Override
	public void add(Employee employee) {
		Map<Integer, Employee> store = StoreHolder.store;
		int id = generateId();
		employee.setId(id);
		store.put(id, employee);
		
	}
	
	@Override
	public Employee findById(int id) {
		Map<Integer, Employee> store = StoreHolder.store;
		Employee employee = store.get(id);
		return employee;
	}
	
	@Override
	public void removeById(int id) {
		Map<Integer, Employee> store = StoreHolder.store;
		store.remove(id);
	}
	
	@Override
	public List<Employee> findAll(){
		Map<Integer, Employee> store = StoreHolder.store;
		Collection<Employee> employees = store.values();
		List<Employee> list = new ArrayList<>(employees);
		return list;
	}

}
