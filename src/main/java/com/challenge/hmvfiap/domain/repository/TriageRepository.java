package com.challenge.hmvfiap.domain.repository;

import com.challenge.hmvfiap.domain.entity.Triage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriageRepository extends JpaRepository<Triage, Long> {
}