package com.rsjavasolutions.jsonb.car.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarRequest implements Serializable {
    @NotEmpty
    private String brand;
    @NotEmpty
    private String model;
    @NotNull
    private Integer year;
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
    @NotEmpty
    private Set<String> equipment;
    private String configuration;
}
