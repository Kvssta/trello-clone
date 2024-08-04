package org.nikola.trelloclone.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_on_task")
public class UserOnTask {

    @Id
    @Column(name = "user_on_task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_fk", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_fk", referencedColumnName = "task_id")
    private Task task;
}
