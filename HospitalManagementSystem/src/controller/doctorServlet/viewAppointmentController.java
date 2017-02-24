package controller.doctorServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class viewAppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList<Reception> appList=null;
		String doctorId=request.getParameter("doctorId");
		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		try {
			ArrayList<Reception> appList=dbl.myAppointments(doctor.getDoctorId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(employee==null){
			String message="Employee not found";
			session.setAttribute("message", message);
			response.sendRedirect("output.jsp");
		}
		else{
			session.setAttribute("employee", employee);
			response.sendRedirect("display.jsp");
		}
		}

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
