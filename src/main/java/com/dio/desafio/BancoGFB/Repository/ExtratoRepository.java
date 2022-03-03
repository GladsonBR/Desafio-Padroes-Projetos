package com.dio.desafio.BancoGFB.Repository;

import com.dio.desafio.BancoGFB.Model.Extrato;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ExtratoRepository extends CrudRepository<Extrato, Long> {

}
