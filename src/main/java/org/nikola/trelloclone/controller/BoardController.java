package org.nikola.trelloclone.controller;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.Board;
import org.nikola.trelloclone.entity.BoardTask;
import org.nikola.trelloclone.repository.BoardRepository;
import org.nikola.trelloclone.repository.BoardTaskRepository;
import org.nikola.trelloclone.service.BoardService;
import org.nikola.trelloclone.service.BoardTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardTaskRepository boardTaskRepository;
    private final BoardRepository boardRepository;
    private final BoardTaskService boardTaskService;
    private final BoardService boardService;

    @GetMapping("/{boardId}")
    public ResponseEntity<List<BoardTask>> getAllTasksForBoard(@PathVariable(name = "boardId") Integer boardId) {
        return ResponseEntity.ok(boardTaskRepository.findAllByBoard_Id(boardId));
    }

    @GetMapping()
    public ResponseEntity<List<Board>> getAllTasksForBoard() {
        return ResponseEntity.ok(boardRepository.findAll().stream().distinct().collect(Collectors.toList()));
    }
}
