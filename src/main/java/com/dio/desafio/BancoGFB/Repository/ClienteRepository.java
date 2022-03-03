package com.dio.desafio.BancoGFB.Repository;

import com.dio.desafio.BancoGFB.Model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
