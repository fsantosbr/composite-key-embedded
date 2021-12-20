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
public class ErrorGamePKResponseDTO implements Serializable {

    private static final long serialVersionUID = 2L;

    private Long gameId;
    private String gamePlatform;
    private Long errorSequenceNumber;
}
