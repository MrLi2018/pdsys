package com.demo.pdsys.bean.resultinfo;

/**
 * RESTFUL 接口数据返回统一格式
 *
 * @param <T> 返回的有效数据信息
 */
public class ResponseMessage<T> {
    private int code;
    private boolean state;
    private String message;
    private T data;

    public ResponseMessage(boolean state) {
        this.state = state;
        this.code = getCodeByResult(state);
    }

    public ResponseMessage() {
    }

    public ResponseMessage(int code, boolean state, String message) {
        this.code = code;
        this.state = state;
        this.message = message;
    }

    public ResponseMessage(int code, boolean state, String message, T data) {
        this.code = code;
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public ResponseMessage(boolean state, T data) {
        this.state = state;
        this.data = data;
        this.code = getCodeByResult(state);
    }

    public ResponseMessage(boolean state, String message) {
        this.state = state;
        this.message = message;
    }

    public ResponseMessage<T> error(String message) {
        return new ResponseMessage<T>(false, message);
    }

    public ResponseMessage<T> success(String message) {
        return new ResponseMessage<T>(true, message);
    }

    public ResponseMessage<T> success(String message, T data) {
        ResponseMessage<T> responseMessage = new ResponseMessage<T>(true, message);
        responseMessage.setData(data);
        return responseMessage;
    }

    public ResponseMessage<T> success(T data) {
        ResponseMessage<T> responseMessage = new ResponseMessage<T>(true);
        responseMessage.setData(data);
        return responseMessage;
    }

    private int getCodeByResult(boolean state) {
        return state ? ResultCode.SUCCESS_STATUS.getCode() : ResultCode.NO_DATA_STATUS.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
