package app.service;

import org.springframework.data.repository.CrudRepository;

import app.model.Problem;
import app.model.Solution;
import app.model.User;

public interface SolutionRepository extends CrudRepository<Solution, String>{
	
	Solution findById(long id);
	User findByIdUser(long id_user);
	Problem findByIdProblem(long id_problem);

}
