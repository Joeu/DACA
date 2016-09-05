package service;

import org.springframework.data.repository.CrudRepository;

import model.Problem;
import model.Solution;
import model.User;

public interface SolutionRepository extends CrudRepository<Solution, String>{
	
	Solution findById(long id);
	User findByIdUser(long id_user);
	Problem findByIdProblem(long id_problem);

}
