package org.nikola.trelloclone.service;

import org.nikola.trelloclone.dto.NewUserTaskDTO;
import org.nikola.trelloclone.entity.UserTask;

public interface UserTaskService {

    UserTask createUserTask(NewUserTaskDTO userTask);
}
