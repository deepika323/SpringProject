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

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.doctorServlet.addMedicalReportController;
import model.bean.Appointment;
import model.bean.MedicalReport;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;

@Controller
@RequestMapping("/")
public class NewAppointmentController{
	
	private static Logger logger=Logger.getLogger(NewAppointmentController.class);
	
	@RequestMapping("/NewAppointmentController")
	public ModelAndView addMedicalReport(@ModelAttribute("appointment") Appointment appointment){
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		try {
			abl.addAppointment(appointment);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(appointment);
		ModelAndView mv=new ModelAndView();
		mv.addObject(appointment);
		mv.setViewName("newAppointment");
		return mv;
	}
}

//public class NewAppointmentController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public NewAppointmentController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String personId=request.getParameter("personId");
//		String doctorId=request.getParameter("doctorId");
//		Integer fee=Integer.parseInt(request.getParameter("fee"));
//		String puspose=request.getParameter("purpose");
//		Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
//		int regNo= Math.abs((int) currentDate.getTime());
//		AdminBusinessLogic abl=new AdminBusinessLogic();
//		Appointment newAppointment=new Appointment();
//		newAppointment.setAppointmentDate(currentDate);
//		newAppointment.setDoctorId(doctorId);
//		newAppointment.setPayment(fee);
//		newAppointment.setPersonId(personId);
//		newAppointment.setPurpose(puspose);
//		newAppointment.setRegNo(regNo);
//		try {
//			try {
//				boolean status=abl.addAppointment(newAppointment);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		 request.setAttribute("appointment",newAppointment);
//			String servlet="./admin.jsp";
//			String button="CONTINUE";
//			
//		request.setAttribute("servlet", servlet);
//		request.setAttribute("button", button);
//
//		
//		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newAppointment.jsp");
//		    rd.forward(request, response);
//		
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
