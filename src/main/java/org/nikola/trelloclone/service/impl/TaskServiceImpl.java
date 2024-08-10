package org.nikola.trelloclone.service.impl;

import lombok.RequiredArgsConstructor;
import org.nikola.trelloclone.entity.Task;
import org.nikola.trelloclone.entity.TaskStatus;
import org.nikola.trelloclone.repository.TaskRepository;
import org.nikola.trelloclone.service.TaskService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Override
    public Task changeStatus(Task task, String status) {
        task.setStatus(TaskStatus.valueOf(status));
        return taskRepository.save(task);
    }
}
