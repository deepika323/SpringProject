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
import model.bean.Bill;
import model.bl.AdminBusinessLogic;

@Controller
public class FindOrRemoveBillController{
	
	@RequestMapping("/FindOrRemoveBillController")
	public ModelAndView update(@RequestParam("selectedValue") String selected,ModelMap model){
		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		ArrayList<Bill> billList=new ArrayList<Bill>();
		try {
			billList=abl.listBill();
			System.out.println(billList);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView mv=null;
		mv=new ModelAndView("findBill","billList",billList);
		mv.addObject("button",selected);
		return mv;
		
	}
}

//public class FindOrRemoveBillController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String button=request.getParameter("selectedValue");
//		request.setAttribute("button", button);
//		ArrayList<Bill> billList=new ArrayList<Bill>();
//		  RequestDispatcher rd = getServletContext().getRequestDispatcher("/findBill.jsp");
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
