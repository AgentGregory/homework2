package com.agentgregory.homework2.repository;

import com.agentgregory.homework2.model.FileNodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileNodeRepository extends JpaRepository<FileNodeEntity, Long> {
    Optional<FileNodeEntity> findByName(String name);
}
