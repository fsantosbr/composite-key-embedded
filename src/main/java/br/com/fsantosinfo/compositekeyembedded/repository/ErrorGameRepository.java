package br.com.fsantosinfo.compositekeyembedded.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fsantosinfo.compositekeyembedded.model.ErrorGame;
import br.com.fsantosinfo.compositekeyembedded.model.pk.ErrorGamePK;

@Repository
public interface ErrorGameRepository extends JpaRepository<ErrorGame, ErrorGamePK> {
    
    @Query(value = "SELECT NVL(MAX(ERROR_SEQUENCE_NUMBER), 0) + 1 maxSequence "
    + " FROM TB_ERROR_GAME "
    + "WHERE GAME_ID = :gameId AND GAME_PLATFORM = :gamePlatform ", nativeQuery = true)
    Long getNextErrorSequenceCodeValue(@Param("gameId") Long gameId, @Param("gamePlatform") String gamePlatform);
    // we're using this method when we don't want to use Oracle Sequences in the @IdClass or because we're using embedded annotation and the field is in it.
    
    Page<ErrorGame> findByIdGameIdAndIdGamePlatform(Long gameId, String gamePlatform, Pageable pageable);    
}
