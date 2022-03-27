package com.rsjavasolutions.jsonb.car.model;

import com.rsjavasolutions.jsonb.utils.SemicolonSeparatedStringConverter;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@FieldNameConstants
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    @Column(unique = true)
    @Setter(AccessLevel.NONE)

    private String uuid;
    private String brand;
    private String model;
    private Integer year;
    private BigDecimal price;
    @Setter(AccessLevel.NONE)
    private LocalDateTime creationDateTime;
    @Convert(converter = SemicolonSeparatedStringConverter.class)
    private Set<String> equipment;
    @Column(columnDefinition = "jsonb")
    private String configuration;

    public CarEntity(String brand,
                     String model,
                     int year,
                     BigDecimal price,
                     Set<String> equipment,
                     String configuration) {
        this.uuid = UUID.randomUUID().toString();
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.creationDateTime = LocalDateTime.now();
        this.equipment = equipment;
        this.configuration = configuration;
    }
}

