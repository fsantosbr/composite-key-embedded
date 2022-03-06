package br.com.fsantosinfo.compositekeyembedded.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.fsantosinfo.compositekeyembedded.model.ErrorGame;
import br.com.fsantosinfo.compositekeyembedded.model.dto.ErrorGameRequestDTO;
import br.com.fsantosinfo.compositekeyembedded.model.dto.ErrorGameResponseDTO;
import br.com.fsantosinfo.compositekeyembedded.model.pk.ErrorGamePK;

public interface ErrorGameService {

    ErrorGameResponseDTO saveErrorGame(ErrorGameRequestDTO errorGameRequest);

    ErrorGame findByCompositeKey(ErrorGamePK errorGameId);

    Page<ErrorGameResponseDTO> findErrorsByGame(int pageSize, int pageNumber, Long gameId, String gamePlatform);

    Page<ErrorGameResponseDTO> convertPageModelToPageResponseDto(PageRequest pageRequest,
            Page<ErrorGame> pageErrorGameModel);

    void deleteErrorGameByCompositeKey(Long gameId, String gamePlatform, Long errorSequenceNumber);
}
