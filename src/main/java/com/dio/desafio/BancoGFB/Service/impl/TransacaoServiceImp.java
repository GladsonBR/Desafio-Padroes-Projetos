package com.dio.desafio.BancoGFB.Service.impl;

import com.dio.desafio.BancoGFB.Model.Cliente;
import com.dio.desafio.BancoGFB.Model.Conta;
import com.dio.desafio.BancoGFB.Model.Extrato;
import com.dio.desafio.BancoGFB.Repository.ContaRepository;
import com.dio.desafio.BancoGFB.Repository.ExtratoRepository;
import com.dio.desafio.BancoGFB.Service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Optional;

public class TransacaoServiceImp implements TransacaoService {

    private ContaRepository contaRepository;

    private ExtratoRepository extratoRepository;

    private Extrato extrato;

    private Conta conta;

    private Date DateTimeAtCreation;


    @Override
    public void saque(int numConta, Conta conta) {
        Optional<Conta> contas = contaRepository.findById(numConta);
        double valor = 50.00;
        double saldo = contas.get().getSaldo();
        conta.setSaldo(saldo-=valor);

        Extrato extrato = new Extrato();

        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
        date.getTime();

        extrato.setNumContaEx(numConta);
        extrato.setTipoTransacaoEx("Saque");
        extrato.setValorTransac(-valor);
        extrato.setDataTransac(data.format(date.getTime()));

        extratoRepository.save(extrato);
        contaRepository.save(conta);
    }

    @Override
    public void deposito(int numConta, Conta conta) {
        Optional<Conta> contad = contaRepository.findById(numConta);
        double saldo = contad.get().getSaldo();
        double valor = 100.00;
        conta.setSaldo(saldo+=valor);

        Extrato extrato = new Extrato();
        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
        date.getTime();

        extrato.setNumContaEx(numConta);
        extrato.setTipoTransacaoEx("Depósito");
        extrato.setValorTransac(valor);
        extrato.setDataTransac(data.format(date.getTime()));

        extratoRepository.save(extrato);
        contaRepository.save(conta);

    }

    @Override
    public void Transferencia(int contaO, int contaD, Conta conta) {
        Optional<Conta> contaOr = contaRepository.findById(contaO);
        double saldo = contaOr.get().getSaldo();
        Optional<Conta> contad = contaRepository.findById(contaD);
        double saldoD = contad.get().getSaldo();
        double valor = 50.00;
        saldo -= valor;
        saldoD += valor;

        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
        date.getTime();

        extrato.setNumContaEx(contaO);
        extrato.setTipoTransacaoEx("Transferência");
        extrato.setValorTransac(-valor);
        extrato.setDataTransac(data.format(date.getTime()));

        contaOr.get().setSaldo(saldo);
        contad.get().setSaldo(saldoD);

        extratoRepository.save(extrato);
        contaRepository.save(conta);
    }

    @Override
    public Extrato buscarPorId(Long numConta){
        try{
            Optional<Extrato> extrato = extratoRepository.findById(Long.valueOf(numConta));
            return extrato.get();
        }catch (Exception e) {
            System.out.println("Nenhuma transação encontrada");
            return null;
        }
    }
}
