package org.example.springboot.repositories;

import org.example.springboot.dto.WikimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaEntity, Long> {
}
