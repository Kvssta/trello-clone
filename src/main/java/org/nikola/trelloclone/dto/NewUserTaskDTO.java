package org.nikola.trelloclone.dto;

import lombok.Data;
import org.nikola.trelloclone.entity.Board;
import org.nikola.trelloclone.entity.UserTask;

@Data
public class NewUserTaskDTO {
    private UserTask userTask;
    private Board board;
}
