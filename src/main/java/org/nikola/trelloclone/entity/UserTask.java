package org.nikola.trelloclone.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_task")
public class UserTask {

    @Id
    @Column(name = "user_on_task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @Column(name = "user_fk")
    private User user;

    @ManyToOne
    @Column(name = "task_fk")
    private Task task;

    @ManyToOne
    @Column(name = "category_fk")
    private Category category;

}
