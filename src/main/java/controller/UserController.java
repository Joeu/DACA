package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Solution;
import model.User;
import service.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(method=RequestMethod.GET, value={"/user"})
	public List<User> getUser(){
		return (List<User>) userRepo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/user/{id}"})
	public User getUserById(@PathVariable long id){
		return (User) userRepo.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value={"/user"})
	public void createUser(@RequestBody User user){
		userRepo.save(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value={"/user/{id}"})
	public User updateUser(@PathVariable long id){
		User user = (User) userRepo.findById(id);
		user.setName("TESTE");
		return user;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value={"/user/{id}"})
	public void deleteUser(String id){
		userRepo.delete(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET, value={"/user/{id}/solution"})
	public List<Solution> getUserSolutions(@PathVariable long id){
		User user = (User) userRepo.findById(id);
		return (List<Solution>) user.getSolutions();
		
	}

}
