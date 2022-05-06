package br.twoModels.projectRelationshipTwoModels.service.Impl;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.Item;
import br.twoModels.projectRelationshipTwoModels.model.dto.CartDto;
import br.twoModels.projectRelationshipTwoModels.repository.CartRepository;
import br.twoModels.projectRelationshipTwoModels.service.CartService;
import br.twoModels.projectRelationshipTwoModels.service.exception.ObjectNotFoundInSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
        return this.cart_repositorio.findById(id).orElseThrow(() -> new ObjectNotFoundInSearch("erro"));
    }

    @Override
    public CartDto findSpecifyCart(int id) {
        return CartDto
                .castToDto(this.cart_repositorio
                        .findById(id)
                        .orElseThrow(() -> new ObjectNotFoundInSearch("erro ao excluir")));
    }

    @Override
    public Page<Cart> listAllCarts(int pageInfo, int tamPage, String field) {
        Pageable page = PageRequest.of(pageInfo,tamPage, Sort.by(field).descending());
        return this.cart_repositorio.findAll(page);
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
