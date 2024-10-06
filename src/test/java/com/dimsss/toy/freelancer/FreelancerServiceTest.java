package com.dimsss.toy.freelancer;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.dimsss.toy.lib.NotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

@SpringBootTest
class FreelancerServiceTest {

    @Autowired
    private FreelancerService freelancerService;

    @Mock
    private FreelancerRepository freelancerRepository;

    @DisplayName("존재하지 않는 유저일 경우 NotFoundException 예외를 발생 시킨다")
    @Test
    void update_will_throw_when_user_not_exist() {
        int notExistId = 0;
        Mockito.doThrow(new NoSuchElementException()).when(freelancerRepository).existUser(notExistId);
        when(freelancerRepository.createViewLog(notExistId)).thenThrow(NotFoundException.class);
    }
}