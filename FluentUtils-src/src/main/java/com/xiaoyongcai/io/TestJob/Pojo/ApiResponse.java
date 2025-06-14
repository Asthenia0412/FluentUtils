package com.xiaoyongcai.io.TestJob.Pojo;

public class ApiResponse<T> {
    private Boolean success;
    private String code;
    private String message;
    private T data;

    // getters 和 setters
    public Boolean isSuccess() { return success; }
    public void setSuccess(Boolean success) { this.success = success; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}