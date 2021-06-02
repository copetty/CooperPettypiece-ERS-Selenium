package com.reston.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.reston.models.ReimTemplate;
import com.reston.models.ReimbursementAccount;
import com.reston.util.ConnectionUtil;

public class ReimbursementAccountDaoImp implements ReimbursementAccountDao{

	private static final Logger log = Logger.getLogger(ReimbursementAccountDaoImp.class);

	@Override
	public int insert(ReimbursementAccount ra) {

		try {
			Connection conn = ConnectionUtil.getConnection();

			String columns = "first_name, last_name, reimbursement, reimbursement_reason, reviewed, approved, id";
			String sql = "INSERT INTO \"ProjectOne\".\"reimbursement_requests\" (" + columns + ") VALUES(?,?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, ra.getFirstName());
			stmt.setString(2, ra.getLastName());
			stmt.setInt(3, ra.getReimbursementAmount());
			stmt.setString(4, ra.getReimbursementReason());
			stmt.setBoolean(5, ra.getReviewed());
			stmt.setBoolean(6, ra.getApproved());
			stmt.setInt(7, ra.getId());

			return stmt.executeUpdate();
			

		} catch (SQLException e) {
			log.warn("SQL Excepton");
			e.printStackTrace();
		}
		log.info("Reimbursement Request Created");
		return 0;
	}

	@Override
	public List<ReimbursementAccount> findAll() {
List<ReimbursementAccount> allReimbursementAccount = new ArrayList<ReimbursementAccount>();
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT * FROM \"ProjectOne\".\"reimbursement_requests\"";
		
		try {
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int accountId = rs.getInt("account_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int reimbursementAmount= rs.getInt("reimbursement");
				String reimbursementReason = rs.getString("reimbursement_reason");
				boolean reviewed = rs.getBoolean("reviewed");
				boolean approved = rs.getBoolean("approved");
				int id = rs.getInt("id");
				String reviewedBy = rs.getString("reviewed_by");
				
				
				ReimbursementAccount ra = new ReimbursementAccount(accountId, firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved, id, reviewedBy);
				
				allReimbursementAccount.add(ra);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
			return new ArrayList<ReimbursementAccount>();
		}
		
		
		return allReimbursementAccount;
		
	}

	@Override
	public List<ReimTemplate> findPendingReimbursementAccountById(int id) {
		
		List<ReimTemplate> allPendingReimbursementReq = new ArrayList<ReimTemplate>();
		
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT account_id, first_name, last_name, reimbursement, reimbursement_reason, reviewed, approved, id FROM \"ProjectOne\".\"reimbursement_requests\" WHERE id = ? AND reviewed = false";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
//			Statement stmt = conn.createStatement();
			
			
			while(rs.next()) {
				
				int accountId = rs.getInt("account_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int reimbursementAmount= rs.getInt("reimbursement");
				String reimbursementReason = rs.getString("reimbursement_reason");
				boolean reviewed = rs.getBoolean("reviewed");
				boolean approved = rs.getBoolean("approved");
				int id1 = rs.getInt("id");
				
				
				ReimTemplate rt = new ReimTemplate(accountId, firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved, id1);
				
				allPendingReimbursementReq.add(rt);
				log.info("this is what ra is " + rt);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		return allPendingReimbursementReq;
	}

	@Override
	public List<ReimTemplate> findReviewedReimbursementAccountById(int id) {
List<ReimTemplate> allPendingReimbursementReq = new ArrayList<ReimTemplate>();
		
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT account_id, first_name, last_name, reimbursement, reimbursement_reason, reviewed, approved, id FROM \"ProjectOne\".\"reimbursement_requests\" WHERE id = ? AND reviewed = true";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
//			Statement stmt = conn.createStatement();
			
			
			while(rs.next()) {
				
				int accountId = rs.getInt("account_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int reimbursementAmount= rs.getInt("reimbursement");
				String reimbursementReason = rs.getString("reimbursement_reason");
				boolean reviewed = rs.getBoolean("reviewed");
				boolean approved = rs.getBoolean("approved");
				int id1 = rs.getInt("id");
				
				
				ReimTemplate rt = new ReimTemplate(accountId, firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved, id1);
				
				allPendingReimbursementReq.add(rt);
				
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		return allPendingReimbursementReq;
	}

	@Override
	public ReimbursementAccount insertNewTry(String firstName, String lastName, int reimbursementAmount,
			String reimbursementReason, Boolean reviewed, Boolean approved, int id, String reviewedBy) {
		
		ReimbursementAccount ra = new ReimbursementAccount();
		
		Connection conn = ConnectionUtil.getConnection();
		
		String columns = "first_name, last_name, reimbursement, reimbursement_reason, reviewed, approved, id, reviewed_by";
		String sql = "INSERT INTO \"ProjectOne\".\"reimbursement_requests\" (" + columns + ") VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			

			

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setInt(3, reimbursementAmount);
			ps.setString(4, reimbursementReason);
			ps.setBoolean(5, reviewed);
			ps.setBoolean(6, approved);
			ps.setInt(7, id);
			ps.setString(8, reviewedBy);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {

			ra.setFirstName(firstName);
			ra.setLastName(lastName);
			ra.setReimbursementAmount(reimbursementAmount);
			ra.setReimbursementReason(reimbursementReason);
			ra.setReviewed(reviewed);
			ra.setApproved(approved);
			ra.setId(id);
			ra.setReviewedBy(reviewedBy);

			
			}

		} catch (SQLException e) {
			log.warn("SQL Excepton");
			return ra;
		}
		log.info("Reimbursement Request Created");
		return ra;
	}

	@Override
	public List<ReimTemplate> findPendingReimbursementAccountByNotReviewed() {
		
List<ReimTemplate> allReimbursementAccountNotReview = new ArrayList<ReimTemplate>();
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT account_id, first_name, last_name, reimbursement, reimbursement_reason, reviewed, approved, id FROM \"ProjectOne\".\"reimbursement_requests\" WHERE reviewed = false";
		
		try {
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int accountId = rs.getInt("account_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int reimbursementAmount= rs.getInt("reimbursement");
				String reimbursementReason = rs.getString("reimbursement_reason");
				boolean reviewed = rs.getBoolean("reviewed");
				boolean approved = rs.getBoolean("approved");
				int id = rs.getInt("id");
				
				
				ReimTemplate rt = new ReimTemplate(accountId, firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved, id);
				
				allReimbursementAccountNotReview.add(rt);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
			return new ArrayList<ReimTemplate>();
		}
		
		
		return allReimbursementAccountNotReview;
		
	}

	@Override
	public ReimbursementAccount approveRequest(int accountId, String reviewedBy) {
		
		ReimbursementAccount a = new ReimbursementAccount(2);
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "UPDATE \"ProjectOne\".reimbursement_requests SET reviewed = true, approved = true, reviewed_by = ? WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, reviewedBy);
			ps.setInt(2, accountId);
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("reimbursement was approved!");
		return a;
	}

	@Override
	public ReimbursementAccount denyRequest(int accountId, String reviewedBy) {
		
		ReimbursementAccount a = new ReimbursementAccount(2);
		
		try {
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "UPDATE \"ProjectOne\".reimbursement_requests SET reviewed = true, approved = false, reviewed_by = ? WHERE account_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, reviewedBy);
			ps.setInt(2, accountId);
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("reimbursement was denied:(!");
		return a;
	}

	@Override
	public List<ReimbursementAccount> findAllResolvedRequests() {
		List<ReimbursementAccount> allResolved = new ArrayList<ReimbursementAccount>();
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT * FROM \"ProjectOne\".reimbursement_requests WHERE reviewed = true";
		
		try {
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int accountId = rs.getInt("account_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int reimbursementAmount= rs.getInt("reimbursement");
				String reimbursementReason = rs.getString("reimbursement_reason");
				boolean reviewed = rs.getBoolean("reviewed");
				boolean approved = rs.getBoolean("approved");
				int id = rs.getInt("id");
				String reviewedBy = rs.getString("reviewed_by");
				
				
				ReimbursementAccount ra = new ReimbursementAccount(accountId, firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved, id, reviewedBy);
				
				allResolved.add(ra);
			}
		
		} catch(SQLException e) {
			e.printStackTrace();
			return new ArrayList<ReimbursementAccount>();
		}
		
		
		return allResolved;
	}

	@Override
	public List<ReimTemplate> findPendingRequestsByFirstAndLastName(String firstName, String lastName) {
		List<ReimTemplate> employeePendingReim = new ArrayList<ReimTemplate>();
		
		
		Connection conn = ConnectionUtil.getConnection();
		
		String sql = "SELECT account_id, first_name, last_name, reimbursement, reimbursement_reason, reviewed, approved, id FROM \"ProjectOne\".reimbursement_requests WHERE reviewed = false AND approved = false AND first_name = ? AND last_name = ?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ResultSet rs = ps.executeQuery();
			
//			Statement stmt = conn.createStatement();
			
			
			while(rs.next()) {
				
				int accountId = rs.getInt("account_id");
				String firstName1 = rs.getString("first_name");
				String lastName1 = rs.getString("last_name");
				int reimbursementAmount= rs.getInt("reimbursement");
				String reimbursementReason = rs.getString("reimbursement_reason");
				boolean reviewed = rs.getBoolean("reviewed");
				boolean approved = rs.getBoolean("approved");
				int id1 = rs.getInt("id");
				
				
				ReimTemplate rt = new ReimTemplate(accountId, firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved, id1);
				
				employeePendingReim.add(rt);
				
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
		return employeePendingReim;
	}

	}

		
	



		
			


		
		


