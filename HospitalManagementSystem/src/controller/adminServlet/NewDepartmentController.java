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
import model.bean.Department;
import model.bean.MedicalReport;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;

@Controller
@RequestMapping("/")
public class NewDepartmentController{
	
	private static Logger logger=Logger.getLogger(NewDepartmentController.class);
	
	@RequestMapping("/NewDepartmentController")
	public ModelAndView addDepartment(@ModelAttribute("department") Department department){
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		try {
			abl.addDepartment(department);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(department);
		ModelAndView mv=new ModelAndView();
		mv.addObject(department);
		mv.setViewName("newDepartment");
		return mv;
	}
}


//public class NewDepartmentController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public NewDepartmentController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		int id=Integer.parseInt(request.getParameter("id"));
//		String name=request.getParameter("name");
//		String location=request.getParameter("location");
//		String desc=request.getParameter("desc");
//		//String
//		AdminBusinessLogic abl = new AdminBusinessLogic();
//		Department department = new Department();
//		department.setDepartmentId(id);
//		department.setDepartmentName(name);
//		department.setDescription(desc);
//		department.setDepartmentLocation(location);
//		try {
//			abl.addDepartment(department);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		request.setAttribute("department", department);
//		String servlet="./admin.jsp";
//		String button="CONTINUE";
//		
//		request.setAttribute("servlet", servlet);
//		request.setAttribute("button", button);
//
//	
//	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newDepartment.jsp");
//	    rd.forward(request, response);
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
