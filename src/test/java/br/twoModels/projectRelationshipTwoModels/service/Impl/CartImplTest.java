package br.twoModels.projectRelationshipTwoModels.service.Impl;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.Item;
import br.twoModels.projectRelationshipTwoModels.model.dto.CartDto;
import br.twoModels.projectRelationshipTwoModels.repository.CartRepository;
import br.twoModels.projectRelationshipTwoModels.repository.ItemRepository;
import br.twoModels.projectRelationshipTwoModels.service.exception.ObjectNotFoundInSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CartImplTest {

    public static final int ID = 1;
    public static final String SERIAL = "2012951";
    public static final int ID1 = 1;
    public static final String TV = "TV";

    @InjectMocks
    CartImpl cart_impl;

    @Mock
    CartRepository cart_repo;

    @Mock
    ItemRepository item_repo;

    @Mock
    ItemImpl item_serv;

    Item item;
    Cart cart;
    CartDto cart_dto;
    Page<Cart> page_cart;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.inicializarModels();
    }

    @Test
    void addNewCart() {
        Mockito.when(this.cart_repo.save(cart)).thenReturn(cart);
        CartDto dto = this.cart_impl.addNewCart(cart);
        Assertions.assertEquals(dto.getId(),ID);
        Assertions.assertEquals(dto.getSerialNumber(),SERIAL);
        Assertions.assertEquals(dto.getCart_item().isEmpty(),new ArrayList<>().isEmpty());
    }

    @Test
    void removeCart() {
        Mockito.when(this.cart_repo.findById(ID)).thenReturn(Optional.of(cart));
        this.cart_impl.removeCart(ID);
        Mockito.verify(this.cart_repo,Mockito.times(1)).deleteById(ID);
    }

    @Test
    void findSpecifyCart() {
        Mockito.when(this.cart_repo.findById(ID)).thenReturn(Optional.of(cart));
        try{
            this.cart_impl.findSpecifyCart(ID);
        }
        catch (ObjectNotFoundInSearch e){
            Assertions.assertEquals(ObjectNotFoundInSearch.class,e.getClass());
        }
    }

    @Test
    void getCart(){
        Mockito.when(this.cart_repo.findById(ID)).thenReturn(Optional.of(cart));
        this.cart_impl.getCart(ID);
    }

    @Test
    void listAllCarts() {
        Mockito.when(this.cart_impl.listAllCarts(1,1,"serialNumber")).thenReturn(page_cart);
    }

    @Test
    void addItemOnCart() {
        Mockito.when(this.cart_repo.findById(ID)).thenReturn(Optional.of(cart));
        this.cart_impl.getCart(ID);
        Mockito.when(this.item_repo.findById(ID1)).thenReturn(Optional.of(item));
        this.item_serv.getItem(ID1);
        cart.addItem(item);
        item.setActive_cart(cart);
        this.cart_impl.addItemOnCart(cart.getId(),item.getId());
        //Mockito.when(this.cart_impl.addItemOnCart(1,1)).thenReturn(cart_dto);
    }

    private void inicializarModels(){
        cart = new Cart(ID, SERIAL);
        item = new Item(ID1, TV,cart);
        cart_dto = new CartDto(cart);
        page_cart = Mockito.mock(Page.class);
    }
}