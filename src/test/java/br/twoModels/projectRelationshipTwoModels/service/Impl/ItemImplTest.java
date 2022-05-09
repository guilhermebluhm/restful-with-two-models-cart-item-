package br.twoModels.projectRelationshipTwoModels.service.Impl;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.Item;
import br.twoModels.projectRelationshipTwoModels.model.dto.ItemDto;
import br.twoModels.projectRelationshipTwoModels.repository.ItemRepository;
import br.twoModels.projectRelationshipTwoModels.service.exception.ObjectNotFoundInSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ItemImplTest {

    public static final int ID = 1;
    public static final String SERIAL = "2131514";
    @InjectMocks
    ItemImpl impl;

    @Mock
    ItemRepository itm_repository;

    ItemDto dto;
    Item item;
    Cart cart;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.inicializarModelos();
    }

    @Test
    void addNewItem() {
        Mockito.when(this.itm_repository.save(item)).thenReturn(item);
        dto = this.impl.addNewItem(item);
        Assertions.assertEquals(dto.getId(),1);
        Assertions.assertEquals(dto.getDescription(),"TV");
    }

    @Test
    void getItem() {
        Mockito.when(this.itm_repository.findById(ID)).thenReturn(Optional.of(item));
        Assertions.assertEquals(Mockito.anyList(), item.getActive_cart().getCart_items());
        try{
            this.impl.getItem(ID);
        }
        catch (ObjectNotFoundInSearch e){
            Assertions.assertEquals(ObjectNotFoundInSearch.class,e.getClass());
        }
    }

    @Test
    void removeItem() {
        Mockito.when(this.itm_repository.findById(ID)).thenReturn(Optional.of(item));
        this.impl.removeItem(ID);
        Mockito.verify(this.itm_repository,Mockito.times(1)).deleteById(ID);
    }

    @Test
    void findSpecifyItem() {
        Mockito.when(this.itm_repository.findById(ID)).thenReturn(Optional.of(item));
    }

    @Test
    void listAllItems() {
        Mockito.when(this.itm_repository.findAll()).thenReturn(List.of(item));
        Mockito.when(this.impl.listAllItems()).thenReturn(List.of(dto));
    }

    private void inicializarModelos(){
        cart = new Cart(ID, SERIAL);
        item = new Item(1,"TV",cart);
        dto = new ItemDto(item);
    }
}