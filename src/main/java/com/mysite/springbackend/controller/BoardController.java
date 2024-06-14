package com.mysite.springbackend.controller;

import com.mysite.springbackend.entity.Board;
import com.mysite.springbackend.entity.User;
import com.mysite.springbackend.exception.UserNotFoundException;
import com.mysite.springbackend.repository.BoardRepository;
import com.mysite.springbackend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;

    @PostMapping("/board")
    public Board newBoard(@RequestBody Board newboard) {
        return boardRepository.save(newboard);
    }

    @GetMapping("/boards")
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @GetMapping("/board/{bno}")
    public Optional<Board> getBoardByBno(@PathVariable Long bno) {
        return boardService.getBoardById(bno);
    }

    @PutMapping("/board/{bno}")
    Board updateUser(@RequestBody Board updateUser, @PathVariable Long bno) {
        return boardRepository.findById(bno)
                .map(board -> {
                    board.setTitle(updateUser.getTitle());
                    board.setWriter(updateUser.getWriter());
                    board.setContent(updateUser.getContent());
                    return boardRepository.save(board);
                }).orElseThrow(() -> new UserNotFoundException(bno));
    }

    @DeleteMapping("/board/{bno}")
    String deleteUser(@PathVariable Long bno) {
        if(!boardRepository.existsById(bno)){
            throw new UserNotFoundException(bno);
        }
        boardRepository.deleteById(bno);
        return  "게시글" + bno + "번이 삭제 되었습니다.";
    }

    // 조회수 증가 엔드포인트
//    @PostMapping("/increaseHit/{bno}")
//    public void increaseHit(@PathVariable Long bno) {
//        boardService.increaseHit(bno);
//    }
}
