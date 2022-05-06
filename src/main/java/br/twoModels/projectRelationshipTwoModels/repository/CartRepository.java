package br.twoModels.projectRelationshipTwoModels.repository;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends PagingAndSortingRepository<Cart, Integer> {
}
