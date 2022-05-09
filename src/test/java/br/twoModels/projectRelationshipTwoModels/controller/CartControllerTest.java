package br.twoModels.projectRelationshipTwoModels.controller;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.dto.CartDto;
import br.twoModels.projectRelationshipTwoModels.service.Impl.CartImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import static org.junit.jupiter.api.Assertions.*;

class CartControllerTest {

    public static final int ID = 1;
    public static final String SERIAL = "2135147";
    @InjectMocks
    CartController controller;

    @Mock
    CartImpl implementacao;

    Cart cart;
    CartDto c_dto;
    Page<Cart> p_cart;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.inicializarModelos();
    }

    @Test
    void criarNovoCart() {
        this.controller.criarNovoCart(cart);
    }

    @Test
    void listarTodosCarts() {
        this.controller.listarTodosCarts(1,1,"serialNumber");
    }

    @Test
    void listarCartEspecifico() {
        this.controller.listarCartEspecifico(ID);
    }

    @Test
    void removerCart() {
        this.controller.removerCart(ID);
    }

    @Test
    void adicionarItemCarro() {
        this.controller.adicionarItemCarro(1,1);
    }

    private void inicializarModelos(){
        cart = new Cart(ID, SERIAL);
        c_dto = new CartDto(cart);
        p_cart = Mockito.mock(Page.class);
    }
}