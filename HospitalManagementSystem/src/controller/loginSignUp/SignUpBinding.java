package controller.loginSignUp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.bean.Department;
import model.bean.Person;

@Controller
@RequestMapping("/")
public class SignUpBinding {

	@RequestMapping("/SignUpBinding")
	public ModelAndView signUp(){
		
		ModelAndView mv=null;
		mv=new ModelAndView("signup","person",new Person());
		return mv;
		
}
}
