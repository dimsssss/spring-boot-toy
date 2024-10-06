package com.dimsss.toy.freelancer;

import com.dimsss.toy.freelancer.controller.FreelancerDto;
import com.dimsss.toy.freelancer.controller.SortType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class FreelancerRepositoryTest {
    @Autowired
    private FreelancerRepository freelancerRepository;

    @Test
    void getList() {
        FreelancerDto dto = new FreelancerDto(SortType.NAME_ASC, 0, 30);

        List<FreelancerResponse> results = freelancerRepository.getList(dto);

        assertEquals(results.get(0).getViewCount(), 2);
    }

    @Test
    void updateViewCount() {
        FreelancerViewLogEntity log = freelancerRepository.createViewLog(100);

        assertEquals(log.getFreelancerId(), 100);
    }

    @Test
    void existUser() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
           freelancerRepository.existUser(0);
        });
    }
}