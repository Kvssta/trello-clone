package org.nikola.trelloclone.repository;

import org.nikola.trelloclone.entity.UserTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskRepository extends JpaRepository<UserTask, Integer> {

}
