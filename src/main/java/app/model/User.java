package app.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public User(String name) {
		super();
		this.name = name;
	}
    
    public User(String type, String name, String email) {
		super();
		this.type = type;
		this.name = name;
		this.email = email;
	}
	
	@Id
    @GeneratedValue
    private Long id;

    @Column
	public String type;
	
	@Column
	public String name;
	
	@Column
	public String email;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Solution> solutions;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(Set<Solution> solutions) {
		this.solutions = solutions;
	}

}
