package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.bean.Department;
import model.bean.Doctor;
import model.bl.AdminBusinessLogic;

@Controller
public class FindAppointment{
	
	private static Logger logger=Logger.getLogger(FindAppointment.class);
	
	@RequestMapping("/FindAppointment")
	public ModelAndView getAppointment(HttpSession session){
		
		int regNo=(int)session.getAttribute("regNo1");
		System.out.println("regNo "+regNo);
		String operation= (String)session.getAttribute("selectedValue");
		AdminBusinessLogic abl=new AdminBusinessLogic();
		ModelAndView mv=new ModelAndView();
		try {
			mv.addObject("appointment",abl.viewAppointments(regNo));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//To DELETE
		
		if(operation.equalsIgnoreCase("Remove"))
		{
			
			try {
				boolean status=abl.removeAppointment(regNo);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BasicConfigurator.configure();
	 	    logger.info("Appointment Deleted");
			
			String servlet="./DeleteAppointment";
			String button="DELETE";
			
			mv.addObject("button", "DELETE");
			mv.setViewName("newAppointment");
			
		}
		
		//TO FIND AND DISPLAY
		else if(operation.equalsIgnoreCase("Find"))
		{
			
			mv.addObject("button", "CONTINUE");
			mv.setViewName("admin");

		}
		
		//TO UPDATE
		else {
			ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
			ArrayList<Department> departmentList=new ArrayList<Department>();
			try {
				doctorList=abl.listDoctor();
				departmentList=abl.listDepartment();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			mv.addObject("doctorList", doctorList);
			mv.addObject("departmentList", departmentList);
			mv.setViewName("updateForm");
			
		}

		
		return mv;
	}
}

//public class FindAppointment extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//   
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	//	HttpSession session=request.getSession();
//		Integer regNo=Integer.parseInt(request.getParameter("regNo"));
//		AdminBusinessLogic abl=new AdminBusinessLogic();
//		try {
//			try {
//				request.setAttribute("appointment",abl.viewAppointments(regNo));
//				//appList=dbl.myAppointments(doctorId);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		String operation=request.getParameter("selectedValue");
//		
//		
//		//To DELETE
//		
//		if(operation.equalsIgnoreCase("Remove"))
//		{
//			String servlet="./DeleteAppointment";
//			String button="DELETE";
//			
//		request.setAttribute("servlet", servlet);
//		request.setAttribute("button", button);
//		request.setAttribute("regNo", regNo);
//		}
//		
//		//TO FIND AND DISPLAY
//		else if(operation.equalsIgnoreCase("Find"))
//		{
//			String servlet="./admin.jsp";
//			String button="CONTINUE";
//			
//		request.setAttribute("servlet", servlet);
//		request.setAttribute("button", button);
//
//		}
//		
//		//TO UPDATE
//		else {
//			ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
//			ArrayList<Department> departmentList=new ArrayList<Department>();
//			try {
//				doctorList=abl.listDoctor();
//				departmentList=abl.listDepartment();
//				
//			} catch (ClassNotFoundException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}		
//			 request.setAttribute("doctorList", doctorList);
//			 request.setAttribute("departmentList", departmentList);
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateForm.jsp");
//		    rd.forward(request, response);
//			
//		}
//
//		//PrintWriter writerA = response.getWriter();
//		//writerA.println(operation);
//		
//		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newAppointment.jsp");
//		    rd.forward(request, response);
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
