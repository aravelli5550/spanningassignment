package com.example.atmspanning.config;
import org.springframework.http.HttpStatus;
import com.example.atmspanning.model.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.InvalidParameterException;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionalHandler {
@ExceptionHandler(value=EntityNotFoundException.class)
@ResponseBody
@ResponseStatus(HttpStatus.NOT_FOUND)
public ErrorMessage handleEntityNotFoundException(EntityNotFoundException ex) {
    ErrorMessage errorMessage = new ErrorMessage();
    errorMessage.setMessage(ex.getMessage());
    errorMessage.setStatus(HttpStatus.NOT_FOUND);

    return errorMessage;
}

@ExceptionHandler(value=InvalidParameterException.class)
@ResponseBody
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ErrorMessage handleInvalidParameterException(EntityNotFoundException ex){
	ErrorMessage errorMessage = new ErrorMessage();
	errorMessage.setMessage(ex.getMessage());
	errorMessage.setStatus(HttpStatus.BAD_REQUEST);
	return errorMessage;
	
}
	
}
