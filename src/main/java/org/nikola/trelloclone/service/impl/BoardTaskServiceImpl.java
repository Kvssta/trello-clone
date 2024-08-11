package org.nikola.trelloclone.service.impl;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.BoardTask;
import org.nikola.trelloclone.repository.BoardTaskRepository;
import org.nikola.trelloclone.service.BoardTaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardTaskServiceImpl implements BoardTaskService {

    private final BoardTaskRepository boardTaskRepository;

    @Override
    public List<BoardTask> findAllByBoardIdAndUserId(Integer boardId, Integer userId) {
        List<BoardTask> boardTasks = boardTaskRepository.findAllByBoard_Id(boardId);
        boardTasks.removeIf(boardTask -> !boardTask.getUserTask().getUser().getId().equals(userId));
        return boardTasks;
    }
}
