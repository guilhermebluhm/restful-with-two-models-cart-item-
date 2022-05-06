package br.twoModels.projectRelationshipTwoModels.service;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import br.twoModels.projectRelationshipTwoModels.model.Item;
import br.twoModels.projectRelationshipTwoModels.model.dto.CartDto;
import br.twoModels.projectRelationshipTwoModels.model.dto.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto addNewItem(Item item);
    void removeItem(int id);
    ItemDto findSpecifyItem(int id);
    List<ItemDto> listAllItems();

}
