package com.Employee.RegisterLogin.response;

public class LoginResponse {
    String message;
    Boolean status;
    private String token;

    public LoginResponse() {
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
    
    public LoginResponse(String message, Boolean status, String token) {
        this.message = message;
        this.status = status;
        this.token= token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

//    @Override
//    public String toString() {
//        return "LoginResponse{" +
//                "message='" + message + '\'' +
//                ", status=" + status +
//                '}';
//    }
}
