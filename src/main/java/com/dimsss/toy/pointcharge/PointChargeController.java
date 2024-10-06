package com.dimsss.toy.pointcharge;

import com.dimsss.toy.lib.NotFoundException;
import com.dimsss.toy.lib.RepositoryException;
import com.dimsss.toy.pointcharge.infra.http.InfraHttpClientException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/points")
@RequiredArgsConstructor
public class PointChargeController {
    private final PointChargeService pointChargeService;

    @PostMapping
    public ResponseEntity<Void> payment(@Valid @RequestBody PointChargeDto paymentDto) {
        try {
            this.pointChargeService.processPointCharge(paymentDto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InfraHttpClientException | RepositoryException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
