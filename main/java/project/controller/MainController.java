package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
@Controller
@RequestMapping("/")
public class MainController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){

        return "index";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){

        return "index";
    }
    
    
    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public String mypage(){

        return "mypage";
    }
   
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(){

        return "about";
    }

}
