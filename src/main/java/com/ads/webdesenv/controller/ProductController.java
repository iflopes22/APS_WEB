package com.ads.webdesenv.controller;

import java.util.List;

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

import com.ads.webdesenv.services.ProductService;
import com.webdesenv.domain.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<Product> criarProduto(@RequestBody Product produto) {
        Product novoProduto = productService.salvarProduto(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> listarProdutos() {
        List<Product> produtos = productService.listarProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Product> encontrarProdutoPorId(@PathVariable Long id) {
        return productService.encontrarProdutoPorId(id)
                .map(produto -> new ResponseEntity<>(produto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> atualizarProduto(@PathVariable Long id, @RequestBody Product produtoAtualizado) {
        Product prd = productService.salvarProduto(produtoAtualizado);
		return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
    	productService.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

