package controller.patientServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Appointment;
import model.bl.PersonBusinessLogic;



public class ListAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PersonBusinessLogic pb = new PersonBusinessLogic();
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String personId=request.getParameter("personId");
		ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
		try {
			try {
				appointmentList=pb.myAppointments(personId);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.setAttribute("appList", appointmentList);
		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewAppointment.jsp");
		    rd.forward(request, response);
		if(request.getParameter("personId")==null){
			String message="Patient not found";
			session.setAttribute("message", message);
			response.sendRedirect("ErrorPage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
