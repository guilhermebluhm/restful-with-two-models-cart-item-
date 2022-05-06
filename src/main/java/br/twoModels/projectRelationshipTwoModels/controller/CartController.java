package br.twoModels.projectRelationshipTwoModels.controller;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.Item;
import br.twoModels.projectRelationshipTwoModels.model.dto.CartDto;
import br.twoModels.projectRelationshipTwoModels.model.dto.ItemDto;
import br.twoModels.projectRelationshipTwoModels.service.Impl.CartImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartImpl implementacao;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto criarNovoCart(@RequestBody Cart cart){
        return this.implementacao.addNewCart(cart);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<CartDto> listarTodosCarts(){
        return this.implementacao.listAllCarts();
    }

    @GetMapping("/listar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CartDto listarCartEspecifico(@PathVariable("id") int id){
        return this.implementacao.findSpecifyCart(id);
    }

    @DeleteMapping("/remover/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCart(@PathVariable("id") int id){
        this.implementacao.removeCart(id);
    }

    @PostMapping("/{idCart}/item/{idItem}/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CartDto adicionarItemCarro(@PathVariable("idCart") int idCart,
                                      @PathVariable("idItem") int idItem){
        return this.implementacao.addItemOnCart(idCart,idItem);
    }
}
