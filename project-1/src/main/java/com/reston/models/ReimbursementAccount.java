package com.reston.models;

public class ReimbursementAccount {

	/*
	 * Can make a dao that only shows the resolved reibursements and one that only
	 * shows the unresolved reimbursements.
	 * 
	 */

	private int accountId; // primary key
	private String firstName;
	private String lastName;
	private int reimbursementAmount;
	private String reimbursementReason;
	private Boolean reviewed;
	private Boolean approved;
	private int id; // foreign key
	private String reviewedBy;
	
	
	public ReimbursementAccount() {
		
	}


	public ReimbursementAccount(int accountId, String firstName, String lastName, int reimbursementAmount,
			String reimbursementReason, Boolean reviewed, Boolean approved, int id, String reviewedBy) {
		super();
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementReason = reimbursementReason;
		this.reviewed = reviewed;
		this.approved = approved;
		this.id = id;
		this.reviewedBy = reviewedBy;
	}


	public ReimbursementAccount(String firstName, String lastName, int reimbursementAmount, String reimbursementReason,
			Boolean reviewed, Boolean approved, int id, String reviewedBy) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementReason = reimbursementReason;
		this.reviewed = reviewed;
		this.approved = approved;
		this.id = id;
		this.reviewedBy = reviewedBy;
	}


	public ReimbursementAccount(String firstName, String lastName, int reimbursementAmount, String reimbursementReason,
			int id) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementReason = reimbursementReason;
		this.id = id;
	}


	public ReimbursementAccount(int accountId) {
		super();
		this.accountId = accountId;
	}
	


	public ReimbursementAccount(int accountId, String firstName, String lastName, int reimbursementAmount,
			String reimbursementReason, Boolean reviewed, Boolean approved, int id) {
		super();
		this.accountId = accountId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementReason = reimbursementReason;
		this.reviewed = reviewed;
		this.approved = approved;
		this.id = id;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getReimbursementAmount() {
		return reimbursementAmount;
	}


	public void setReimbursementAmount(int reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}


	public String getReimbursementReason() {
		return reimbursementReason;
	}


	public void setReimbursementReason(String reimbursementReason) {
		this.reimbursementReason = reimbursementReason;
	}


	public Boolean getReviewed() {
		return reviewed;
	}


	public void setReviewed(Boolean reviewed) {
		this.reviewed = reviewed;
	}


	public Boolean getApproved() {
		return approved;
	}


	public void setApproved(Boolean approved) {
		this.approved = approved;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getReviewedBy() {
		return reviewedBy;
	}


	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		result = prime * result + ((approved == null) ? 0 : approved.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + reimbursementAmount;
		result = prime * result + ((reimbursementReason == null) ? 0 : reimbursementReason.hashCode());
		result = prime * result + ((reviewed == null) ? 0 : reviewed.hashCode());
		result = prime * result + ((reviewedBy == null) ? 0 : reviewedBy.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementAccount other = (ReimbursementAccount) obj;
		if (accountId != other.accountId)
			return false;
		if (approved == null) {
			if (other.approved != null)
				return false;
		} else if (!approved.equals(other.approved))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (reimbursementAmount != other.reimbursementAmount)
			return false;
		if (reimbursementReason == null) {
			if (other.reimbursementReason != null)
				return false;
		} else if (!reimbursementReason.equals(other.reimbursementReason))
			return false;
		if (reviewed == null) {
			if (other.reviewed != null)
				return false;
		} else if (!reviewed.equals(other.reviewed))
			return false;
		if (reviewedBy == null) {
			if (other.reviewedBy != null)
				return false;
		} else if (!reviewedBy.equals(other.reviewedBy))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ReimbursementAccount [accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", reimbursementAmount=" + reimbursementAmount + ", reimbursementReason=" + reimbursementReason
				+ ", reviewed=" + reviewed + ", approved=" + approved + ", id=" + id + ", reviewedBy=" + reviewedBy
				+ "]";
	}


	
	
}
