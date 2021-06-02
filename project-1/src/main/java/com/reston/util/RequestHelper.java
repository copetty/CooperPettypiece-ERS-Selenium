package com.reston.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reston.models.Employee;
import com.reston.models.LoginTemplate;
import com.reston.models.ReimTemplate;
import com.reston.models.ReimbursementAccount;
import com.reston.services.EmployeeService;
import com.reston.services.ReimbursementAccountService;

import jdk.internal.org.jline.utils.Log;

public class RequestHelper {
	
	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
	BufferedReader reader = req.getReader();
	StringBuilder sb = new StringBuilder();
	
	String line = reader.readLine();
	
	while (line != null) {
		sb.append(line);
		line = reader.readLine();
	}
	
	String body = sb.toString();
	log.info(body);
	
	
	LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
	
	String username = loginAttempt.getUsername();
	String password = loginAttempt.getPassword();
	
	log.info("User attempted to login with username :" + username);
	Employee emp = EmployeeService.confirmLogin(username, password);
	
	if (emp != null) {
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		
		pw.println(om.writeValueAsString(emp));
		
		log.info(username + " has successfully logged in!");
	} else {
		res.setStatus(204);
	}
	
	}
	
	// logout should go here
	
	
	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setContentType("application/json");
		
		List<Employee> allEmps = EmployeeService.returnAllEmployee();
		
		String json = om.writeValueAsString(allEmps);
		
		PrintWriter pw = res.getWriter();
		
		pw.println(json);
		
	}
	
	public static void locatePendingReimbursementRequests(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = sb.toString();
		log.info(body);
		
		ReimTemplate reimAccount = om.readValue(body, ReimTemplate.class);
		
		int id = reimAccount.getId();

		
		log.info("User attempted to get pending requests with :" + id);
		List<ReimTemplate> ra = ReimbursementAccountService.findNotApprovedReimbursementRequestById(id);
		
		if (ra != null) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(om.writeValueAsString(ra));
			
			log.info(id + " has successfully captured their pending requests!");
		} else {
			res.setStatus(204);
		}
		
		
	}
	
	public static void locateReviewedReimbursementRequestsById(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = sb.toString();
		log.info(body);
		
		ReimTemplate reimAccount = om.readValue(body, ReimTemplate.class);
		
		int id = reimAccount.getId();

		
		log.info("User attempted to get reviewed requests with :" + id);
		List<ReimTemplate> ra = ReimbursementAccountService.findReviewedReimbursementRequestById(id);
		
		if (ra != null) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(om.writeValueAsString(ra));
			
			log.info(id + " has successfully captured their pending requests!");
		} else {
			res.setStatus(204);
		}
		
		
	}
	
	public static void sendReimbursementRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = sb.toString();
		log.info(body);
		
		
		ReimbursementAccount requestAttempt = om.readValue(body, ReimbursementAccount.class);
		
		String firstName = requestAttempt.getFirstName();
		String lastName = requestAttempt.getLastName();
		int reimbursementAmount = requestAttempt.getReimbursementAmount();
		String reimbursementReason = requestAttempt.getReimbursementReason();
		Boolean reviewed = requestAttempt.getReviewed();
		Boolean approved = requestAttempt.getApproved();
		int id = requestAttempt.getId();
		String reviewedBy = requestAttempt.getReviewedBy();
		
		log.info("User attempted to send reimbursement with first name :" + firstName);
		//Employee emp = EmployeeService.confirmLogin(username, password);
		ReimbursementAccount ra = ReimbursementAccountService.insertNewAgainTry(firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved, id, reviewedBy);
		
		
		if (ra != null) {
			HttpSession session = req.getSession();
			session.setAttribute("firstName", firstName);
			
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(om.writeValueAsString(ra));
			
			log.info(firstName + " has successfully logged in!");
		} else {
			res.setStatus(204);
		}
		
		}
	
	public static void reviewRequests(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setContentType("application/json");
		
//		List<Employee> allEmps = EmployeeService.returnAllEmployee();
		List<ReimTemplate> ra = ReimbursementAccountService.returnReimbursementRequests();
		
		String json = om.writeValueAsString(ra);
		
		PrintWriter pw = res.getWriter();
		
		pw.println(json);
		
	}
	
	public static void approveRequests(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = sb.toString();
		log.info(body);
		
		
		ReimbursementAccount approveReq = om.readValue(body, ReimbursementAccount.class);
		
		int accountId = approveReq.getAccountId();
		String reviewedBy = approveReq.getReviewedBy();
		
		log.info("Manager approved request with account id :" + accountId);
		log.info("manager " + reviewedBy + " reveiwed request with id " + accountId);
		//Employee emp = EmployeeService.confirmLogin(username, password);
		//ReimbursementAccount ra = ReimbursementAccountService.insertNewAgainTry(firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved, id);
		ReimbursementAccount ra = ReimbursementAccountService.approveReimbursement(accountId, reviewedBy);
		
		if (ra != null) {
			HttpSession session = req.getSession();
			session.setAttribute("accountId", accountId);
			
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(om.writeValueAsString(ra));
			
			log.info(accountId + " was successfully approved");
		} else {
			res.setStatus(204);
		}
		
	}
	
public static void dissapproveRequests(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = sb.toString();
		log.info(body);
		
		
		ReimbursementAccount denyReq = om.readValue(body, ReimbursementAccount.class);
		
		
		int accountId = denyReq.getAccountId();
		String reviewedBy = denyReq.getReviewedBy();
		
		log.info("Manager denied request with account id :" + accountId);
		//Employee emp = EmployeeService.confirmLogin(username, password);
		//ReimbursementAccount ra = ReimbursementAccountService.insertNewAgainTry(firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved, id);
		ReimbursementAccount ra = ReimbursementAccountService.denyReimbursement(accountId, reviewedBy);
		
		if (ra != null) {
			HttpSession session = req.getSession();
			session.setAttribute("accountId", accountId);
			
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(om.writeValueAsString(ra));
			
			log.info(accountId + " was successfully denied");
			log.info(reviewedBy + " just denied request number " + accountId); 
		} else {
			res.setStatus(204);
		}
		
	}

	public static void returnResolvedRequests(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
	res.setContentType("application/json");
	
//	List<Employee> allEmps = EmployeeService.returnAllEmployee();
	List<ReimbursementAccount> ra = ReimbursementAccountService.resolvedRequests();
	
	String json = om.writeValueAsString(ra);
	
	PrintWriter pw = res.getWriter();
	
	pw.println(json);
	
}
	
	public static void findPendingRequestsByFirstAndLast(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = sb.toString();
		log.info(body);
		
		ReimTemplate reimAccount = om.readValue(body, ReimTemplate.class);
		
//		int id = reimAccount.getId();
		String firstName = reimAccount.getFirstName();
		String lastName = reimAccount.getLastName();

		
		log.info("User attempted to get pending requests with :" + firstName + " " + lastName);
		List<ReimTemplate> ra = ReimbursementAccountService.findPendingByFirstAndLast(firstName, lastName);
		
		if (ra != null) {
			HttpSession session = req.getSession();
			session.setAttribute("firstName", firstName);
			
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(om.writeValueAsString(ra));
			
			log.info(firstName + " has been looked up!");
		} else {
			res.setStatus(204);
		}
		
		

	}
	
	
	public static void returnEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		res.setContentType("application/json");
		
		List<Employee> allEmps = EmployeeService.returnNotManagers();
		
		String json = om.writeValueAsString(allEmps);
		
		PrintWriter pw = res.getWriter();
		
		pw.println(json);
		
	}
	
public static void returnSingleEmployee(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		
		String line = reader.readLine();
		
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}
		
		String body = sb.toString();
		log.info(body);
		
		Employee empReturn = om.readValue(body, Employee.class);
		
		int id = empReturn.getId();

		
		log.info("User attempted to get reviewed requests with :" + id);
		List<Employee> ra = EmployeeService.returnSingleEmployeeInfo(id);
		
		if (ra != null) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			pw.println(om.writeValueAsString(ra));
			
			log.info(id + " has successfully captured their pending requests!");
		} else {
			res.setStatus(204);
		}
		
		
	}

public static void upUsername(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
	
	BufferedReader reader = req.getReader();
	StringBuilder sb = new StringBuilder();
	
	String line = reader.readLine();
	
	while (line != null) {
		sb.append(line);
		line = reader.readLine();
	}
	
	String body = sb.toString();
	log.info(body);
	
	
	Employee updateEmp = om.readValue(body, Employee.class);
	
	int id = updateEmp.getId();
	String username = updateEmp.getUsername();
	
	log.info("Employee with id :" + id + " was updated!");
	Employee e = EmployeeService.updateUName(id, username);
	
	if (e != null) {
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		
		pw.println(om.writeValueAsString(e));
		
		log.info(id + " was successfully updated!");
	} else {
		res.setStatus(204);
	}
	
}


public static void upPassword(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
	
	BufferedReader reader = req.getReader();
	StringBuilder sb = new StringBuilder();
	
	String line = reader.readLine();
	
	while (line != null) {
		sb.append(line);
		line = reader.readLine();
	}
	
	String body = sb.toString();
	log.info(body);
	
	
	Employee updateEmp = om.readValue(body, Employee.class);
	
	int id = updateEmp.getId();
	String password = updateEmp.getPassword();
	
	log.info("Employee with id :" + id + " was updated!");
	Employee e = EmployeeService.updatePWord(id, password);
	
	if (e != null) {
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		
		pw.println(om.writeValueAsString(e));
		
		log.info(id + " was successfully updated!");
	} else {
		res.setStatus(204);
	}
	
}

public static void upPhoneNumber(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
	
	BufferedReader reader = req.getReader();
	StringBuilder sb = new StringBuilder();
	
	String line = reader.readLine();
	
	while (line != null) {
		sb.append(line);
		line = reader.readLine();
	}
	
	String body = sb.toString();
	log.info(body);
	
	
	Employee updateEmp = om.readValue(body, Employee.class);
	
	int id = updateEmp.getId();
	String phoneNumber = updateEmp.getPhoneNumber();
	
	log.info("Employee with id :" + id + " was updated!");
	Employee e = EmployeeService.updatePNumber(id, phoneNumber);
	
	if (e != null) {
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		
		pw.println(om.writeValueAsString(e));
		
		log.info(id + " was successfully updated!");
	} else {
		res.setStatus(204);
	}
	
}

public static void upEmail(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
	
	BufferedReader reader = req.getReader();
	StringBuilder sb = new StringBuilder();
	
	String line = reader.readLine();
	
	while (line != null) {
		sb.append(line);
		line = reader.readLine();
	}
	
	String body = sb.toString();
	log.info(body);
	
	
	Employee updateEmp = om.readValue(body, Employee.class);
	
	int id = updateEmp.getId();
	String email = updateEmp.getEmail();
	
	log.info("Employee with id :" + id + " was updated!");
	Employee e = EmployeeService.updateMail(id, email);
	
	if (e != null) {
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		
		pw.println(om.writeValueAsString(e));
		
		log.info(id + " was successfully updated!");
	} else {
		res.setStatus(204);
	}
	
}

public static void upAddress(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
	
	BufferedReader reader = req.getReader();
	StringBuilder sb = new StringBuilder();
	
	String line = reader.readLine();
	
	while (line != null) {
		sb.append(line);
		line = reader.readLine();
	}
	
	String body = sb.toString();
	log.info(body);
	
	
	Employee updateEmp = om.readValue(body, Employee.class);
	
	int id = updateEmp.getId();
	String address = updateEmp.getAddress();
	
	log.info("Employee with id :" + id + " was updated!");
	Employee e = EmployeeService.updateAdd(id, address);
	
	if (e != null) {
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		
		PrintWriter pw = res.getWriter();
		res.setContentType("application/json");
		
		pw.println(om.writeValueAsString(e));
		
		log.info(id + " was successfully updated!");
	} else {
		res.setStatus(204);
	}
	
}


public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
	HttpSession session = req.getSession(false); // I'm capturing the session, but if ther isn;t one, I don't create a new one
	
	log.info("Processing logout");
	
	if (session != null) {
		String username = (String) session.getAttribute("username");
		log.info(username + " has logged out");
		session.invalidate();
	}
	
	res.setStatus(200);
}
}
