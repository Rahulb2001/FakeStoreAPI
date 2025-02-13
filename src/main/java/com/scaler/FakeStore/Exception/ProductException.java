package com.scaler.FakeStore.Exception;

public class ProductException extends Exception{

    private Long id;
    private String message;

    public ProductException(Long id,String message){
        super(message);
        this.id =id;
    }

    public ProductException(String message){
        super(message);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
