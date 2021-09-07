package com.bnz.shoppingcart.service;

import com.bnz.shoppingcart.exception.CartNotFoundException;
import com.bnz.shoppingcart.model.Cart;
import com.bnz.shoppingcart.model.Item;
import com.bnz.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart addItem(Long id, Item item) {
        Optional<Cart> savedCart = cartRepository.findById(id);
        Cart cart;
        if (savedCart.equals(Optional.empty())) {
            cart = new Cart(id);
        }
        else {
            cart = savedCart.get();
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    public Cart findById(Long id) throws CartNotFoundException {
        return verifyIfExists(id);
    }

    public void clear(Long id) {
        cartRepository.deleteById(id);
    }

    private Cart verifyIfExists(Long id) throws CartNotFoundException {
        return cartRepository.findById(id)
                .orElseThrow(() -> new CartNotFoundException(id));

    }

}
