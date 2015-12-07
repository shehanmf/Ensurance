package devday.ensuarance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AgentController {

	@RequestMapping("/agent")
	public String agentRegisterView(Model model) {
		return "agentPage";
	}
	
	@RequestMapping("/agentRegister")
	public String agentRegister(Model model) {
		return "index";
	}
}
