package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class UserController{
	
	private static final String PATH = "/error";
	
	@Autowired
	private UserRepository userRepo;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET, value={"/user"})
	public ResponseEntity<List<User>> getUser(){
		return new ResponseEntity<List<User>>((List<User>) userRepo.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value={"/user/{id}"})
	public User getUserById(@PathVariable long id){
		return (User) userRepo.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value={"/user"}, produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody UserDTO userDto){
		User user = new User(userDto.getEmail(), userDto.getPassword(), userDto.getType());
		userRepo.save(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value={"/user/{id}"})
	public ResponseEntity<User> updateUser(@PathVariable long id){
		User user = (User) userRepo.findById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value={"/user/{id}"})
	public ResponseEntity<String> deleteUser(String id){
		userRepo.delete(id);
		return new ResponseEntity<String>("Removido com sucesso", HttpStatus.OK);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET, value={"/user/{id}/solution"})
	public  ResponseEntity<List<Solution>> getUserSolutions(@PathVariable long id){
		User user = (User) userRepo.findById(id);
		return new  ResponseEntity<List<Solution>>((List<Solution>) user.getSolutions(), HttpStatus.OK);
		
	}
	
//    @RequestMapping(value = PATH)
//    public ResponseEntity<> error() {
//        return n;
//    }
//
//	@Override
//	public String getErrorPath() {
//		return PATH;
//	}

}
