package app.service;

import org.springframework.data.repository.CrudRepository;

import app.model.Problem;

public interface ProblemRepository extends CrudRepository<Problem, Long>{

	Problem findById(long id);
	

}
