package com.rsjavasolutions.jsonb.car.service;

import com.rsjavasolutions.jsonb.car.CarRepository;
import com.rsjavasolutions.jsonb.car.exception.CarNotFoundException;
import com.rsjavasolutions.jsonb.car.mapper.CarMapper;
import com.rsjavasolutions.jsonb.car.model.CarEntity;
import com.rsjavasolutions.jsonb.car.request.CarRequest;
import com.rsjavasolutions.jsonb.car.response.CarResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rsjavasolutions.jsonb.car.mapper.CarMapper.mapToEntity;
import static com.rsjavasolutions.jsonb.car.mapper.CarMapper.mapToResponse;


@Slf4j
@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Transactional
    public List<CarResponse> getCars() {

        return carRepository.findAll().stream()
                .map(CarMapper::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public CarResponse getCar(String uuid) {
        CarEntity carEntity = carRepository.findByUuid(uuid).orElseThrow(() -> new CarNotFoundException(uuid));
        return mapToResponse(carEntity);
    }

    @Transactional
    public String saveCar(CarRequest request) {
        log.debug("Save car request with params: {}", request);

        CarEntity carEntity = mapToEntity(request);

        return carRepository.save(carEntity).getUuid();
    }

    @PostConstruct
    public void saveCarData(){
        CarEntity car1 = new CarEntity(
                "ford",
                "mustang",
                2020,
                new BigDecimal("80000"),
                Set.of("fele"),
                "{\n" +
                        "    \"fruit\": \"Apple\",\n" +
                        "    \"size\": \"Large\",\n" +
                        "    \"color\": \"Red\"\n" +
                        "}"
        );

        carRepository.save(car1);
    }


    @Transactional
    public void deleteCar(String uuid) {
        carRepository.deleteByUuid(uuid);
    }
}
