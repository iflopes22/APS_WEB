package com.ads.webdesenv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ads.webdesenv.services.CartService;
import com.webdesenv.domain.Cart;
import com.webdesenv.domain.Product;

@RestController
@RequestMapping("/cart")
public class CartController {
	private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/save")
    public ResponseEntity<Cart> criarProduto(@RequestBody Cart cart) {
        Cart novoCarrinho = cartService.salvarCart(cart);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<cart>> listarCarrinho(Long id) {
//        List<cart> cart = cartService.listarCarrinhoPorId(id);
//        return new ResponseEntity<>(cart, HttpStatus.OK);
//    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Cart> encontrarProdutoPorId(@PathVariable Integer id) {
        return cartService.encontrarCarrinhoPorId(id.longValue())
                .map(produto -> new ResponseEntity<>(produto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> atualizarProduto(@PathVariable Integer id, @RequestBody Cart cartAtualziado) {
        Cart crt = cartService.salvarCart(cartAtualziado);
		return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
    	cartService.deletarCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

