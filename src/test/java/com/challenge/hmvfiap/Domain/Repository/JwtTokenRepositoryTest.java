package com.challenge.hmvfiap.Domain.Repository;

import com.challenge.hmvfiap.domain.entity.JwtToken;
import com.challenge.hmvfiap.domain.repository.JwtTokenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class JwtTokenRepositoryTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private JwtTokenRepository jwtTokenRepository;

    private JwtToken jwtToken;

    @BeforeEach
    public void setup() { jwtToken = new JwtToken(); }

    @Test
    public void shouldAddTriageRecord(){
        jwtTokenRepository.save(jwtToken);
        assertNotNull(jwtToken.getToken());
    }

}
