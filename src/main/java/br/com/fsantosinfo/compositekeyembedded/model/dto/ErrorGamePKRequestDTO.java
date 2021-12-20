package br.com.fsantosinfo.compositekeyembedded.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ErrorGamePKRequestDTO implements Serializable {

    private static final long serialVersionUID = 2L;
    
    @NotNull
    private Long gameId;

    @NotBlank
    @Size(min = 2, max = 7)
    private String gamePlatform;     
    
}
