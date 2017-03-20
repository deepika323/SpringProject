package controller.adminServlet;

import java.io.IOException;
//import java.io.PrintWriter;
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
@RequestMapping("/")
public class FindOrRemoveController{
	
	@RequestMapping("/FindOrRemoveController")
	public ModelAndView update(@RequestParam("selectedValue") String selected,ModelMap model){
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		ArrayList<Appointment> appointmentList=new ArrayList<Appointment>();
		try {
			appointmentList=abl.listAppointment();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv=null;
		mv=new ModelAndView("findAppointment","appointmentList",appointmentList);
		mv.addObject(selected);
		return mv;
		
	}
}

//public class FindOrRemoveController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public FindOrRemoveController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		String button=request.getParameter("selectedValue");
//		request.setAttribute("button", button);
//		
//		//PrintWriter writerA = response.getWriter();
//		//writerA.println(button);
//		AdminBusinessLogic abl=new AdminBusinessLogic();
//		ArrayList<Appointment> appList=new ArrayList<Appointment>();
//		
//		
//		try {
//			appList=abl.listAppointment();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		request.setAttribute("appList", appList);
//
//		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/findAppointment.jsp");
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
