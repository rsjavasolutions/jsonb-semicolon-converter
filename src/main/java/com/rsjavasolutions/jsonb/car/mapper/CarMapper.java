package com.rsjavasolutions.jsonb.car.mapper;


import com.rsjavasolutions.jsonb.car.model.CarEntity;
import com.rsjavasolutions.jsonb.car.request.CarRequest;
import com.rsjavasolutions.jsonb.car.response.CarResponse;

public class CarMapper {

    public static CarEntity mapToEntity(CarRequest request) {
        return new CarEntity(
                request.getBrand(),
                request.getModel(),
                request.getYear(),
                request.getPrice(),
                request.getEquipment(),
                request.getConfiguration()
        );
    }

    public static CarResponse mapToResponse(CarEntity entity) {
        return new CarResponse(
                entity.getUuid(),
                entity.getId(),
                entity.getBrand(),
                entity.getModel(),
                entity.getYear(),
                entity.getPrice(),
                entity.getCreationDateTime(),
                entity.getEquipment(),
                entity.getConfiguration());
    }
}
