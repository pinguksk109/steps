package com.ot.steps.domain.exception;

import org.springframework.validation.BindingResult;

public class BadRequestException extends Exception {
  
  private BindingResult bindingResult;
  
  public BadRequestException(String message) {
    super(message);
  }
  
  public BadRequestException(String logMessage, BindingResult bindingResult) {
    super(logMessage);
    this.bindingResult = bindingResult;
  }
  
  public BindingResult getBindingResult() {
    return this.bindingResult;
  }
  
  

}
