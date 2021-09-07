package com.bnz.shoppingcart.repository;

import com.bnz.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {

    Cart findByCustomerId(Integer customerId);

}
