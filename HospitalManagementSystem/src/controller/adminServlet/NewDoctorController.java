package controller.adminServlet;

import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bean.Doctor;
import model.bl.AdminBusinessLogic;


/**
 * Servlet implementation class NewAppointmentController
 */
public class NewDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewDoctorController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String doctorId=request.getParameter("id");
		String doctorName=request.getParameter("name");
		String specialization=request.getParameter("specialization");
		String timing=request.getParameter("timing");
		//String address=request.getParameter("address");
		Long phoneno=Long.parseLong(request.getParameter("phone"));
		String password=request.getParameter("password");
		//Integer departmentId=Integer.parseInt(request.getParameter("fee"));
		//int regNo= Math.abs((int) currentDate.getTime());
		AdminBusinessLogic abl=new AdminBusinessLogic();
		Doctor newDoctor = new Doctor();
		newDoctor.setDoctorId(doctorId);
		newDoctor.setDoctorName(doctorName);
		newDoctor.setSpecialization(specialization);
		newDoctor.setTiming(timing);
		//newDoctor.setDoctorAddress(address);
		newDoctor.setDoctorPhoneNo(phoneno);
		newDoctor.setDoctorPassword(password);
		try {
			try {
				boolean status=abl.addDoctor(newDoctor);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.setAttribute("doctor",newDoctor);
			String servlet="./admin.jsp";
			String button="CONTINUE";
			
		request.setAttribute("servlet", servlet);
		request.setAttribute("button", button);

		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newDoctor.jsp");
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
