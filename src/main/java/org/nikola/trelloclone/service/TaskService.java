package org.nikola.trelloclone.service;

import org.nikola.trelloclone.entity.Task;

public interface TaskService {
    Task changeStatus(Task task, String status);
}
