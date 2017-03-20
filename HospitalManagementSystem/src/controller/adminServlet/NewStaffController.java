package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;

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
import model.bean.MedicalReport;
import model.bean.Staff;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;

@Controller
@RequestMapping("/")
public class NewStaffController{
	
	private static Logger logger=Logger.getLogger(NewStaffController.class);
	
	@RequestMapping("/NewStaffController")
	public ModelAndView addStaff(@ModelAttribute("staff") Staff staff){
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		try {
			abl.addStaff(staff);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(staff);
		ModelAndView mv=new ModelAndView();
		mv.addObject(staff);
		mv.setViewName("newStaff");
		return mv;
	}
}

//public class NewStaffController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public NewStaffController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String staffId=request.getParameter("id");
//		String staffName=request.getParameter("name");
//		String specialization=request.getParameter("specialization");
//		String timing=request.getParameter("timing");
//		String staffAddress=request.getParameter("Address");
//		long staffPhoneNo=Long.parseLong(request.getParameter("phone"));
//		String staffPassword=request.getParameter("Password");
//		int departmentId=Integer.parseInt(request.getParameter("department"));
//		
//		AdminBusinessLogic abl=new AdminBusinessLogic();
//		Staff staff=new Staff();
//		
//		staff.setDepartmentId(departmentId);
//		staff.setSpecialization(specialization);
//		staff.setStaffAddress(staffAddress);
//		staff.setStaffId(staffId);
//		staff.setStaffName(staffName);
//		staff.setStaffPassword(staffPassword);
//		staff.setStaffPhoneNo(staffPhoneNo);
//		staff.setTiming(timing);
//		
//		try {
//			try {
//				boolean status=abl.addStaff(staff);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		 request.setAttribute("staff",staff);
//			String servlet="./admin.jsp";
//			String button="CONTINUE";
//			
//		request.setAttribute("servlet", servlet);
//		request.setAttribute("button", button);
//
//		
//		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newStaff.jsp");
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
