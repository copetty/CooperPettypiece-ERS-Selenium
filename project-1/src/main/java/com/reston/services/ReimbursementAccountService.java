package com.reston.services;

import java.util.List;

import com.reston.models.ReimTemplate;
import com.reston.models.ReimbursementAccount;
import com.reston.repositories.ReimbursementAccountDao;
import com.reston.repositories.ReimbursementAccountDaoImp;

public class ReimbursementAccountService {

	public static ReimbursementAccountDao raDao = new ReimbursementAccountDaoImp();

	public static int insert(ReimbursementAccount ra) {
		return raDao.insert(ra);
	}

	public static List<ReimbursementAccount> returnAllReimbursementAccount() {
		return raDao.findAll();
	}

	public static List<ReimTemplate> returnReimbursementRequests() {
		return raDao.findPendingReimbursementAccountByNotReviewed();
	}

	public static List<ReimTemplate> findNotApprovedReimbursementRequestById(int id) {

		return raDao.findPendingReimbursementAccountById(id);

	}

	public static List<ReimTemplate> findReviewedReimbursementRequestById(int id) {

		return raDao.findReviewedReimbursementAccountById(id);
	}
	
	public static List<ReimbursementAccount> resolvedRequests(){
		return raDao.findAllResolvedRequests();
	}

	public static ReimbursementAccount insertNewAgainTry(String firstName, String lastName, int reimbursementAmount,
			String reimbursementReason, Boolean reviewed, Boolean approved, int id, String reviewedBy) {
		// TODO Auto-generated method stub
		return raDao.insertNewTry(firstName, lastName, reimbursementAmount, reimbursementReason, reviewed, approved,
				id, reviewedBy);

	}
	
	public static ReimbursementAccount approveReimbursement(int accountId, String reviewedBy) {
		return raDao.approveRequest(accountId, reviewedBy);
	}
	
	public static ReimbursementAccount denyReimbursement(int accountId, String reviewedBy) {
		return raDao.denyRequest(accountId, reviewedBy);
	}
	
	public static List<ReimTemplate> findPendingByFirstAndLast(String firstName, String lastName) {

		return raDao.findPendingRequestsByFirstAndLastName(firstName, lastName);
	}
	
	
}
