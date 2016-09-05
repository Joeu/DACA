package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {
	
	@RequestMapping(method=RequestMethod.GET, value={"/stats"})
	public void getGlobalStats(){
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/stats/userId"})
	public void getPersonalStats(){
		
	}

}
