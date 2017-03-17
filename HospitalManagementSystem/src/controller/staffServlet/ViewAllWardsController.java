package controller.staffServlet;

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
import org.springframework.web.servlet.ModelAndView;

import controller.loginSignUp.LogInController;
import model.bean.Ward;
import model.bl.StaffBusinessLogic;

@Controller
@RequestMapping("/")
public class ViewAllWardsController{
	
	private static Logger logger=Logger.getLogger(ViewAllWardsController.class);
	
	@ModelAttribute("list")
	public List<Ward> viewWard(){
		
		ArrayList<Ward> wardList=new ArrayList<Ward>();
		StaffBusinessLogic sbl = new StaffBusinessLogic();
		
		try
		{
			wardList = sbl.allWards();
			
			BasicConfigurator.configure();
	 	    logger.info("All Ward List viewed by Staff!!");
	 	    
	 	    return wardList;
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;
		
	}
	
	
	@RequestMapping("/ViewAllWardsController")
	public ModelAndView viewWardPage(){
		
		ModelAndView mv=new ModelAndView();
		ArrayList<Ward> wardList=new ArrayList<Ward>();
		StaffBusinessLogic sbl = new StaffBusinessLogic();
		
		try
		{
			wardList = sbl.allWards();
			
			BasicConfigurator.configure();
	 	    logger.info("All Ward List viewed by Staff!!");
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		mv.addObject("wardList", wardList);
		mv.setViewName("viewWards");
		return mv;
		
	}
}


//
///**
// * Servlet implementation class ViewAllWardsController
// */
//public class ViewAllWardsController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	private static Logger logger=Logger.getLogger(ViewAllWardsController.class);
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public ViewAllWardsController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		ArrayList<Ward> wardList=new ArrayList<Ward>();
//		StaffBusinessLogic sbl = new StaffBusinessLogic();
//		
//		try
//		{
//			wardList = sbl.allWards();
//			
//			BasicConfigurator.configure();
//	 	    logger.info("All Ward List viewed by Staff!!");
//		}
//		catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		request.setAttribute("wardList", wardList);
//		
//		RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewWards.jsp");
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
