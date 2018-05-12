package com.davidhenriquez.rehabilicop.core.validation;

import java.util.Collection;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1L;
	private Collection<ValidationResult> errors;
	
	public ValidationException(Collection<ValidationResult> errors){
		super(GetFirstErrorMessage(errors));
	    this.errors = errors;
	}
	
	private static String GetFirstErrorMessage(Collection<ValidationResult> errors){
	    return errors.iterator().next().getMessage();	             
	}

	public Collection<ValidationResult> getErrors() {
		return errors;
	}

	public void setErrors(Collection<ValidationResult> errors) {
		this.errors = errors;
	}
}
