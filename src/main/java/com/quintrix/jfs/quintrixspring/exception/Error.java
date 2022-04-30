package com.quintrix.jfs.quintrixspring.exception;

public class Error {

  public String message;
  private String customMessage;
  private Integer httpStatusCode;


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getCustomMessege() {
    return customMessage;
  }

  public void setCustomMessage(String customMessage) {
    this.customMessage = customMessage;
  }

  public Integer getHttpStatusCode() {
    return httpStatusCode;
  }

  public void setHttpStatusCode(Integer httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }


}
