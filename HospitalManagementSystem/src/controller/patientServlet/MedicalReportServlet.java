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


public class MedicalReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Code for Getting relevant Medical Report.
		
		HttpSession session=request.getSession();
		String patientId=request.getParameter("patientId");
		PersonBusinessLogic pb = new PersonBusinessLogic();
		
		try { 
			if(pb.viewMedicalReport(Integer.parseInt(patientId)).getPatientId()!=0){
				
				request.setAttribute("report", pb.viewMedicalReport(Integer.parseInt(patientId)));
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/medicalReport.jsp");
			    rd.forward(request, response);
	
			}//Add MedicalReport.jsp and recheck logic.
			else 
			{
				String message="Medical Report not found.";
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
		
		doGet(request, response);
	}

}
