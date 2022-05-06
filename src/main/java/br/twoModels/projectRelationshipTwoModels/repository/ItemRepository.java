package br.twoModels.projectRelationshipTwoModels.repository;

import br.twoModels.projectRelationshipTwoModels.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
