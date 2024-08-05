package org.nikola.trelloclone.repository;

import org.nikola.trelloclone.entity.UserOnTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOnTaskRepository extends JpaRepository<UserOnTask, Integer> {

}
