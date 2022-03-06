package br.com.fsantosinfo.compositekeyembedded.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.fsantosinfo.compositekeyembedded.exception.ErrorGameBasicException;
import br.com.fsantosinfo.compositekeyembedded.model.ErrorGame;
import br.com.fsantosinfo.compositekeyembedded.model.dto.ErrorGameRequestDTO;
import br.com.fsantosinfo.compositekeyembedded.model.dto.ErrorGameResponseDTO;
import br.com.fsantosinfo.compositekeyembedded.model.mapper.ErrorGameMapper;
import br.com.fsantosinfo.compositekeyembedded.model.pk.ErrorGamePK;
import br.com.fsantosinfo.compositekeyembedded.repository.ErrorGameRepository;
import br.com.fsantosinfo.compositekeyembedded.service.ErrorGameService;

@Service
public class ErrorGameServiceImpl implements ErrorGameService {

    @Autowired
    private ErrorGameRepository errorRepository;

    @Autowired
    private ErrorGameMapper errorMapper;

    @Override
    public ErrorGameResponseDTO saveErrorGame(ErrorGameRequestDTO errorGameRequest) {
        ErrorGame errorGameModel = this.errorMapper.toErrorGameModel(errorGameRequest);

        errorGameModel.getId().setErrorSequenceNumber(
                this.errorRepository.getNextErrorSequenceCodeValue(
                        errorGameRequest.getId().getGameId(), errorGameRequest.getId().getGamePlatform()));

        return this.errorMapper.toErrorGameResponseDTO(this.errorRepository.save(errorGameModel));
    }

    @Override
    public ErrorGame findByCompositeKey(ErrorGamePK errorGameId) {
        return this.errorRepository.findById(errorGameId).orElseThrow(() -> new ErrorGameBasicException("Not Found"));
    }

    @Override
    public Page<ErrorGameResponseDTO> findErrorsByGame(int pageSize, int pageNumber, Long gameId, String gamePlatform) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        return convertPageModelToPageResponseDto(pageRequest,
                this.errorRepository.findByIdGameIdAndIdGamePlatform(gameId, gamePlatform, pageRequest));
    }

    @Override
    public Page<ErrorGameResponseDTO> convertPageModelToPageResponseDto(PageRequest pageRequest,
            Page<ErrorGame> pageErrorGameModel) {
        return new PageImpl<>(pageErrorGameModel.stream().map(errorGame -> this.errorMapper.toErrorGameResponseDTO(errorGame))
                .collect(Collectors.toList()), pageRequest, pageErrorGameModel.getNumberOfElements());
    }

    @Override
    public void deleteErrorGameByCompositeKey(Long gameId, String gamePlatform, Long errorSequenceNumber) {
        ErrorGame errorGame = findByCompositeKey(new ErrorGamePK(gameId, gamePlatform, errorSequenceNumber));
        this.errorRepository.delete(errorGame);
    }

}
