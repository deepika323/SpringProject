package controller.patientServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bl.PersonBusinessLogic;


public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//code to get bill using bill number.
		HttpSession session=request.getSession();
		int billNo = Integer.parseInt(request.getParameter("billNo"));
		PersonBusinessLogic pb = new PersonBusinessLogic();
		try { 
			if(pb.viewDischargeSummary(billNo).getPatientId()!=0){
				
				request.setAttribute("bill", pb.viewBill(billNo));
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/bill.jsp");
			    rd.forward(request, response);
			}//Add Bill jsp and recheck logic.
			else 
				{
					String message="Bill not found";
					session.setAttribute("message", message);
					response.sendRedirect("ErrorPage.jsp");
				}
		} catch (ClassNotFoundException| IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
