package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.bean.Appointment;
import model.bean.DischargeSummary;
import model.bl.AdminBusinessLogic;

@Controller
public class FindorRemoveDischargeSummaryController{
	
	@RequestMapping("/FindorRemoveDischargeSummaryController")
	public ModelAndView update(@RequestParam("selectedValue") String selected,ModelMap model){
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		ArrayList<DischargeSummary> dList=new ArrayList<DischargeSummary>();
		
		try {
			dList=abl.listDischargeSummary();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv=null;
		mv=new ModelAndView("findDischargeSummary","dList",dList);
		mv.addObject("button",selected);
		return mv;
		
	}
}
	


//
//public class FindorRemoveDischargeSummaryController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String button=request.getParameter("selectedValue");
//		request.setAttribute("button", button);
//		
//		//PrintWriter writerA = response.getWriter();
//		//writerA.println(button);
//		AdminBusinessLogic abl=new AdminBusinessLogic();
//		ArrayList<DischargeSummary> dList=new ArrayList<DischargeSummary>();
//		
//		
//		try {
//			dList=abl.listDischargeSummary();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		request.setAttribute("dList", dList);
//		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/findDischargeSummary.jsp");
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
