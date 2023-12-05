package com.ads.webdesenv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ads.webdesenv.repository.RegisterRepository;
import com.webdesenv.domain.Register;

@Service
public class RegisterService {
	private final RegisterRepository registerRepository;

    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public Register salvarRegistro(Register register) {
        return registerRepository.save(register);
    }

    public List<Register> listarRegistro() {
        return registerRepository.findAll();
    }

    public Optional<Register> encontrarRegistroPorId(Long id) {
        return registerRepository.findById(id);
    }

    public void deletarRegistro(Long id) {
    	registerRepository.deleteById(id);
    }
}