package br.twoModels.projectRelationshipTwoModels.service;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.dto.CartDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CartService {

    CartDto addNewCart(Cart cart);
    void removeCart(int id);
    CartDto findSpecifyCart(int id);
    Page<Cart> listAllCarts(int pageInfo, int tamPage, String field);
    CartDto addItemOnCart(int idCart, int idItem);

}
