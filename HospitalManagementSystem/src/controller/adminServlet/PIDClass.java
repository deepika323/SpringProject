package controller.adminServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.bean.Person;

@Controller
@RequestMapping("/")
public class PIDClass {

	@RequestMapping("/PID")
	public String addPIDcall(ModelMap model){
		
		model = new ModelMap();
		Person person =new Person();
		model.addAttribute("person", person);
		return "AddBillPID";
		
	}
}
