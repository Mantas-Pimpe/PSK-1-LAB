package org.uni.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.uni.entities.Sale;
import org.uni.entities.Salesman;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class SalesmanDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    //List<SaleDTO> sales = new ArrayList<>();

    public static SalesmanDTO formEntity(Salesman entity){
        SalesmanDTO dto = new SalesmanDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        //dto.setSales(entity.getSales().stream().map(SaleDTO :: formEntity).collect(Collectors.toList()));
        return dto;
    }
}
