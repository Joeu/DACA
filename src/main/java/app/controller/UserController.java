package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Solution;
import app.model.User;
import app.model.UserDTO;
import app.service.UserRepository;

@RestController
@RequestMapping("/ws")
public class UserController implements ErrorController{
	
	private static final String PATH = "/error";
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/user")
	public String getUser(){
		//return (List<User>) userRepo.findAll();
		return "Te fode Joeu";
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/user/{id}"})
	public User getUserById(@PathVariable long id){
		return (User) userRepo.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value={"user"})
	public ResponseEntity<String> createUser(@RequestBody UserDTO userDto){
		User user = new User(userDto.getName(), userDto.getEmail(), userDto.getPassword());
		userRepo.save(user);
		 return new ResponseEntity<String>(user.getEmail() + " created", HttpStatus.OK);
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
	
    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
