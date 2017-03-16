package controller.patientServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.loginSignUp.LogInController;
import model.bean.Appointment;
import model.bean.Bill;
import model.bl.PersonBusinessLogic;

@Controller
@RequestMapping("/")
public class ListAppointmentController{
	
	private static Logger logger=Logger.getLogger(ListAppointmentController.class);
	
	@ModelAttribute("list")
	public List<Appointment> viewAppointment(String personId){
		
		PersonBusinessLogic pb = new PersonBusinessLogic();
		ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
		
			try {
				appointmentList=pb.myAppointments(personId);
				
				BasicConfigurator.configure();
		 	    logger.info("Appointment listed by Patient!!");
		 	    
		 	    return appointmentList;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	
			return null;
	}
		
	@RequestMapping("/AppointmentServlet")
	public ModelAndView viewAppointmentPage(HttpSession session){
		
		String personId = (String) session.getAttribute("personId");
		ModelAndView mv=new ModelAndView();
		List<Appointment> appointmentList=new ArrayList<Appointment>();
		PersonBusinessLogic pb = new PersonBusinessLogic();
		try { 
			if(pb.myAppointments(personId)!=null){
				
				
				appointmentList= pb.myAppointments(personId);
			
				BasicConfigurator.configure();
		 	    logger.info("Appointment listed by Patient!!");
				
		 	    
			}//Add Bill jsp and recheck logic.
		} catch (ClassNotFoundException| IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} 
		mv.addObject("appointmentList", appointmentList);
		mv.setViewName("viewAppointment");
		return mv;
		
	}
}

//public class ListAppointmentController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private static Logger logger=Logger.getLogger(ListAppointmentController.class);
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//Code for Getting relevant Appointment List.
//		
//		HttpSession session=request.getSession();
//		String personId =(String)session.getAttribute("personId");
//		
//		PersonBusinessLogic pb = new PersonBusinessLogic();
//		ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
//		
//			try {
//				appointmentList=pb.myAppointments(personId);
//				
//				BasicConfigurator.configure();
//		 	    logger.info("Appointment listed by Patient!!");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
////			if(request.getParameter("personId")==null){
////				String message="Patient not found";
////				session.setAttribute("message", message);
////				response.sendRedirect("ErrorPage.jsp");
////			}
//		
//		 request.setAttribute("appList", appointmentList);
//		
//		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewAppointment.jsp");
//		    rd.forward(request, response);
//		
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//	}
//
//}
