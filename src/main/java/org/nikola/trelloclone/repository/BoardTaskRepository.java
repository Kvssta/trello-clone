package org.nikola.trelloclone.repository;

import org.nikola.trelloclone.entity.BoardTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardTaskRepository extends JpaRepository<BoardTask, Integer> {

    List<BoardTask> findAllByBoard_Id(Integer boardId);
}
