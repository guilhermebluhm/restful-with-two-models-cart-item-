package br.twoModels.projectRelationshipTwoModels.model.dto;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartDto implements Serializable {

    private Integer id;
    private String serialNumber;
    private List<Item> cart_item;

    public CartDto(Cart cart) {
        this.id = cart.getId();
        this.serialNumber = cart.getSerialNumber();
        this.cart_item = cart.getCart_items();
    }

    public static CartDto castToDto(Cart cart){
        return new CartDto(cart);
    }
}
