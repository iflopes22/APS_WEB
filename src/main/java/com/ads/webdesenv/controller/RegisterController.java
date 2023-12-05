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

import com.ads.webdesenv.services.CartService;
import com.ads.webdesenv.services.RegisterService;
import com.webdesenv.domain.Cart;
import com.webdesenv.domain.Product;
import com.webdesenv.domain.Register;

public class RegisterController {
	private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Register> criarProduto(@RequestBody Register register) {
        Register novoRegistro = registerService.salvarRegistro(register);
        return new ResponseEntity<>(register, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<cart>> listarCarrinho(Long id) {
//        List<cart> cart = cartService.listarCarrinhoPorId(id);
//        return new ResponseEntity<>(cart, HttpStatus.OK);
//    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Register> encontrarProdutoPorId(@PathVariable Integer id) {
        return registerService.encontrarRegistroPorId(id.longValue())
                .map(produto -> new ResponseEntity<>(produto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> atualizarProduto(@PathVariable Integer id, @RequestBody Register cartAtualziado) {
        Register register = registerService.salvarRegistro(cartAtualziado);
		return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
    	registerService.deletarRegistro(id.longValue());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
