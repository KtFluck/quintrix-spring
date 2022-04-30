package com.quintrix.jfs.quintrixspring.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // this sets exception handling at a global level instead of in each controller
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "This should be application specific";

    Error error = new Error();
    error.setMessage("This is an IllegalArgumentException or an IllegalStateException");
    error.setCustomMessage(ex.getMessage());
    error.setHttpStatusCode(HttpStatus.CONFLICT.value());
    return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT,
        request);
  }

  @ExceptionHandler({CarNotFoundException.class})
  public ResponseEntity<Object> handleException2(Exception ex, WebRequest request) {
    HttpHeaders headers = new HttpHeaders();

    if (ex instanceof CarNotFoundException) {
      HttpStatus status = HttpStatus.NOT_FOUND;
      CarNotFoundException cnfe = (CarNotFoundException) ex;

      Error error = new Error();
      error.setMessage(((CarNotFoundException) ex).detailedMessage);
      error.setCustomMessage(((CarNotFoundException) ex).detailedMessage);
      error.setHttpStatusCode(HttpStatus.NOT_FOUND.value());

      return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    return null;
  }
}
