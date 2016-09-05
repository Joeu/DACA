package service;

import org.springframework.data.repository.CrudRepository;

import model.Problem;

public interface ProblemRepository extends CrudRepository<Problem, String>{

	Problem findById(long id);
	

}
