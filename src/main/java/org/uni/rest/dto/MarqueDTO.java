package org.uni.rest.dto;

import lombok.Getter;
import lombok.Setter;
import org.uni.entities.Marque;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MarqueDTO {
    private Integer id;
    private String name;
    //List<ModelDTO> models = new ArrayList<>();

    public static MarqueDTO formEntity(Marque entity){
        MarqueDTO dto = new MarqueDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        //dto.setModels(entity.getModels().stream().map(ModelDTO :: formEntity).collect(Collectors.toList()));
        return dto;
    }
}
