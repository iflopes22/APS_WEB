package com.ads.webdesenv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.webdesenv.repository.CartRepository;
import com.webdesenv.domain.Cart;
import com.webdesenv.domain.Product;

@Service
public class CartService {
	
    private CartRepository cartRepository;

	public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart salvarCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> listarCarrinho() {
        return cartRepository.findAll();
    }
    
//    public List<cart> listarCarrinhoPorId(Long id) {
//        return cartRepository.findAllById(id);
//    }

    public Optional<Cart> encontrarCarrinhoPorId(Long id) {
        return cartRepository.findById(id.intValue());
    }

    public void deletarCart(Integer id) {
    	cartRepository.deleteById(id);
    }
    
    public void adicionarAoCarrinho(Product product) {
    	Cart ct = new Cart();
    	ct.setName(product.getName());
    	ct.setPrice(product.getPrice());
    	ct.setQtde(1);
    	cartRepository.save(ct);
    }
    

}