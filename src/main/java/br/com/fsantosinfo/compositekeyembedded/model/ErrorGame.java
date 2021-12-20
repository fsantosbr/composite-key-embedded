package br.com.fsantosinfo.compositekeyembedded.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.fsantosinfo.compositekeyembedded.model.pk.ErrorGamePK;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ERROR_GAME")
@EqualsAndHashCode
public class ErrorGame implements Serializable {

    private static final long serialVersionUID = 2L;

    @EmbeddedId
    private ErrorGamePK id;

    @Column(name = "ERROR_CODE")
    private Integer errorCode;

    @Column(name = "ERROR_MESSAGE")
    private String errorMessage;
}
