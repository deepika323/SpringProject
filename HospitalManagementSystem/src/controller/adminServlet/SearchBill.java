package controller.adminServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controller.doctorServlet.removeMedicine;
import model.bl.AdminBusinessLogic;

@Controller
public class SearchBill{
	
	private static Logger logger=Logger.getLogger(SearchBill.class);

	@RequestMapping("/SearchBill")
	public ModelAndView getBill(@RequestParam("billNo") int billNo,@RequestParam("selectedValue") String operation){
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		ModelAndView mv=new ModelAndView();
		
		try {
			mv.addObject("bill",abl.viewBill(billNo));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BasicConfigurator.configure();
 	    logger.info("Bill Searched!!");
 	    
 	   if(operation.equalsIgnoreCase("Remove"))
 			{
 		   
 		  try {
			boolean status=abl.removeBill(billNo);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			BasicConfigurator.configure();
	 	    logger.info("Bill Removed!!");
 		   
	 	    mv.addObject("billNo", billNo);
	 	    mv.addObject("button", "DELETE");
 			
 			}
 			
 			//TO FIND AND DISPLAY
 			else if(operation.equalsIgnoreCase("Find"))
 			{
 				mv.addObject("button", "CONTINUE");
 				try {
					mv.addObject("billList", abl.viewBill(billNo));
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 				mv.setViewName("viewBill");
 				return mv;
 			 
 			}
 			
 			//TO UPDATE
 			else {
 				
 				mv.setViewName("updateBill");
 				return mv;
 				
 			}

 	   mv.setViewName("newBill");
		return mv;
		
	}

}

//public class SearchBill extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private static Logger logger=Logger.getLogger(SearchBill.class);
//       
//  
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//
//		int billNo=Integer.parseInt(request.getParameter("billNo"));
//		AdminBusinessLogic abl=new AdminBusinessLogic();
//		
//		try {
//				request.setAttribute("bill",abl.viewBill(billNo));
//				BasicConfigurator.configure();
//		 	    logger.info("Bill Searched!!");
//				
//		} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//		}
//		 catch (SQLException e) {
//			e.printStackTrace();
//		}
//		String operation=request.getParameter("selectedValue");
//		
//		
//		//To DELETE
//		
//		if(operation.equalsIgnoreCase("Remove"))
//		{
//			String servlet="./DeleteBill";
//			String button="DELETE";
//			
//		request.setAttribute("servlet", servlet);
//		request.setAttribute("button", button);
//		request.setAttribute("billNo", billNo);
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
//			//request.setAttribute("billNo", billNo);
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateBill.jsp");
//		    rd.forward(request, response);
//			
//		}
//
//		//PrintWriter writerA = response.getWriter();
//		//writerA.println(operation);
//		
//		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/newBill.jsp");
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
