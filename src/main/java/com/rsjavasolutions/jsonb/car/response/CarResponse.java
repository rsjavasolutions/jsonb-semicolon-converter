package com.rsjavasolutions.jsonb.car.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarResponse {
    @EqualsAndHashCode.Include
    private final String uuid;
    private final long id;
    private final String band;
    private final String model;
    private final int year;
    private final BigDecimal price;
    private final LocalDateTime creationDateTime;
    private final Set<String> equipment;
    private final String configuration;
}
