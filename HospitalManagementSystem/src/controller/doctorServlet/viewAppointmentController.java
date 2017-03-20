package controller.doctorServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.bean.Appointment;
import model.bl.DoctorBusinessLogic;



@Controller
@RequestMapping("/")
public class viewAppointmentController{
	
	private static Logger logger=Logger.getLogger(viewAppointmentController.class);
	
	@ModelAttribute("list")
	public List<Appointment> viewAppointment(String doctorId){
		
		DoctorBusinessLogic db = new DoctorBusinessLogic();
		ArrayList<Appointment> appList=new ArrayList<Appointment>();
		
			try {
				appList=db.myAppointments(doctorId);
				
				BasicConfigurator.configure();
		 	    logger.info("Appointment listed by Patient!!");
		 	    
		 	    return appList;
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
		
	@RequestMapping("/viewAppointmentController")
	public ModelAndView viewAppointmentPage(HttpSession session){
		
		String doctorId = (String) session.getAttribute("doctorId");
		ModelAndView mv=new ModelAndView();
		List<Appointment> appList=new ArrayList<Appointment>();
		DoctorBusinessLogic db=new DoctorBusinessLogic();
		//PersonBusinessLogic pb = new PersonBusinessLogic();
		try { 
			if(db.myAppointments(doctorId)!=null){
				
				
				appList= db.myAppointments(doctorId);
			
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
		mv.addObject("appList", appList);
		mv.setViewName("viewAppointment");
		return mv;
		
	}
}



//public class viewAppointmentController extends HttpServlet {
//	private static final long serialVersionUID = 2L;
//	
//	private static Logger logger=Logger.getLogger(viewAppointmentController.class);
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session=request.getSession();
//		ArrayList<Appointment> appList=new ArrayList<Appointment>();
//		String doctorId=request.getParameter("doctorId");
//		doctorId=(String) session.getAttribute("doctorId");
//		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
//		try {
//			try {
//				appList=dbl.myAppointments(doctorId);
//				
//				BasicConfigurator.configure();
//		 	    logger.info("Listing Appointment!!");
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		 request.setAttribute("appList", appList);
//		
//		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewAppointment.jsp");
//		    rd.forward(request, response);
//		if(request.getParameter("doctorId")==null){
//			String message="Doctor not found";
//			session.setAttribute("message", message);
//			response.sendRedirect("output.jsp");
//		}
//}
//
//		
//
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		doGet(request, response);
//	}
//
//}
