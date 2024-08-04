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
    @JoinColumn(name = "user_on_task_fk", referencedColumnName = "user_on_task_id")
    private UserOnTask user;

    @ManyToOne
    @JoinColumn(name = "category_fk", referencedColumnName = "category_id")
    private Category category;
}
