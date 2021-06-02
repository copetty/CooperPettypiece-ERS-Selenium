package tester;

import com.reston.models.Employee;
import com.reston.models.ReimbursementAccount;
import com.reston.repositories.EmployeeDao;
import com.reston.repositories.EmployeeDaoImp;
import com.reston.services.EmployeeService;
import com.reston.services.ReimbursementAccountService;

public class Test {

	static EmployeeService es = new EmployeeService();
	
	static ReimbursementAccountService ras = new ReimbursementAccountService();

	public static void main(String[] args) {

		Employee some = new Employee("bill", "bill123", "Bill", "Bob", "315-605-2609", "bill@example.com",
				"940 dime dr", "XXX-XX-9252", 22000, false);

		es.insert(some);
//		System.out.println(es.returnAllEmployee());
		
		//System.out.println(es.confirmLogin("coop", "coop123"));
		
		//EmployeeDao eDao = new EmployeeDaoImp();
		
		//System.out.println(es.checkingManager("may"));
		
//		ReimbursementAccount some = new ReimbursementAccount("Cooper", "Petty", 323, "Bought something unreasonable", 100000);
//
//ras.insertNewAgainTry("Cooper"	,"Petty",	300,"idk",	false	,false,	100000);

//Cooper	Petty	320	Bought a coffee maker	true	false	100000
//Cooper	Petty	200	Bought some donuts	false	false	100000
//Cooper	Petty	30	Bought a gym membership	false	false	100000
//Cooper	Petty	300	idk	false	false	100000



//		
//	System.out.println(ras.returnAllReimbursementAccount());
		
	//	System.out.println(ras.findNotApprovedReimbursementRequestById(100000));
		
		//System.out.println(ras.findReviewedReimbursementRequestById(100000));
		
	//	System.out.println(ras.returnReimbursementRequests());	
		
	//ras.approveReimbursement(100001);
		
		//System.out.println(ras.findNotApprovedReimbursementRequestById(100000));
		
	
//		System.out.println(ras.findPendingByFirstAndLast("Cooper", "Petty"));
		
		//System.out.println(es.returnNotManagers());
		
//		System.out.println(es.returnSingleEmployeeInfo(100000));
		
//		System.out.println(es.updateUName(100003, "rugie"));
		

	}

}
