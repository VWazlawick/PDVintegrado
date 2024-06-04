package br.unipar.pdvtrabalho.controllers;

import br.unipar.pdvtrabalho.exceptions.ErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorException handlerException(Exception ex){
        return new ErrorException(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorException> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex){
        List<String> errors = new ArrayList<>();

        for(FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        ErrorException errorException = new ErrorException(errors);

        return ResponseEntity.badRequest().body(errorException);
    }
}
