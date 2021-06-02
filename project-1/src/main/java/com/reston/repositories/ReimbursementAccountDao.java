package com.reston.repositories;

import java.util.List;

import com.reston.models.Employee;
import com.reston.models.ReimTemplate;
import com.reston.models.ReimbursementAccount;
import com.reston.util.ConnectionUtil;

public interface ReimbursementAccountDao {

	// create
	public int insert(ReimbursementAccount ra);
	public ReimbursementAccount insertNewTry(String firstName, String lastName, int reimbursementAmount, String reimbursementReason,
			Boolean reviewed, Boolean approved, int id, String reviewedBy);
	
	// read
	public List<ReimbursementAccount> findAll();
	public List<ReimTemplate> findPendingReimbursementAccountById(int id);
	public List<ReimTemplate> findReviewedReimbursementAccountById(int id);
	public List<ReimTemplate> findPendingReimbursementAccountByNotReviewed();
	public List<ReimbursementAccount> findAllResolvedRequests();
	public List<ReimTemplate> findPendingRequestsByFirstAndLastName(String firstName, String lastName);

	// update
	
	public ReimbursementAccount approveRequest(int accoundId, String reviewedBy);
	public ReimbursementAccount denyRequest(int accountId, String reviewedBy);
	
	
	// delete
}
