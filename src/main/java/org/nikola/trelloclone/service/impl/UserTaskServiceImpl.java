package org.nikola.trelloclone.service.impl;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.dto.NewUserTaskDTO;
import org.nikola.trelloclone.entity.BoardTask;
import org.nikola.trelloclone.entity.Task;
import org.nikola.trelloclone.entity.UserTask;
import org.nikola.trelloclone.repository.BoardTaskRepository;
import org.nikola.trelloclone.repository.TaskRepository;
import org.nikola.trelloclone.repository.UserTaskRepository;
import org.nikola.trelloclone.service.BoardService;
import org.nikola.trelloclone.service.TaskService;
import org.nikola.trelloclone.service.UserService;
import org.nikola.trelloclone.service.UserTaskService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTaskServiceImpl implements UserTaskService {

    private final TaskRepository taskRepository;
    private final BoardTaskRepository boardTaskRepository;
    private final UserTaskRepository userTaskRepository;

    @Override
    public UserTask createUserTask(NewUserTaskDTO userTask) {
        Task newTask = taskRepository.save(userTask.getUserTask().getTask());
        userTask.getUserTask().setTask(newTask);
        UserTask newUserTask = userTaskRepository.save(userTask.getUserTask());
        BoardTask boardTask = new BoardTask();
        boardTask.setBoard(userTask.getBoard());
        boardTask.setUserTask(newUserTask);
        boardTaskRepository.save(boardTask);
        return newUserTask;
    }

    @Override
    public UserTask updateUserTask(NewUserTaskDTO userTask) {
        Task newTask = taskRepository.findById(userTask.getUserTask().getTask().getId()).orElseThrow();
        newTask.setName(userTask.getUserTask().getTask().getName());
        newTask.setDescription(userTask.getUserTask().getTask().getDescription());
        newTask.setDueDate(userTask.getUserTask().getTask().getDueDate());
        newTask.setStatus(userTask.getUserTask().getTask().getStatus());
        taskRepository.save(newTask);
        UserTask newUserTask = userTaskRepository.findById(userTask.getUserTask().getId()).orElseThrow();
        newUserTask.setTask(newTask);
        newUserTask.setUser(userTask.getUserTask().getUser());
        newUserTask.setCategory(userTask.getUserTask().getCategory());
        return userTaskRepository.save(newUserTask);
    }
}
