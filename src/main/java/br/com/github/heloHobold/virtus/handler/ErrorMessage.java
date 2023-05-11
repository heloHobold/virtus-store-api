package br.com.github.heloHobold.virtus.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private String message;
    private List<String> validationsErrors;

    public ErrorMessage(String message){
        this.message = message;
    }

    public ErrorMessage(List<String> validationsErrors){
        this.validationsErrors = validationsErrors;
    }

}