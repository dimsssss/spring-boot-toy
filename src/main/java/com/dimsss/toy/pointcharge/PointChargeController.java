package com.dimsss.toy.pointcharge;

import com.dimsss.toy.lib.NotFoundException;
import com.dimsss.toy.lib.RepositoryException;
import com.dimsss.toy.pointcharge.domain.CreateDiscountPolicy;
import com.dimsss.toy.pointcharge.domain.CreatePointPolicy;
import com.dimsss.toy.pointcharge.domain.DiscountPolicy;
import com.dimsss.toy.pointcharge.domain.PointPolicy;
import com.dimsss.toy.pointcharge.infra.http.CreatePgClient;
import com.dimsss.toy.pointcharge.infra.http.InfraHttpClientException;
import com.dimsss.toy.pointcharge.infra.http.PgClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    private final CreatePgClient createPgClient;
    private final CreateDiscountPolicy createDiscountPolicy;
    private final CreatePointPolicy createPointPolicy;

    @PostMapping
    public ResponseEntity<Void> payment(@Valid @RequestBody PointChargeDto pointChargeDto) {
        try {
            PgClient pgClient = createPgClient.create(pointChargeDto.getPgType());
            DiscountPolicy discountPolicy = createDiscountPolicy.createDiscountPolicy(pointChargeDto.getDiscountType());
            PointPolicy pointPolicy = createPointPolicy.createPointPolicy(pointChargeDto.getPointType());

            this.pointChargeService.processPointCharge(pointChargeDto, pgClient, discountPolicy, pointPolicy);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (InfraHttpClientException | RepositoryException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
