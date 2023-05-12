package br.com.github.heloHobold.virtus.handler;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalHandlerException extends ResponseEntityExceptionHandler {

    private static final String INTERNAL_ERROR = "Erro interno no servidor.";

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError ->
                "Campo '" + fieldError.getField() + "' " + fieldError.getDefaultMessage()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(validationList));
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity handlerConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("error: " + ex.getSQLException().getMessage());
    }

//    @ExceptionHandler(value = {Exception.class})
//    protected ResponseEntity handlerException(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error: " + ex.getLocalizedMessage());
//    }
}
