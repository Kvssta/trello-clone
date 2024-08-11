package org.nikola.trelloclone.service;

import org.nikola.trelloclone.entity.BoardTask;

import java.util.List;

public interface BoardTaskService {
    List<BoardTask> findAllByBoardIdAndUserId(Integer boardId, Integer userId);
}
