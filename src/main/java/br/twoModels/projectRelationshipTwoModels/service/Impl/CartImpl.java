package br.twoModels.projectRelationshipTwoModels.service.Impl;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.Item;
import br.twoModels.projectRelationshipTwoModels.model.dto.CartDto;
import br.twoModels.projectRelationshipTwoModels.repository.CartRepository;
import br.twoModels.projectRelationshipTwoModels.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CartImpl implements CartService {

    @Autowired
    CartRepository cart_repositorio;

    @Autowired
    ItemImpl item_implementacao;

    @Override
    public CartDto addNewCart(Cart cart) {
        return CartDto.castToDto(this.cart_repositorio.save(cart));
    }

    @Override
    public void removeCart(int id) {
        CartDto dto = this.findSpecifyCart(id);
        this.cart_repositorio.deleteById(dto.getId());
    }

    private Cart getCart(int id){
        return this.cart_repositorio.findById(id).orElseThrow(() -> new RuntimeException("erro"));
    }

    @Override
    public CartDto findSpecifyCart(int id) {
        return CartDto
                .castToDto(this.cart_repositorio
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("erro ao excluir")));
    }

    @Override
    public List<CartDto> listAllCarts() {
        return CartDto.castToListDto(this.cart_repositorio.findAll());
    }

    @Override
    @Transactional
    public CartDto addItemOnCart(int idCart, int idItem) {
        Cart c = this.getCart(idCart);
        Item t = this.item_implementacao.getItem(idItem);
        c.addItem(t);
        t.setActive_cart(c);
        return CartDto.castToDto(c);
    }
}
