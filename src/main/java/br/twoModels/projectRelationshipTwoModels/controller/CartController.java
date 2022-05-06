package br.twoModels.projectRelationshipTwoModels.controller;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.dto.CartDto;
import br.twoModels.projectRelationshipTwoModels.service.Impl.CartImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Page<Cart> listarTodosCarts(
            @RequestParam(required = false, defaultValue = "0") int pageInfo,
            @RequestParam(required = false, defaultValue = "1") int tamPage,
            @RequestParam(required = false, defaultValue = "serialNumber") String field){
        return this.implementacao.listAllCarts(pageInfo,tamPage,field);
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
