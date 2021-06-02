package com.reston.services;

import java.util.List;

import com.reston.models.Employee;
import com.reston.repositories.EmployeeDao;
import com.reston.repositories.EmployeeDaoImp;

public class EmployeeService {
	
	

	public static EmployeeDao eDao = new EmployeeDaoImp();
	
	public static List<Employee> returnAllEmployee() {
		return eDao.findAll();
	}

	public int insert(Employee emp) {
		return eDao.insert(emp);
	}
	
	public static Employee findByUsername(String username) {
		
		List<Employee> all = eDao.findAll();
		
		for (Employee emp : all) {
			if (emp.getUsername().equals(username)) {
				return emp;
			}
		}
		return null;
	}
	
	
	
	
	
	public static Employee confirmLogin(String username, String password) {
		
		Employee emp = findByUsername(username);
		
		if (emp == null) {
			return null;
		}
		
		if (emp.getPassword().equals(password)) {
			return emp;
		} else {
			return null;
		}
	}
	
	
	
	public static boolean checkingManager(String username) {
		
		List<Employee> all = eDao.findAll();
		
		for (Employee emp : all) {
			if (emp.getUsername().equals(username)) {
				return emp.getManager();
			}
		}
		return false;
		
	}
	
	public static List<Employee> returnNotManagers(){
		return eDao.findAllEmployees();
	}
	
	public static List<Employee> returnSingleEmployeeInfo(int id){
		return eDao.findEmployeeById(id);
	}
	
	public static Employee updateUName(int id, String username) {
		return eDao.updateUsername(id, username);
	}
	
	public static Employee updatePWord(int id, String password) {
		return eDao.updatePassword(id, password);
	}
	
	public static Employee updatePNumber(int id, String phoneNumber) {
		return eDao.updatePhoneNumber(id, phoneNumber);
	}
	
	public static Employee updateMail(int id, String email) {
		return eDao.updateEmail(id, email);
	}
	
	public static Employee updateAdd(int id, String address) {
		return eDao.updateAddress(id, address);
	}
	

	
	
	
	
	

}
