package com.shahraz.service.repository;

import com.shahraz.model.Visitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    @EntityGraph(attributePaths = "addresses")
    Page<Visitor> findAll(Pageable pageable);
}
