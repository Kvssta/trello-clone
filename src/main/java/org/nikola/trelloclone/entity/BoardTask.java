package org.nikola.trelloclone.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "board_task")
public class BoardTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_task_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "task_fk", referencedColumnName = "user_task_id")
    private UserTask userTask;

    @ManyToOne
    @JoinColumn(name = "board_fk", referencedColumnName = "board_id")
    private Board board;
}
