package app.model;

public class ProblemDTO {
	
	private String description;
	private String name;
	private String status;
	private String tip;
	
	public ProblemDTO(String description, String name, String status, String tip) {
		super();
		this.description = description;
		this.name = name;
		this.status = status;
		this.tip = tip;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	
	

}
