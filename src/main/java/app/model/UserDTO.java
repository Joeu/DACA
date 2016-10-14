package app.model;

public class UserDTO {

	private String type;
	private String email;
	private String password;
	
	public UserDTO(){
		
	}
	
	public UserDTO(String email, String password, String type) {
		super();
		this.email = email;
		this.password = password;
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}
	
	public void setTyoe(String type) {
		this.type = type;
	}
	
	

}
