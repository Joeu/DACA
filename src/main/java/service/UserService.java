package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getUsers(){
		return (List<User>) userRepo.findAll();
	}
	
}
