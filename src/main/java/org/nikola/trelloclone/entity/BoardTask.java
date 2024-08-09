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
    @Column(name = "task_fk")
    private UserTask user;

    @ManyToOne
    @Column(name = "board_fk")
    private Board board;
}
