package app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Problem;
import app.model.Solution;
import app.model.User;
import app.service.ProblemRepository;
import app.service.SolutionRepository;
import app.service.UserRepository;

@RestController
public class StatsController {
	
	@Autowired
	ProblemRepository problemRepo;
	
	@Autowired
	SolutionRepository solutionRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@CrossOrigin
	@Cacheable("stats")
	@RequestMapping(method=RequestMethod.GET, value={"/stats"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Integer>> getGlobalStats(){
		
		List<Problem> pro = (List<Problem>)problemRepo.findAll();
		List<Solution> sol = (List<Solution>)solutionRepo.findAll();
		List<User> usr = (List<User>)userRepo.findAll();
		
		Map<String, Integer> stats = new HashMap<>();
		stats.put("Problems", pro.size());
		stats.put("Submissions", sol.size());
		stats.put("Users", usr.size());
		
		return new ResponseEntity<Map<String, Integer>>((Map<String, Integer>) stats, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/stats/userId"})
	public void getPersonalStats(){
		
	}

}
