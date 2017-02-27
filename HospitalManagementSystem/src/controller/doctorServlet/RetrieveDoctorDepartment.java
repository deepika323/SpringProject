package controller.doctorServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Department;
import model.bean.Doctor;
import model.bl.AdminBusinessLogic;

public class RetrieveDoctorDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
				ArrayList<Department> departmentList=new ArrayList<Department>();
				
				AdminBusinessLogic abl=new AdminBusinessLogic();
				
				try {
					doctorList=abl.listDoctor();
					departmentList=abl.listDepartment();
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				 request.setAttribute("doctorList", doctorList);
				 request.setAttribute("departmentList", departmentList);
					
				    RequestDispatcher rd = getServletContext().getRequestDispatcher("/addMEdicalReport.jsp");
				    rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
