package com.reston.repositories;

import java.util.List;

import com.reston.models.Employee;
import com.reston.models.ReimbursementAccount;

public interface EmployeeDao {

	// using crud here

	// create
	public int insert(Employee emp);

	// read
	public List<Employee> findAll();
	public List<Employee> findAllEmployees();
	public List<Employee> findEmployeeById(int id);

	public Employee findByFirstAndLastName(String firstName, String lastName);
	public Employee checkManagerByUsername(String username);
	

	// update

	public String updateEmployeeUsername(Employee emp);
	public Employee updateUsername(int id, String username);
	public Employee updatePassword(int id, String password);
	public Employee updatePhoneNumber(int id, String phoneNumber);
	public Employee updateEmail(int id, String email);
	public Employee updateAddress(int id, String address);
	
	

	// delete

	public long deleteEmployee(Employee emp);

}
