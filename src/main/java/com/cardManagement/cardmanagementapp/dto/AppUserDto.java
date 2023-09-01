package com.cardManagement.cardmanagementapp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
	
public class AppUserDto {
	    
	    @NotEmpty
	    private String name;
	    @NotEmpty(message = "Email should not be empty")
	    @Email
	    private String email;
	    @NotEmpty(message = "Password should not be empty")
	    private String password;
	    
		public AppUserDto() {
			super();
		}
		public AppUserDto(@NotEmpty String name,
				@NotEmpty(message = "Email should not be empty") @Email String email,
				@NotEmpty(message = "Password should not be empty") String password) {
			super();
			this.name = name;
			this.email = email;
			this.password = password;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
	    
	  
	}

