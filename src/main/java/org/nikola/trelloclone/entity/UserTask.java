package org.nikola.trelloclone.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_task")
public class UserTask {

    @Id
    @Column(name = "user_task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_fk", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_fk", referencedColumnName = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "category_fk", referencedColumnName = "category_id")
    private Category category;

}
