package br.twoModels.projectRelationshipTwoModels.controller;

import br.twoModels.projectRelationshipTwoModels.model.Item;
import br.twoModels.projectRelationshipTwoModels.model.dto.ItemDto;
import br.twoModels.projectRelationshipTwoModels.service.Impl.ItemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemImpl implementacao;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto criarNovoItem(@RequestBody Item item){
        return this.implementacao.addNewItem(item);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> listarTodosItems(){
        return this.implementacao.listAllItems();
    }

    @GetMapping("/listar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ItemDto listarItemEspecifico(@PathVariable("id") int id){
        return this.implementacao.findSpecifyItem(id);
    }

    @DeleteMapping("/remover/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerItem(@PathVariable("id") int id){
        this.implementacao.removeItem(id);
    }

}
