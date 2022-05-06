package br.twoModels.projectRelationshipTwoModels.service.Impl;

import br.twoModels.projectRelationshipTwoModels.model.Item;
import br.twoModels.projectRelationshipTwoModels.model.dto.ItemDto;
import br.twoModels.projectRelationshipTwoModels.repository.ItemRepository;
import br.twoModels.projectRelationshipTwoModels.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemImpl implements ItemService {

    @Autowired
    ItemRepository item_repository;

    @Override
    public ItemDto addNewItem(Item item) {
        return ItemDto.castToDto(this.item_repository.save(item));
    }

    protected Item getItem(int id){
        return this.item_repository.findById(id).orElseThrow(() -> new RuntimeException("erro"));
    }

    @Override
    public void removeItem(int id) {
        ItemDto dto = this.findSpecifyItem(id);
        this.item_repository.deleteById(dto.getId());
    }

    @Override
    public ItemDto findSpecifyItem(int id) {
        return
                ItemDto
                        .castToDto(this.item_repository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("impossivel localizar")));
    }

    @Override
    public List<ItemDto> listAllItems() {
        return ItemDto.castToListDto(this.item_repository.findAll());
    }
}
