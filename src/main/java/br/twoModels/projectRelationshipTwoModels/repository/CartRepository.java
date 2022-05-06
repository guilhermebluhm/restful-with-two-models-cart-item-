package br.twoModels.projectRelationshipTwoModels.repository;

import br.twoModels.projectRelationshipTwoModels.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
