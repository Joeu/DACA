package app.service;

import org.springframework.data.repository.CrudRepository;

import app.model.Problem;

public interface ProblemRepository extends CrudRepository<Problem, String>{

	Problem findById(long id);
	

}
