package controller.patientServlet;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controller.loginSignUp.LogInController;
import model.bean.Bill;
import model.bl.PersonBusinessLogic;

@Controller
@RequestMapping("/")
public class BillServlet{
	
	private static Logger logger=Logger.getLogger(BillServlet.class);
	
	@ModelAttribute("list")
	public List<Bill> viewBill(String personId){
		
		PersonBusinessLogic pb = new PersonBusinessLogic();
		try { 
			if(pb.listMyBill(personId)!=null){
				
				List<Bill> billList= new ArrayList<Bill>();
				billList= pb.listMyBill(personId);
				//request.setAttribute("billList", pb.listMyBill(personId));
				
				BasicConfigurator.configure();
		 	    logger.info("Bill viewed by Patient!!");
				System.out.println(billList);
		 	    return billList;
			}//Add Bill jsp and recheck logic.
		} catch (ClassNotFoundException| IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} 
		return null;
	}
	
	@RequestMapping("/Bill")
	public ModelAndView viewBillPage(HttpSession session){
		
		String personId = (String) session.getAttribute("personId");
		ModelAndView mv=new ModelAndView();
		List<Bill> billList= new ArrayList<Bill>();
		PersonBusinessLogic pb = new PersonBusinessLogic();
		try { 
			if(pb.listMyBill(personId)!=null){
				
				
				billList= pb.listMyBill(personId);
				//request.setAttribute("billList", pb.listMyBill(personId));
				System.out.println(billList);
				System.out.println(personId);
				BasicConfigurator.configure();
		 	    logger.info("Bill viewed by Patient!!");
				
		 	    
			}//Add Bill jsp and recheck logic.
		} catch (ClassNotFoundException| IOException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		} 
		mv.addObject("billList", billList);
		mv.setViewName("bill");
		return mv;
		
	}
}
//public class BillServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private static Logger logger=Logger.getLogger(BillServlet.class);
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//code to get bill using personId.
//		
//		HttpSession session=request.getSession();
//		String personId =(String)session.getAttribute("personId");
//		
//		
//		
//		
//		PersonBusinessLogic pb = new PersonBusinessLogic();
//		try { 
//			if(pb.listMyBill(personId)!=null){
//				
//				request.setAttribute("billList", pb.listMyBill(personId));
//				
//				BasicConfigurator.configure();
//		 	    logger.info("Bill viewed by Patient!!");
//				
//				RequestDispatcher rd = getServletContext().getRequestDispatcher("/bill.jsp");
//			    rd.forward(request, response);
//			}//Add Bill jsp and recheck logic.
//			else 
//				{
//					String message="Bill not found";
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
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
