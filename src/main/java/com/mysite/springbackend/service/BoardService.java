package com.mysite.springbackend.service;

import com.mysite.springbackend.entity.Board;
import com.mysite.springbackend.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public Optional<Board> getBoardById(Long bno) {
        increaseHit(bno);
        return boardRepository.findById(bno);
    }

    public Board increaseHit(Long bno) {
        return boardRepository.findById(bno)
                .map(board -> {
                    board.setHit(board.getHit() + 1);
                    return boardRepository.save(board);
                })
                .orElse(null);
    }

}
