package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.bean.Department;
import model.bean.Doctor;
import model.bl.AdminBusinessLogic;

@Controller
public class FindDischargeSummary{
	
	private static Logger logger=Logger.getLogger(FindDischargeSummary.class);
	
	@RequestMapping("/FindDischargeSummary")
	public ModelAndView getBill(@RequestParam("serialNo") int serialNo,@RequestParam("selectedValue") String operation){
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		ModelAndView mv=new ModelAndView();
		
		try {
			try {
				mv.addObject("dischargeSummary",abl.viewDischargeSummary(serialNo));
				//appList=dbl.myAppointments(doctorId);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BasicConfigurator.configure();
 	    logger.info("DischargeSummary Searched!!");
 	    
 	   if(operation.equalsIgnoreCase("Remove"))
 			{
 		   
 		  try {
			boolean status=abl.removeDischargeSummary(serialNo);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			BasicConfigurator.configure();
	 	    logger.info("Summary Removed!!");
 		   
	 	    mv.addObject("serialNo", serialNo);
	 	    mv.addObject("button", "DELETE");
 			
 			}
 			
 			//TO FIND AND DISPLAY
 			else if(operation.equalsIgnoreCase("Find"))
 			{
 				mv.addObject("button", "CONTINUE");
 				try {
					mv.addObject("dischargeSummary", abl.viewDischargeSummary(serialNo));
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 				mv.setViewName("viewDischargeSummary");
 				return mv;
 			 
 			}
 			
 			

 	   mv.setViewName("newDischargeSummary");
		return mv;
		
	}

	
}
//public class FindDischargeSummary extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
// 
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		Integer regNo=Integer.parseInt(request.getParameter("regNo"));
//		AdminBusinessLogic abl=new AdminBusinessLogic();
//		try {
//			try {
//				request.setAttribute("appointment",abl.viewDischargeSummary(regNo));
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
//			String servlet="./RemoveDischargeSummary";
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
//		
//
//		//PrintWriter writerA = response.getWriter();
//		//writerA.println(operation);
//		
//    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newDischargeSummary.jsp");
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
