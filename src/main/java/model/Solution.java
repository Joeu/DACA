package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Solution implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="id")
//	public User author;
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="id")
//	public Problem problem;
	
	@Column
	public String content;
	
	@Column
	public String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public User getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(User author) {
//		this.author = author;
//	}
//
//	public Problem getProblem() {
//		return problem;
//	}
//
//	public void setProblem(Problem problem) {
//		this.problem = problem;
//	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
