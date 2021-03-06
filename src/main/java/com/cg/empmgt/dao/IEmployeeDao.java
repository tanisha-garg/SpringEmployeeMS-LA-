package com.cg.empmgt.dao;
import java.util.*;
import com.cg.empmgt.entities.*;

public interface IEmployeeDao {
	
	void add(Employee employee);
	
	Employee findById(int id);
	
	void removeById(int id);
	
	List<Employee> findAll();

}
