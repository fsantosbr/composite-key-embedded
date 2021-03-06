package br.com.fsantosinfo.compositekeyembedded.model.mapper;

import org.mapstruct.Mapper;

import br.com.fsantosinfo.compositekeyembedded.model.ErrorGame;
import br.com.fsantosinfo.compositekeyembedded.model.dto.ErrorGamePKRequestDTO;
import br.com.fsantosinfo.compositekeyembedded.model.dto.ErrorGamePKResponseDTO;
import br.com.fsantosinfo.compositekeyembedded.model.dto.ErrorGameRequestDTO;
import br.com.fsantosinfo.compositekeyembedded.model.dto.ErrorGameResponseDTO;
import br.com.fsantosinfo.compositekeyembedded.model.pk.ErrorGamePK;

@Mapper(componentModel = "spring")
public interface ErrorGameMapper {

    ErrorGameResponseDTO toErrorGameResponseDTO(ErrorGame errorGameModel);

    ErrorGame toErrorGameModel(ErrorGameRequestDTO errorGameRequestDTO);

    ErrorGamePK toPKModel(ErrorGamePKRequestDTO pkRequestDTO);

    ErrorGamePKResponseDTO toPKResponseDTO(ErrorGamePK errorGamePkModel);
}
