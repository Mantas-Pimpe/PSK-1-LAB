package org.uni.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.uni.entities.Sale;
import java.util.Date;

@Getter
@Setter
public class SaleDTO {
    private Integer id;
    private Date saleDate;
    private Double price;
    //private DealershipDTO dealership;
    private ModelDTO model;
    private SalesmanDTO salesman;

    public static SaleDTO formEntity(Sale entity){
        SaleDTO dto = new SaleDTO();
        dto.setId(entity.getId());
        dto.setSaleDate(entity.getSaleDate());
        dto.setPrice(entity.getPrice());
        //dto.setDealership(DealershipDTO.formEntity(entity.getDealership()));
        dto.setModel(ModelDTO.formEntity(entity.getModel()));
        dto.setSalesman(SalesmanDTO.formEntity(entity.getSalesman()));
        return dto;
    }
}
