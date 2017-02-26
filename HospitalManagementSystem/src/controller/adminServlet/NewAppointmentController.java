package controller.adminServlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Appointment;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;

/**
 * Servlet implementation class NewAppointmentController
 */
public class NewAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAppointmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String personId=request.getParameter("personId");
		String doctorId=request.getParameter("doctorId");
		Integer fee=Integer.parseInt(request.getParameter("fee"));
		String puspose=request.getParameter("purpose");
		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		int regNo= Math.abs((int) currentDate.getTime());
		AdminBusinessLogic abl=new AdminBusinessLogic();
		Appointment newAppointment=new Appointment();
		newAppointment.setAppointmentDate(currentDate);
		newAppointment.setDoctorId(doctorId);
		newAppointment.setPayment(fee);
		newAppointment.setPersonId(personId);
		newAppointment.setPurpose(puspose);
		newAppointment.setRegNo(regNo);
		try {
			try {
				boolean status=abl.addAppointment(newAppointment);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.setAttribute("appointment",newAppointment);
		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newAppointment.jsp");
		    rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
