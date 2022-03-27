package com.challenge.hmvfiap.Domain.Helper;

import com.challenge.hmvfiap.api.dto.TriageInputDTO;
import com.challenge.hmvfiap.domain.enums.UrgencyRank;
import com.challenge.hmvfiap.helper.RankUrgencyHelper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class RankUrgencyHelperTest {

    @Autowired
    private RankUrgencyHelper rankUrgencyHelper;

    private TriageInputDTO triageInputDTO;
    private UrgencyRank urgencyRank;

    @BeforeEach
    public void setup() { triageInputDTO = new TriageInputDTO(); }

    @Test
    public void shouldReturnEmergente(){
        triageInputDTO.setPainLevel((short)9);
        urgencyRank = rankUrgencyHelper.Rank(triageInputDTO);
        assertEquals(urgencyRank, UrgencyRank.EMERGENTE);
    }

    @Test
    public void shouldReturnMuitoUrgente(){
        triageInputDTO.setPainLevel((short)7);
        urgencyRank = rankUrgencyHelper.Rank(triageInputDTO);
        assertEquals(urgencyRank, UrgencyRank.MUITO_URGENTE);
    }

    @Test
    public void shouldReturnUrgente(){
        triageInputDTO.setPainLevel((short)5);
        urgencyRank = rankUrgencyHelper.Rank(triageInputDTO);
        assertEquals(urgencyRank, UrgencyRank.URGENTE);
    }

    @Test
    public void shouldReturnPoucoUrgente(){
        triageInputDTO.setPainLevel((short)9);
        urgencyRank = rankUrgencyHelper.Rank(triageInputDTO);
        assertEquals(urgencyRank, UrgencyRank.POUCO_URGENTE);
    }

}