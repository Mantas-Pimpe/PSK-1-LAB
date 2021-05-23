package org.uni.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.uni.entities.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CarDTO {
    private Integer id;
    private ModelDTO model;
    private Date productionDate;
    private int power;
    private int torque;
    //List<DealershipDTO> dealerships = new ArrayList<>();

    public static CarDTO formEntity(Car entity){
        CarDTO dto = new CarDTO();
        dto.setId(entity.getId());
        dto.setModel(ModelDTO.formEntity(entity.getModel()));
        dto.setProductionDate(entity.getProductionDate());
        dto.setPower(entity.getPower());
        //dto.setDealerships(entity.getDealerships().stream().map(DealershipDTO :: formEntity).collect(Collectors.toList()));
        return dto;
    }
}
