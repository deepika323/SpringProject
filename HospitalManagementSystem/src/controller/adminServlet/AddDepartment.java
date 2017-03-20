package controller.adminServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import controller.doctorServlet.removeMedicine;
import model.bean.Department;
import model.bean.MedicalReport;

@Controller
@RequestMapping("/")
public class AddDepartment{
	
	@RequestMapping("/addDepartment")
	public String addReport(ModelMap model){
		
		model.addAttribute("department", new Department());
		return "addDepartment";
		
}
}

//public class AddDepartment extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private static Logger logger=Logger.getLogger(AddDepartment.class);
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public AddDepartment() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		 RequestDispatcher rd = getServletContext().getRequestDispatcher("/addDepartment.jsp");
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
