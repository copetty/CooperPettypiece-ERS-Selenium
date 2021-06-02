package com.reston.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reston.util.RequestHelper;

import jdk.internal.org.jline.utils.Log;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final String URI = request.getRequestURI().replace("/project-1/", ""); // I think this is just to clean up the url // i was wrong i think
		
		switch(URI) {
		case "login":
			RequestHelper.processLogin(request, response);
			break;
		case "logout":
			RequestHelper.processLogout(request,response);
			break;
		case "employeeRequests":
			RequestHelper.locatePendingReimbursementRequests(request, response);
			break;
		case "employeeReviewed":
			RequestHelper.locateReviewedReimbursementRequestsById(request, response);
			break;
		case "sendRequestPage":
			RequestHelper.processEmployees(request, response);
			break;
		case "sendReimRequest":
			RequestHelper.sendReimbursementRequest(request, response);
			break;
		case "reviewRequest":
			RequestHelper.reviewRequests(request, response);
			break;
		case "requestApproved":
			RequestHelper.approveRequests(request, response);
			break;
		case "requestDenied":
			RequestHelper.dissapproveRequests(request, response);
			break;
		case "lookUpResolvedReq":
			RequestHelper.returnResolvedRequests(request, response);
			break;
		case "resolveOne":
			break;
		case "sendLookUp":
			RequestHelper.findPendingRequestsByFirstAndLast(request, response);
			break;
		case "empList":
			RequestHelper.returnEmployees(request, response);
			break;
		case "returnMyself":
			RequestHelper.returnSingleEmployee(request, response);
			break;
		case "updtUsername":
			RequestHelper.upUsername(request, response);
			break;
		case "updtPassword":
			RequestHelper.upPassword(request, response);
			break;
		case "updtPhoneNumber":
			RequestHelper.upPhoneNumber(request, response);
			break;
		case "updtEmail":
			RequestHelper.upEmail(request, response);
			break;
		case "updtAddress":
			RequestHelper.upAddress(request, response);
			break;
		
			
		
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
