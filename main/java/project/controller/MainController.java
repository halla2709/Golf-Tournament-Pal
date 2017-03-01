package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.persistence.entities.Golfer;
import project.service.GolferService;


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
    
    @RequestMapping(value="/jsonprufa", method = RequestMethod.GET)
	public @ResponseBody Golfer getShopInJSON() {

    	
		Golfer golfer = new Golfer("Halla", 2709942619L, 23.9, "gmail.com", null);
		golferService.addFriendForGolfer(golfer, new Golfer("Unnur", 1911932819L, 12.2, "unns.com", null));

		return golfer;

	}

}
