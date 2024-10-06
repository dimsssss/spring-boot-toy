package com.dimsss.toy.freelancer.controller;

import com.dimsss.toy.freelancer.FreelancerEntity;
import com.dimsss.toy.freelancer.FreelancerResponse;
import com.dimsss.toy.freelancer.FreelancerService;
import com.dimsss.toy.lib.NotFoundException;
import com.dimsss.toy.lib.RepositoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/freelancers")
@RestController
public class FreelancerController {
    private final FreelancerService freelancerService;

    FreelancerController(FreelancerService freelancerService) {
        this.freelancerService = freelancerService;
    }

    @GetMapping
    public ResponseEntity<List<FreelancerResponse>> freelancerList(@Validated FreelancerDto requestDto) {
        try {
            return new ResponseEntity<>(this.freelancerService.getFreelancerList(requestDto), HttpStatus.OK);
        } catch (RepositoryException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{freelancerId}")
    public ResponseEntity<List<FreelancerEntity>> updateFreelancerViewCount(@PathVariable int freelancerId) {
        try {
            this.freelancerService.update(freelancerId);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (NotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (RepositoryException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/batch/{freelancerId}")
    public ResponseEntity<List<FreelancerEntity>> batchFreelancerViewCount(@PathVariable int freelancerId) {
        try {
            this.freelancerService.batch(freelancerId);
            return new ResponseEntity<>(null, HttpStatus.CREATED);
        } catch (RuntimeException error) {
            throw new RuntimeException(error.getMessage());
        }
    }
}
