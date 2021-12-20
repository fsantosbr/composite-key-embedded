package br.com.fsantosinfo.compositekeyembedded.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ErrorGameRequestDTO implements Serializable {

    private static final long serialVersionUID = 2L;
    
    private ErrorGamePKRequestDTO id;

    private Integer errorCode;
    private String errorMessage;    
}
