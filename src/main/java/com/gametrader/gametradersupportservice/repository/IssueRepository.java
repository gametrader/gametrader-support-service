package com.gametrader.gametradersupportservice.repository;

import com.gametrader.gametradersupportservice.entity.IssueEntity;
import com.gametrader.gametradersupportservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssueRepository extends JpaRepository<IssueEntity, Long> {

    List<IssueEntity> getAllByAuthorId(Long authorId);

    @Query(value = "SELECT * FROM issue WHERE issue.is_resolved = false ", nativeQuery = true)
    List<IssueEntity> getAllByIsResolvedFalse();

    List<IssueEntity> getAllByCategory(Category category);
}
