package com.reston.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.reston.models.Employee;
import com.reston.models.ReimTemplate;
import com.reston.models.ReimbursementAccount;
import com.reston.util.ConnectionUtil;

public class EmployeeDaoImp implements EmployeeDao {
	
	private static final Logger log = Logger.getLogger(ReimbursementAccountDaoImp.class);

	@Override
	public int insert(Employee emp) {

		try {
			Connection conn = ConnectionUtil.getConnection();

			String columns = "username, password, first_name, last_name, phone_number, email, address, social_security_number, salary, manager";
			String sql = "INSERT INTO \"ProjectOne\".\"employee\" (" + columns + ") VALUES(?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, emp.getUsername());
			stmt.setString(2, emp.getPassword());
			stmt.setString(3, emp.getFirstName());
			stmt.setString(4, emp.getLastName());
			stmt.setString(5, emp.getPhoneNumber());
			stmt.setString(6, emp.getEmail());
			stmt.setString(7, emp.getAddress());
			stmt.setString(8, emp.getSocialSecurityNumber());
			stmt.setInt(9, emp.getSalary());
			stmt.setBoolean(10, emp.getManager());

			return stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Employee> findAll() {
		
		List<Employee> allEmployee = new ArrayList<Employee>();
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT * FROM \"ProjectOne\".\"employee\"";
		
		try {
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String socialSecurityNumber = rs.getString("social_security_number");
				int salary = rs.getInt("salary");
				boolean manager = rs.getBoolean("manager");
				
				Employee emp = new Employee(id, username, password, firstName, lastName, phoneNumber, email, address, socialSecurityNumber, salary, manager);
				
				allEmployee.add(emp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Employee>();
		}
		
		
		
		return allEmployee;
	}
	
	
	

	@Override
	public Employee findByFirstAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Employee checkManagerByUsername(String username) {
		
		
		
		Employee emp = new Employee();
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT \"employee\".manager FROM \"ProjectOne\".\"employee\" WHERE \"username\" = 'coop'";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
		while (rs.next()) {
				
				emp.setId(rs.getInt(1));
				emp.setUsername(username);
				emp.setPassword(rs.getString(3));
				emp.setFirstName(rs.getString(4));
				emp.setLastName(rs.getString(5));
				emp.setPhoneNumber(rs.getString(6));
				emp.setEmail(rs.getString(7));
				emp.setAddress(rs.getString(8));
				emp.setSocialSecurityNumber(rs.getString(9));
				emp.setSalary(rs.getInt(10));
				emp.setManager(rs.getBoolean(11));
				
		}
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}
		return emp;
	}

	@Override
	public String updateEmployeeUsername(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> findAllEmployees() {
List<Employee> allEmployee = new ArrayList<Employee>();
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT * FROM \"ProjectOne\".employee WHERE manager = false";
		
		try {
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String socialSecurityNumber = rs.getString("social_security_number");
				int salary = rs.getInt("salary");
				boolean manager = rs.getBoolean("manager");
				
				Employee emp = new Employee(id, username, password, firstName, lastName, phoneNumber, email, address, socialSecurityNumber, salary, manager);
				
				allEmployee.add(emp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Employee>();
		}
		
		
		
		return allEmployee;
	}

	@Override
	public List<Employee> findEmployeeById(int id) {
		List<Employee> singleEmployee = new ArrayList<Employee>();
		
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT * FROM \"ProjectOne\".employee WHERE id = ?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
//			Statement stmt = conn.createStatement();
			
			
			while(rs.next()) {
				
				
				
				int id1 = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String socialSecurityNumber = rs.getString("social_security_number");
				int salary = rs.getInt("salary");
				boolean manager = rs.getBoolean("manager");
				
//				emp.setId(rs.getInt(1));
//				emp.setUsername(username);
//				emp.setPassword(rs.getString(3));
//				emp.setFirstName(rs.getString(4));
//				emp.setLastName(rs.getString(5));
//				emp.setPhoneNumber(rs.getString(6));
//				emp.setEmail(rs.getString(7));
//				emp.setAddress(rs.getString(8));
//				emp.setSocialSecurityNumber(rs.getString(9));
//				emp.setSalary(rs.getInt(10));
//				emp.setManager(rs.getBoolean(11));
				
				
				Employee e = new Employee(id, username, password, firstName, lastName, phoneNumber, email, address, socialSecurityNumber, salary, manager);
				
				singleEmployee.add(e);
				log.info("this is what ra is " + e);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		return singleEmployee;
	}

		

	@Override
	public Employee updateUsername(int id, String username) {

		Employee e = new Employee(2);
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "UPDATE \"ProjectOne\".employee SET username = ? WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setInt(2, id);
			ps.execute();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		log.info("Employee Updated!");
		return e;
	}

	@Override
	public Employee updatePassword(int id, String password) {

		Employee e = new Employee(2);
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "UPDATE \"ProjectOne\".employee SET password = ? WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, password);
			ps.setInt(2, id);
			ps.execute();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		log.info("Employee Updated!");
		return e;
	}

	@Override
	public Employee updatePhoneNumber(int id, String phoneNumber) {

		Employee e = new Employee(2);
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "UPDATE \"ProjectOne\".employee SET phone_number = ? WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, phoneNumber);
			ps.setInt(2, id);
			ps.execute();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		log.info("Employee Updated!");
		return e;
	}

	@Override
	public Employee updateEmail(int id, String email) {

		Employee e = new Employee(2);
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "UPDATE \"ProjectOne\".employee SET email = ? WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setInt(2, id);
			ps.execute();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		log.info("Employee Updated!");
		return e;
	}

	@Override
	public Employee updateAddress(int id, String address) {

		Employee e = new Employee(2);
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "UPDATE \"ProjectOne\".employee SET address = ? WHERE id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, address);
			ps.setInt(2, id);
			ps.execute();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		log.info("Employee Updated!");
		return e;
	}

	

	

}
