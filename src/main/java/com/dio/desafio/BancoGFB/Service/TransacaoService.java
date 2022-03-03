package com.dio.desafio.BancoGFB.Service;

import com.dio.desafio.BancoGFB.Model.Conta;
import com.dio.desafio.BancoGFB.Model.Extrato;



public interface TransacaoService {
    void saque(int numConta, Conta conta) ;

    void deposito(int numConta, Conta conta);

    void Transferencia(int contaO, int contaD, Conta conta );

   Extrato buscarPorId(Long numConta);
}
