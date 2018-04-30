package com.davidhenriquez.rehabilicop.business_logic.validation;

public class ValidationResult {
	 
	 private String key;
	 private String message;

     public ValidationResult(String key, String message)
     {
         this.setKey(key);
         this.setMessage(message);
     }

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
