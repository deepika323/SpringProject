package controller.adminServlet;

import java.io.IOException;

import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import controller.doctorServlet.addMedicalReportController;
import model.bean.Doctor;
import model.bean.MedicalReport;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;

@Controller
@RequestMapping("/")
public class NewDoctorController{

private static Logger logger=Logger.getLogger(NewDoctorController.class);
	
	@RequestMapping("/NewDoctorController")
	public ModelAndView addDoctro(@ModelAttribute("doctor")Doctor doctor){
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		try {
			abl.addDoctor(doctor);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(doctor);
		ModelAndView mv=new ModelAndView();
		mv.addObject(doctor);
		mv.setViewName("newDoctor");
		return mv;
	}
}

//public class NewDoctorController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public NewDoctorController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub	
//		String doctorId=request.getParameter("id");
//		String doctorName=request.getParameter("name");
//		String specialization=request.getParameter("specialization");
//		String timing=request.getParameter("timing");
//		String address=request.getParameter("address");
//		Long phoneno=Long.parseLong(request.getParameter("phone"));
//		String password=request.getParameter("password");
//		Integer departmentId=Integer.parseInt(request.getParameter("department"));
//		HttpSession session=request.getSession();
//		AdminBusinessLogic abl=new AdminBusinessLogic();
//		Doctor newDoctor = new Doctor();
//		newDoctor.setDoctorId(doctorId);
//		newDoctor.setDoctorName(doctorName);
//		newDoctor.setSpecialization(specialization);
//		newDoctor.setTiming(timing);
//		newDoctor.setDoctorAddress(address);
//		newDoctor.setDoctorPhoneNo(phoneno);
//		newDoctor.setDoctorPassword(password);
//		newDoctor.setDepartmentId(departmentId);
//		try {
//			try {
//				boolean status=abl.addDoctor(newDoctor);
//				
//				if(status==true){
//					request.setAttribute("doctor",newDoctor);
//					String servlet="./admin.jsp";
//					String button="CONTINUE";
//					
//				request.setAttribute("servlet", servlet);
//				request.setAttribute("button", button);
//
//				
//				    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newDoctor.jsp");
//				    rd.forward(request, response);
//	
//				}
//				else {
//					String message="Doctor Already Exist";
//					session.setAttribute("message", message);
//					response.sendRedirect("ErrorPage.jsp");
//					
//				}
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			String message="Doctor Already Exist";
//			session.setAttribute("message", message);
//			response.sendRedirect("ErrorPage.jsp");
//
//			
//		}
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
