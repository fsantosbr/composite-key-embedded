package br.com.fsantosinfo.compositekeyembedded.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorGameResponseDTO implements Serializable {

    private static final long serialVersionUID = 2L;

    private ErrorGamePKResponseDTO id;
    private Integer errorCode;
    private String errorMessage;
}
