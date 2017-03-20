package controller.loginSignUp;

import java.io.IOException;
import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.bean.Person;
import model.bl.PersonBusinessLogic;

@Controller
public class SignUpController {

	@RequestMapping(value = "/SignUpController", method = RequestMethod.POST)
	public String addContact(@Valid Person person, BindingResult result) {
		
		if(result.hasErrors()){
			return "signup";
		}
		else{
			PersonBusinessLogic pbl=new PersonBusinessLogic();
			try {
				pbl.personSignUp(person);
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "personlogin";
		}
		
	}
}

//public class SignUpController extends HttpServlet { 
//	private static final long serialVersionUID = 1L;
// 
//	private static Logger logger=Logger.getLogger(SignUpController.class); 
//	 
//	/** 
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) 
//	 */ 
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PersonBusinessLogic pbl = new PersonBusinessLogic();
//		String personId=request.getParameter("personId");
//		String personIdType=request.getParameter("personIdType");
//		String personName=request.getParameter("personName");
//		String DateOfBirthString=(request.getParameter("personDateOfBirth"));
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
//		Date personDateOfBirth=java.sql.Date.valueOf(DateOfBirthString);			//check
//		int personAge=Integer.parseInt(request.getParameter("personAge"));
//		String personGender=request.getParameter("radio");
//		String personAddress=request.getParameter("personAddress");
//		Long personPhoneNo=Long.parseLong(request.getParameter("personPhoneNo"));
//		String personPassword=request.getParameter("personPassword");
//		String password="";
//		try { 
//			password=pbl.getHashString(personPassword);
//		} catch (NoSuchAlgorithmException e1) {
//			// TODO Auto-generated catch block 
//			e1.printStackTrace();
//		} 
//		 
//		 
//		Person newPerson = new Person();
//		newPerson.setPersonAddress(personAddress);
//		newPerson.setPersonAge(personAge);
//		newPerson.setPersonDateOfBirth(personDateOfBirth);
//		newPerson.setPersonGender(personGender);
//		newPerson.setPersonId(personId);
//		newPerson.setPersonIdType(personIdType);
//		newPerson.setPersonName(personName);
//		newPerson.setPersonPassword(password);
//		newPerson.setPersonPhoneNo(personPhoneNo);
//		 
//		 
//		boolean result=false;
//		 
//			try { 
//				result=pbl.personSignUp(newPerson);
//				BasicConfigurator.configure(); 
//		 	    logger.info("Signing up!!"); 
//		 	   request.setAttribute("newPerson", newPerson);
//				 
//			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/personlogin.jsp");
//			    rd.forward(request, response);
//			} catch (ClassNotFoundException e) {
//				System.out.println();
//				e.printStackTrace();
//			} catch (SQLException e) {
//			 
//			PrintWriter out=response.getWriter();
//			 out.println("<script type=\"text/javascript\">");  
//			 out.println("alert('SignUp Failed !!!');");
//			 out.println("location='./signup.jsp';");
//			 out.println("</script>");		
//			 
//			 e.printStackTrace();
//			} 
//		 
//		 
//		 
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