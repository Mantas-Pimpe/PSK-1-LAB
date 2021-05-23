package org.uni.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.uni.entities.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ModelDTO {
    private Integer id;
    private MarqueDTO marque;
    private String name;
   // List<CarDTO> cars = new ArrayList<>();

    public static ModelDTO formEntity(Model entity){
        ModelDTO dto = new ModelDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setMarque(MarqueDTO.formEntity(entity.getMarque()));
        //dto.setCars(entity.getCars().stream().map(CarDTO :: formEntity).collect(Collectors.toList()));
        return dto;
    }
}
