package controller.adminServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.bean.Doctor;
import model.bean.Staff;

@Controller
public class AddStaff {

	@RequestMapping("/AddStaff")
	public String addReport(ModelMap model){
		
		model.addAttribute("staff", new Staff());
		return "addStaff";
		
}
}
