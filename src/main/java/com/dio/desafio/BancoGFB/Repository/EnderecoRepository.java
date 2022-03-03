package com.dio.desafio.BancoGFB.Repository;

import com.dio.desafio.BancoGFB.Model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
