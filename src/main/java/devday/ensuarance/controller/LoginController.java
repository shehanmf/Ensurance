package devday.ensuarance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Shehan on 11/22/2015.
 */
@Controller
public class LoginController {

	
	
	
    @RequestMapping("/login")
    public String index(Model model) {
        return "loginPage";
    }
    
    @RequestMapping("/submitLogin")
    public String submitLogin(Model model) {
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        return "home";
    }



}
