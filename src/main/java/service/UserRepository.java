package service;

import org.springframework.data.repository.CrudRepository;

import model.User;

public interface UserRepository extends CrudRepository<User, String>{
	
	Iterable<User> findAll();
	Iterable<User> findById(long id);
	Iterable<User> findByEmail(String email);

}
