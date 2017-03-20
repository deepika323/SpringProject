package controller.staffServlet;

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
import controller.patientServlet.BillServlet;
import model.bean.Bill;
import model.bean.Ward;
import model.bl.PersonBusinessLogic;
import model.bl.StaffBusinessLogic;

@Controller
@RequestMapping("/")
public class ViewMyWardsController{
	
	private static Logger logger=Logger.getLogger(ViewMyWardsController.class);
	
	@ModelAttribute("list")
	public List<Ward> viewWard(String staffId){
		
		StaffBusinessLogic pb = new StaffBusinessLogic();
		try { 
			if(pb.myWards(staffId)!=null){
				
				List<Ward> wardList= new ArrayList<Ward>();
				wardList= pb.myWards(staffId);
				//request.setAttribute("billList", pb.listMyBill(personId));
				
				BasicConfigurator.configure();
		 	    logger.info("Bill viewed by Patient!!");
				System.out.println(wardList);
		 	    return wardList;
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
	
	@RequestMapping("/ViewMyWardsController")
	public ModelAndView viewBillPage(HttpSession session){
		
		String staffId = (String) session.getAttribute("staffId");
		ModelAndView mv=new ModelAndView();
		List<Ward> wardList= new ArrayList<Ward>();
		StaffBusinessLogic pb = new StaffBusinessLogic();
		try { 
			if(pb.myWards(staffId)!=null){
				
				
				wardList= pb.myWards(staffId);
				//request.setAttribute("billList", pb.listMyBill(personId));
				System.out.println(wardList);
				System.out.println(staffId);
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
		mv.addObject("wardList", wardList);
		mv.setViewName("viewWards");
		return mv;
		
	}
}

//public class ViewMyWardsController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private static Logger logger=Logger.getLogger(ViewMyWardsController.class);
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ViewMyWardsController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		String staffId=(String) session.getAttribute("staffId");
//		//String staffId = request.getParameter("staffId");
//		StaffBusinessLogic sbl = new StaffBusinessLogic();
//		ArrayList<Ward> wardList=new ArrayList<Ward>();
//		System.out.println(staffId);
//		try {
//			wardList = sbl.myWards(staffId);
//			
//			BasicConfigurator.configure();
//	 	    logger.info("Ward List viewed by Staff!!");
//		} catch (ClassNotFoundException | SQLException e ) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		catch (Exception e)
//		{	
//			PrintWriter out=response.getWriter();
//			 out.println("<script type=\"text/javascript\">");  
//			 out.println("alert('No Wards!!!');");
//			 out.println("location='./viewWards.jsp';");
//			 out.println("</script>");
//			
//		}
////		PrintWriter out=response.getWriter();
////		 out.println(wardList);  
//		
//		
//		request.setAttribute("staffId", staffId);
//		request.setAttribute("wardList", wardList);
//	    RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewWards.jsp");
//	    rd.forward(request, response);
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
