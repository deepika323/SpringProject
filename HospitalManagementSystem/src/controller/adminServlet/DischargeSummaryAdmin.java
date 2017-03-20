package controller.adminServlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import model.bean.DischargeSummary;



@Controller
@RequestMapping("/")
public class DischargeSummaryAdmin {

		
		@RequestMapping("/DischargeSummaryAdmin")
		public String addReport(ModelMap model){
			
			model.addAttribute("dischargeSummary", new DischargeSummary());
			return "addDischargeSummary";
			
	}
	
}
