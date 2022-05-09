package br.twoModels.projectRelationshipTwoModels.controller;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.Item;
import br.twoModels.projectRelationshipTwoModels.model.dto.ItemDto;
import br.twoModels.projectRelationshipTwoModels.service.Impl.ItemImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemControllerTest {

    public static final int ID = 1;
    public static final String SERIAL = "2113514";
    public static final int ID1 = 1;
    public static final String TV = "TV";
    @InjectMocks
    ItemController controller;

    @Mock
    ItemImpl implementacao;

    Cart cart;
    Item item;
    ItemDto dto;
    List<ItemDto> l_dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.inicializarModelos();
    }

    @Test
    void criarNovoItem() {
        this.controller.criarNovoItem(item);
    }

    @Test
    void listarTodosItems() {
        this.controller.listarTodosItems();
    }

    @Test
    void listarItemEspecifico() {
        this.controller.listarItemEspecifico(ID);
    }

    @Test
    void removerItem() {
        this.controller.removerItem(ID);
    }

    private void inicializarModelos(){
        cart = new Cart(ID, SERIAL);
        item = new Item(ID1, TV,cart);
        dto = new ItemDto(item);
        l_dto = List.of(dto);
    }
}