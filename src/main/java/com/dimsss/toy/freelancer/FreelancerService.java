package com.dimsss.toy.freelancer;

import com.dimsss.toy.freelancer.controller.FreelancerDto;
import com.dimsss.toy.lib.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FreelancerService {
    private final FreelancerRepository freelancerRepository;

    FreelancerService(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    public List<FreelancerResponse> getFreelancerList(FreelancerDto requestDto) {
        return this.freelancerRepository.getList(requestDto);
    }


    public void batch(int freelancerId) {
        try {
            this.freelancerRepository.batch(freelancerId);
        } catch (Exception exception) {
            throw exception;
        }

    }

    @Transactional
    public void update(int freelancerId) {
        try {
            this.freelancerRepository.existUser(freelancerId);
            this.freelancerRepository.createViewLog(freelancerId);
        } catch (NoSuchElementException exception) {
            throw new NotFoundException(exception.getMessage());
        }
    }
}
