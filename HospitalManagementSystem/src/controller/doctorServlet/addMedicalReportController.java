package controller.doctorServlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.MedicalReport;
import model.bl.DoctorBusinessLogic;

public class addMedicalReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int patientId=Integer.parseInt(request.getParameter("patientId"));
		String visitDateString=(request.getParameter("visitDate"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date visitDate=null;			//check
		try {
			visitDate = (Date)sdf.parse(visitDateString);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String diagnosis=request.getParameter("diagnosis");
		String investigations=request.getParameter("investigations");
		String tests=request.getParameter("tests");
		String recommendations=request.getParameter("recommendations");
		int doctorId=Integer.parseInt(request.getParameter("doctorId"));
		int technicianId=Integer.parseInt(request.getParameter("technicianId"));
		
		MedicalReport newMedicalReport = new MedicalReport();
		newMedicalReport.setPatientId(patientId);
		newMedicalReport.setVisitDate(visitDate);
		newMedicalReport.setDiagnosis(diagnosis);
		newMedicalReport.setInvestigations(investigations);
		newMedicalReport.setTests(tests);
		newMedicalReport.setRecommendations(recommendations);
		newMedicalReport.setDoctorId(doctorId);
		newMedicalReport.setTechnicianId(technicianId);
		
		DoctorBusinessLogic dbl=new DoctorBusinessLogic();
		boolean result=false;
		try {
			try {
				result=dbl.addMedicalReport(newMedicalReport);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.setAttribute("newMedicalReport", newMedicalReport);
		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/addAppointment.jsp");
		    rd.forward(request, response);
		    //Change
//		    if(request.getParameter("doctorId")==null){
//		    	String message="Doctor not found";
//		    	session.setAttribute("message", message);
//		    	response.sendRedirect("output.jsp");
//		    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
