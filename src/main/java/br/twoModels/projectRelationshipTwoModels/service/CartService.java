package br.twoModels.projectRelationshipTwoModels.service;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.dto.CartDto;

import java.util.List;

public interface CartService {

    CartDto addNewCart(Cart cart);
    void removeCart(int id);
    CartDto findSpecifyCart(int id);
    List<CartDto> listAllCarts();
    CartDto addItemOnCart(int idCart, int idItem);

}
