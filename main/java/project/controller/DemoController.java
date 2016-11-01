package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
@Controller
@RequestMapping("/") // Notice here that the Request Mapping is set at the Class level
public class DemoController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){

        // The string "Index" that is returned here is the name of the view
        // (the Index.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        // If you change "Index" to something else, be sure you have a .jsp
        // file that has the same name
        return "index";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){

        return "index";
    }
    
    @RequestMapping(value = "/tournament", method = RequestMethod.GET)
    public String tournament(){

        return "tournament";
    }
    
    @RequestMapping(value = "/results", method = RequestMethod.GET)
    public String results(){

        return "results";
    }
    
    @RequestMapping(value = "/mypage", method = RequestMethod.GET)
    public String mypage(){

        return "mypage";
    }
    
    @RequestMapping(value = "/matchplay", method = RequestMethod.GET)
    public String matchplay(){

        return "matchplay";
    }
    
    @RequestMapping(value = "/matchplay2", method = RequestMethod.GET)
    public String matchplay2(){

        return "matchplay2";
    }
    
    @RequestMapping(value = "/scoreboard", method = RequestMethod.GET)
    public String scoreboard(){

        return "scoreboard";
    }
    
    @RequestMapping(value = "/scoreboard2", method = RequestMethod.GET)
    public String scoreboard2(){

        return "scoreboard2";
    }

}
