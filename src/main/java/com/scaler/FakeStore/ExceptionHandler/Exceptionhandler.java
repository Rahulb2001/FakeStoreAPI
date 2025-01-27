package com.scaler.FakeStore.ExceptionHandler;

import com.scaler.FakeStore.DTO.ExceptionDTO;
import com.scaler.FakeStore.DTO.ProductNotFoundExceptionDto;
import com.scaler.FakeStore.Exception.ProductException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptionhandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDTO> HandleException(){

        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Wantedly trigereed Exception");
        exceptionDTO.setResolution("Please try again after some time");

        return new ResponseEntity<>(exceptionDTO,HttpStatus.BAD_REQUEST);

    }

    /*
    request from client   ---> controller ---> service --->jpa repository ---> database

    response from server  controller advice(incase of exception) <--- controller <--- service <---jpa repository <--- database
     */


    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> HandleProductException(ProductException e){

        ProductNotFoundExceptionDto response = new ProductNotFoundExceptionDto();
        response.setMessage(e.getId()+" not found in fake store maximum it is 20 products");
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }



}
