package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.persistence.entities.Golfer;
import project.persistence.entities.Tournament;
import project.persistence.entities.UserInfo;
import project.service.GolferService;
import project.service.Password;


/**
 * Small controller just to show that you can have multiple controllers
 * in your project
 */
@Controller
@RequestMapping("/")
public class MainController {
	
	GolferService golferService;
	
	@Autowired
	public MainController(GolferService golferService) {
		this.golferService = golferService;
	}

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
    
    @RequestMapping(value = "/json/registerUser", method = RequestMethod.GET)
    public @ResponseBody void UserInfo(@RequestParam(value = "social") Long social,
    					 @RequestParam(value = "password") String password){
    	
    	UserInfo userinfo = new UserInfo(social, "blabla");
    	userinfo.setPassword(Password.md5(userinfo.getPassword()));
    	golferService.save(userinfo);
    }
    
    @RequestMapping(value="/json/golfer", method = RequestMethod.GET)
	public @ResponseBody Golfer getGolfer() {

    	
		Golfer golfer = new Golfer("Halla", 2709942619L, 23.9, "gmail.com", null);
		golferService.addFriendForGolfer(golfer, new Golfer("Unnur", 1911932819L, 12.2, "unns.com", null));
    	return golfer;

	}

}
