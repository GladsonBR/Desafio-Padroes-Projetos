package com.dio.desafio.BancoGFB.Repository;

import com.dio.desafio.BancoGFB.Model.Conta;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

}
