package app.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Problem;
import app.model.Solution;
import app.model.Submission;

import app.service.ProblemRepository;

@RestController
public class ProblemController {
	
	@Autowired
	private ProblemRepository problemRepo;
	
	/**
	 * Retorna os problemas so sistema
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value={"/problem"})
	public List<Problem> getProblems(){
		return (List<Problem>) problemRepo.findAll();
	}
	
	/**
	 * Retorna o problema indicado por id
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value={"/problem/{id}"})
	public Problem getProblemById(@PathVariable long id){
		return problemRepo.findById(id);
	}
	
	/**
	 * Retorna as soluções de um problema
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET, value={"/problem/{id}/solution"})
	public List<Solution> getProblemSolutions(@PathVariable long id){
		Problem problem = problemRepo.findById(id);
		return (List<Solution>) problem.getSolutions();
	}
	
	/**
	 * Retorna solução específica
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value={"/problem/{id_prob}/solution/{id_sol}"})
	public Solution getProblemSolutionById(@PathVariable long id_prob, @PathVariable long id_sol){
		Problem problem = problemRepo.findById(id_prob);
		for (Solution solution : problem.getSolutions()) {
			if (solution.getId() == id_sol){
				return solution;
			}
		}
		return null;
	}
	
	/**
	 * Usuário cadastrado cria um novo problema
	 * @param problem
	 * @return 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value={"/problem"})
	public void createProblem(@RequestBody Problem problem){
		problemRepo.save(problem);
	}
	
	/**
	 * Remove um determinado problema
	 * @param id
	 */
	@RequestMapping(method=RequestMethod.DELETE, value={"/problem/{id}"})
	public void deleteProblem(@PathVariable String id){
		problemRepo.delete(id);
	
	}
	
	/**
	 * Edita um problema
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, value={"/problem/{id}"})
	public Problem updateProblem(@PathVariable long id){
		Problem problem = problemRepo.findById(id);
		problem.setName("TESTE MUDANCA");
		return problem;
	}
	
	/**
	 * Usuário posta solução para o problema
	 * @param submission
	 * @param id
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, value={"/problem/{id}/solution"})
	public void submitSolution(@RequestBody Submission submission, @PathVariable long id){
		Problem problem = problemRepo.findById(id);	
		problem.getSolutions().add(submission.getSolution());
	}
	
//	/**
//	 * Deleta teste específico
//	 * @return
//	 */
//	@RequestMapping(method=RequestMethod.DELETE, value={"problem/{id}/test/{id}"})
//	public void deleteTeste(@PathVariable long id_prob, @PathVariable long id_test){
//		Problem problem = problemRepo.findById(id_prob);
//		Iterator<Test> itr = problem.getTests().iterator();
//		while (itr.hasNext()){
//			Test t = itr.next();
//			if (t.getId() == id_test){
//				itr.remove();
//			}
//		}
//	}
	
	/**
	 * Edita teste específico
	 * @return
	 */
	@RequestMapping(method=RequestMethod.PUT, value={"problem/{id}/test/{id}"})
	public String updateTeste(){
		return "Rota para editar Teste";
	}
	
	/**
	 * Retorna testes do problema
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value={"problem/{id}/test"})
	public String getTeste(){
		return "Rota para Teste";
	}
	
	/**
	 * Retorna teste específico
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value={"problem/{id}/test/{id}"})
	public String getTesteById(){
		return "Rota para Teste";
	}

	
}
