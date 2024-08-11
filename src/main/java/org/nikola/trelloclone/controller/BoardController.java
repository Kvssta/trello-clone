package org.nikola.trelloclone.controller;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.Board;
import org.nikola.trelloclone.entity.BoardTask;
import org.nikola.trelloclone.repository.BoardRepository;
import org.nikola.trelloclone.repository.BoardTaskRepository;
import org.nikola.trelloclone.service.BoardService;
import org.nikola.trelloclone.service.BoardTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
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

    @GetMapping("/{boardTaskId}/task")
    public ResponseEntity<BoardTask> getUserTask(@PathVariable Integer boardTaskId) {
        return ResponseEntity.ok(boardTaskRepository.findById(boardTaskId).orElse(null));
    }

    @PostMapping("")
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        return ResponseEntity.ok(boardRepository.save(board));
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Integer boardId) {
        boardRepository.deleteById(boardId);
        return ResponseEntity.ok().build();
    }
}
