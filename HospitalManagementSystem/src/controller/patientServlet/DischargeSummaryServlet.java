package controller.patientServlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import model.bean.DischargeSummary;
import model.bl.PersonBusinessLogic;

@Controller
@RequestMapping("/")
public class DischargeSummaryServlet{
	private static Logger logger=Logger.getLogger(DischargeSummaryServlet.class);

	@ModelAttribute("list")
	public List<DischargeSummary> viewDischargeSummary(String personId){
	
		PersonBusinessLogic pb = new PersonBusinessLogic();
		try { 
			
			if(pb.listMyDischargeSummary(personId)!=null){
				
				List<DischargeSummary> dischargeSummaryList= new ArrayList<DischargeSummary>();
				dischargeSummaryList= pb.listMyDischargeSummary(personId);
				
				BasicConfigurator.configure();
		 	    logger.info("Discharge Summary Viewed by Patient!!");
				
				return dischargeSummaryList;
			}//Add Discharge Summary jsp and recheck logic.
			
		} catch (ClassNotFoundException| IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} 
		
		return null;
	}
	
	@RequestMapping("/DischargeSummary")
	public ModelAndView viewDischargeSummaryPage(HttpSession session){
		
		String personId = (String) session.getAttribute("personId");
		ModelAndView mv=new ModelAndView();
		List<DischargeSummary> dischargeSummaryList= new ArrayList<DischargeSummary>();
	
		PersonBusinessLogic pb = new PersonBusinessLogic();
		try { 
			
			if(pb.listMyDischargeSummary(personId)!=null){
				
				
				dischargeSummaryList= pb.listMyDischargeSummary(personId);
				System.out.println(personId);
				System.out.println(dischargeSummaryList);
				BasicConfigurator.configure();
		 	    logger.info("Discharge Summary Viewed by Patient!!");
				
				
			}//Add Discharge Summary jsp and recheck logic.
			
		} catch (ClassNotFoundException| IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} 
		mv.addObject("dischargeSummaryList", dischargeSummaryList);
		mv.setViewName("dischargeSummary");
		return mv;
	}
}
//public class DischargeSummaryServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private static Logger logger=Logger.getLogger(DischargeSummaryServlet.class);
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		//Code for getting discharge summary using serial number
//		HttpSession session=request.getSession();
//		String personId =(String)session.getAttribute("personId");
//		
//		PersonBusinessLogic pb = new PersonBusinessLogic();
//		try { 
//			
//			if(pb.listMyDischargeSummary(personId)!=null){
//				
//				request.setAttribute("dischargeSummaryList", pb.listMyDischargeSummary(personId));
//				
//				BasicConfigurator.configure();
//		 	    logger.info("Discharge Summary Viewed by Patient!!");
//				
//				RequestDispatcher rd = getServletContext().getRequestDispatcher("/dischargeSummary.jsp");
//			    rd.forward(request, response);
//			}//Add Discharge Summary jsp and recheck logic.
//			else 
//				{
//				
//					String message="Discharge Summary not found";
//					session.setAttribute("message", message);
//					response.sendRedirect("ErrorPage.jsp");
//				}
//		} catch (ClassNotFoundException| IOException e) {
//			// TODO Auto-generated catch block 
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block 
//			e.printStackTrace();
//		} 
//		
//	}
//
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
