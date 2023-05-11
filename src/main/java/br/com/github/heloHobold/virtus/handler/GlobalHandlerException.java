package br.com.github.heloHobold.virtus.handler;

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

//    @ExceptionHandler(value = {Exception.class})
//    protected ResponseEntity<ErrorMessage> handlerException(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(INTERNAL_ERROR));
//    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError ->
                "Campo '" + fieldError.getField() + "' " + fieldError.getDefaultMessage()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(validationList));
    }
}
