package com.challenge.hmvfiap.Domain.Repository;

import com.challenge.hmvfiap.domain.entity.Triage;
import com.challenge.hmvfiap.domain.enums.UrgencyRank;
import com.challenge.hmvfiap.domain.repository.TriageRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TriageRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private TriageRepository triageRepository;

    private Triage triage;

    @BeforeEach
    public void setup() { triage = new Triage(); }

    @Test
    public void shouldAddTriageRecord(){
        triageRepository.save(triage);
        assertNotNull(triage.getUserId());
    }

    @Test
    public void ShouldFetchTriageRecord() {
        triageRepository.save(triage);
        Optional<Triage> triageDb = triageRepository.findById(triage.getId());
        assertTrue(triageDb.isPresent());
    }

    @Test
    public void ShouldDeleteTriageRecord() {
        triageRepository.save(triage);
        assertFalse(triageRepository.findAll().isEmpty());
        triageRepository.delete(triage);
        assertTrue(triageRepository.findAll().isEmpty());
    }

    @Test
    public void ShouldUpdateTriageRecord() {
        triageRepository.save(triage);
        triage.setUrgencyRank(UrgencyRank.URGENTE);
        triageRepository.save(triage);
        Optional<Triage> triageDb = triageRepository.findById(triage.getUserId());
        assertTrue(triageDb.isPresent());
        assertEquals(triage.getUrgencyRank(), triageDb.get().getUrgencyRank());
    }
}
