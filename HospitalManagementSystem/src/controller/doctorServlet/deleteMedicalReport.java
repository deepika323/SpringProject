package controller.doctorServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bl.AdminBusinessLogic;

/**
 * Servlet implementation class deleteMedicalReport
 */
public class deleteMedicalReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer regNo=Integer.parseInt(request.getParameter("regNo"));
		AdminBusinessLogic abl=new AdminBusinessLogic();
		
			try {
				boolean status=abl.removeMedicalReport(regNo);
			}
		 catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			PrintWriter out=response.getWriter();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Medical Report Deleted');");
			   out.println("location='doctor.jsp'");
			   out.println("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
