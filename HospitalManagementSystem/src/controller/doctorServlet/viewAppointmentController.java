package controller.doctorServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Reception;
import model.bl.DoctorBusinessLogic;

public class viewAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList<Reception> appList=null;
		int doctorId=Integer.parseInt(request.getParameter("doctorId"));
		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		try {
			try {
				appList=dbl.myAppointments(doctorId);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(request.getParameter("doctorId")==null){
			String message="Doctor not found";
			session.setAttribute("message", message);
			response.sendRedirect("output.jsp");
		}
}

		


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
