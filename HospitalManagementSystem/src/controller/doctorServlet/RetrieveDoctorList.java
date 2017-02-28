package controller.doctorServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Department;
import model.bean.Doctor;
import model.bean.Medicine;
import model.bean.Technician;
import model.bl.AdminBusinessLogic;
import model.bl.DoctorBusinessLogic;

/**
 * Servlet implementation class RetrieveDoctorList
 */
public class RetrieveDoctorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveDoctorList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
		ArrayList<Technician> technicianList=new ArrayList<Technician>();
		ArrayList<Department> departmentList=new ArrayList<Department>();
 		
		AdminBusinessLogic abl=new AdminBusinessLogic();
		
		try {
			doctorList=abl.listDoctor();
			technicianList=abl.listTechnician();
			departmentList=abl.listDepartment();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		 request.setAttribute("doctorList", doctorList);
		 request.setAttribute("technicianList", technicianList);
		 request.setAttribute("departmentList", departmentList);
		 
		 
//		PrintWriter pw=response.getWriter();
//		 pw.println(doctorList);
//		 pw.println(technicianList);
//		 
			
   RequestDispatcher rd = getServletContext().getRequestDispatcher("/addMedicalReportForm.jsp");
	   rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
