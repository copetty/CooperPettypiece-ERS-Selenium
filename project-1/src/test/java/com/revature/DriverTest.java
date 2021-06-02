package com.revature;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.reston.models.Employee;
import com.reston.repositories.EmployeeDaoImp;
import com.reston.services.EmployeeService;

public class DriverTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		assertTrue(true);
	}
	
	private EmployeeService eserv;
	
	private EmployeeDaoImp edaoImpl;
	
	@Before
	public void setup() {
		
		eserv = new EmployeeService();
		
		edaoImpl = mock(EmployeeDaoImp.class);
		
		eserv.eDao = edaoImpl;
		
	}
	
	
	@Test
	public void happyPathScenario() {
		
		Employee sampleEmployee = new Employee(1,"a", "b", "c", "d", null, null, null, null, 0, null);
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(sampleEmployee);
		
		when(edaoImpl.findAll()).thenReturn(list);
		
		Employee foundByUsername = eserv.findByUsername(sampleEmployee.getUsername());
		
		assertEquals(sampleEmployee, foundByUsername);
		
		
		
	}
	
	@Test
	public void employeeIsNotPresentInDB() {
		
		
		
		List<Employee> emptyList = new ArrayList<Employee>();
		
		when(edaoImpl.findAll()).thenReturn(emptyList);
		
		
		
		Employee employeeFoundByUsername = eserv.findByUsername("tester");
		
		assertEquals(null, employeeFoundByUsername);
	}
	

}
