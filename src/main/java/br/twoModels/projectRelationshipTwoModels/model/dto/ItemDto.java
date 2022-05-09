package br.twoModels.projectRelationshipTwoModels.model.dto;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.Item;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemDto implements Serializable {

    private Integer id;
    private String description;

    public ItemDto(Item item){
        this.id = item.getId();
        this.description = item.getDescription();
    }

    public static ItemDto castToDto(Item item){
        return new ItemDto(item);
    }

    public static List<ItemDto> castToListDto(List<Item> item){
        return item.stream().map(ItemDto::new).collect(Collectors.toList());
    }

}
