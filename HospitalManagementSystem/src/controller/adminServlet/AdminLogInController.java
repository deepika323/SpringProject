package controller.adminServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import controller.loginSignUp.LogInController;

@Controller
@RequestMapping("/")
@SessionAttributes("admin")
 public class AdminLogInController{
	
	static final Logger log = Logger.getLogger(AdminLogInController.class);
	
	@RequestMapping("/AdminLogInController")
	public ModelAndView loginIn(@PathParam("id") String id, @PathParam("password") String password){
		
		ModelAndView mv=new ModelAndView();
		if(id.equals("admin")&&password.equals("admin")){
 			log.info("Admin Login Successful");
 			System.out.println(id);
 			//mv.addObject("id",id);
 			mv.setViewName("admin");
 			mv.addObject("admin", id);
 			System.out.println(mv.getViewName());
 			return mv;
 		}
 		else{
 			System.out.println(id + " "+ password);
 			//mv.addObject( "id",id);
 			mv.addObject("admin", id);
 			mv.setViewName("adminLoginForm");
 			return mv;
 		}
		
	}
}



















//public class AdminLogInController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	
//	static final Logger log = Logger.getLogger(LogInController.class);
//       
// 
//    public AdminLogInController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id= request.getParameter("id");
// 		String password= request.getParameter("password");
// 		if(id.equals("admin")&&password.equals("admin")){
// 			log.info("Admin Login Successful");
// 			HttpSession session = request.getSession();
// 			session.setAttribute("admin", id);
// 			response.sendRedirect("./admin.jsp");
// 		}
// 		else{
// 			response.sendRedirect("./ErrorPage.jsp");
// 		}
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
