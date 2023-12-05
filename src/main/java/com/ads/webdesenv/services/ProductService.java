package com.ads.webdesenv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.webdesenv.repository.ProductRepository;
import com.webdesenv.domain.Product;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product salvarProduto(Product produto) {
        return productRepository.save(produto);
    }

    public List<Product> listarProdutos() {
        return productRepository.findAll();
    }

    public Optional<Product> encontrarProdutoPorId(Long id) {
        return productRepository.findById(id);
    }

    public void deletarProduto(Long id) {
    	productRepository.deleteById(id);
    }
}