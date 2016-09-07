package app.service;

import org.springframework.data.repository.CrudRepository;

import app.model.User;

public interface UserRepository extends CrudRepository<User, String>{
	
	Iterable<User> findAll();
	Iterable<User> findById(long id);
	Iterable<User> findByEmail(String email);

}
