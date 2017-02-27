package controller.patientServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Medicine;
import model.bl.PersonBusinessLogic;


public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//Code for Getting Medicine result.
		
				HttpSession session=request.getSession();
				String patientId =(String)session.getAttribute("patientId");
				
				PersonBusinessLogic pb = new PersonBusinessLogic();
				
				try { 
					
					ArrayList<Medicine> medicineList=new ArrayList<Medicine>();
					medicineList=pb.myMedicines(Integer.parseInt(patientId));
					if(medicineList.size()==0)
					{ 
						String message="Medicine not found";
						session.setAttribute("message", message);
						response.sendRedirect("ErrorPage.jsp");
					} 
					else  
					{ 
						request.setAttribute("medicineList", medicineList);
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/medicine.jsp");
					    rd.forward(request, response);
//					for(Medicine m:medicineList)
//					{ 
//					System.out.println(m);
//					} 
					} 
					
				} catch (ClassNotFoundException| IOException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block 
					e.printStackTrace();
				} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
