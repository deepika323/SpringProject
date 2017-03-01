package controller.loginSignUp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bl.DoctorBusinessLogic;
import model.bl.PersonBusinessLogic;
import model.bl.StaffBusinessLogic;


/**
 * Servlet implementation class LogInController
 */
public class LogInController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id1= request.getParameter("ID");
 		String password1= request.getParameter("password");
 		
 		PrintWriter pw=response.getWriter();
 		//pw.print(request.getParameter("radios")); 
		
		
		if(request.getParameter("radios").equals("radio1")){
		 		String id = request.getParameter("id");
		 		String password = request.getParameter("password");
		 		
		 		
		 				 		
		 		StaffBusinessLogic sbl = new StaffBusinessLogic();
		 		try {
					if(sbl.staffLogin(id, password)!=null){
						HttpSession session=request.getSession();
						session.setAttribute("personId",id);
						response.sendRedirect("./Staff.jsp");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 	}
		 	else if(request.getParameter("radios").equals("radio2")){
		 		String id = request.getParameter("ID");
		 		String password = request.getParameter("password");
		 		
		 		
		 		
		 		PersonBusinessLogic pbl = new PersonBusinessLogic();
		 		try {
					if(pbl.personLogin(id, password).getPersonAge()!=0){
						HttpSession session=request.getSession();
						session.setAttribute("personId",id);
						response.sendRedirect("./Patient.jsp");
					}
					else
					{
						response.sendRedirect("./login.jsp");	
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 	}
		 	else if(request.getParameter("radios").equals("radio3")){
		 		String id = request.getParameter("ID");
		 		String password = request.getParameter("password");
		 		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		 		try {
					if(dbl.doctorLogin(id, password)!=null){
						HttpSession session=request.getSession();
						session.setAttribute("doctorId",id);
						response.sendRedirect("./doctor.jsp");
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 	}
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
