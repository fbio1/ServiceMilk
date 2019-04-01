package com.pa2.milk.api.repository;

import org.springframework.stereotype.Repository;

import com.pa2.milk.api.model.Cliente;

@Repository
public interface ClienteRepository extends GenericRepository<Cliente, Integer> {

	Cliente findByCpf(String cpf);

	Cliente findByEmail(String email);

	Cliente findByCpfOrEmail(String cpf, String email);

}