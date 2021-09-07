package com.bnz.shoppingcart.controller;

import com.bnz.shoppingcart.exception.CartNotFoundException;
import com.bnz.shoppingcart.model.Cart;
import com.bnz.shoppingcart.model.Item;
import com.bnz.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Cart addItem(@PathVariable("id") Long id, @RequestBody Item item) {
        return cartService.addItem(id, item);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cart findById(@PathVariable("id") Long id) throws CartNotFoundException {
        return cartService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void clear(@PathVariable("id") Long id) {
        cartService.clear(id);
    }

}
