package org.uni.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.uni.entities.Dealership;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DealershipDTO {
    private Integer id;
    private String name;
    private String location;
    //List<CarDTO> cars = new ArrayList<>();
    //List<SaleDTO> sales = new ArrayList<>();

    public static DealershipDTO formEntity(Dealership entity){
        DealershipDTO dto = new DealershipDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setLocation(entity.getLocation());
        //dto.setCars(entity.getCars().stream().map(CarDTO :: formEntity).collect(Collectors.toList()));
        //dto.setSales(entity.getSales().stream().map(SaleDTO :: formEntity).collect(Collectors.toList()));
        return dto;
    }
}
