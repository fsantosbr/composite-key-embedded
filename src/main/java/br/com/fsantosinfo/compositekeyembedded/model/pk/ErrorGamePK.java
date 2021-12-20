package br.com.fsantosinfo.compositekeyembedded.model.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Embeddable
@AllArgsConstructor
public class ErrorGamePK implements Serializable {

    private static final long serialVersionUID = 2L;
   
    @Column(name = "GAME_ID")
    private Long gameId;
    
    @Column(name = "GAME_PLATFORM")
    private String gamePlatform;
   
    @Column(name = "ERROR_SEQUENCE_NUMBER")
    private Long errorSequenceNumber;
    // we're using a native query to generate the next sequence number for this field instead of using Oracle sequences.
    // Note: Oracle sequences do not work with embedded class    
}
