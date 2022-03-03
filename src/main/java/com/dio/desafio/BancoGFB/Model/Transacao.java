package com.dio.desafio.BancoGFB.Model;


import com.dio.desafio.BancoGFB.Model.Conta;
import com.dio.desafio.BancoGFB.Model.Extrato;
import com.dio.desafio.BancoGFB.Repository.ContaRepository;
import com.dio.desafio.BancoGFB.Repository.ExtratoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.util.*;


public class Transacao {
    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private ExtratoRepository extratoRepository;
    @Autowired
    private Extrato extrato;
    @Autowired
    private Conta conta;

    private Date DateTimeAtCreation;

    public void saque(double valor, int numeroConta) {
        Optional<Conta> contas = contaRepository.findById(numeroConta);
        double saldo = contas.get().getSaldo();
        conta.setSaldo(saldo-=valor);

        Extrato extrato = new Extrato();

        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
        date.getTime();

        extrato.setNumContaEx(numeroConta);
        extrato.setTipoTransacaoEx("Saque");
        extrato.setValorTransac(-valor);
        extrato.setDataTransac(data.format(date.getTime()));

        extratoRepository.save(extrato);
        contaRepository.save(conta);
    }


    public void deposito(double valor, int numeroConta) {
        Optional<Conta> contad = contaRepository.findById(numeroConta);
        double saldo = contad.get().getSaldo();
        conta.setSaldo(saldo+=valor);

        Extrato extrato = new Extrato();
        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
        date.getTime();

        extrato.setNumContaEx(numeroConta);
        extrato.setTipoTransacaoEx("Depósito");
        extrato.setValorTransac(valor);
        extrato.setDataTransac(data.format(date.getTime()));

        extratoRepository.save(extrato);
        contaRepository.save(conta);
    }

    public void Transferencia(double valor, int contaO, int contaD ) {
        Optional<Conta> contaOr = contaRepository.findById(contaO);
        double saldo = contaOr.get().getSaldo();
        Optional<Conta> contad = contaRepository.findById(contaD);
        double saldoD = contad.get().getSaldo();
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

    public void saldo(int numeroConta){
        Optional<Conta> conta = contaRepository.findById(numeroConta);
        System.out.println(conta.get().getSaldo());
    }


/* public void extrato(EntityManager entityManager,int numeroConta){
        String jpql = "select ext from Extrato ext where ext.numContaEx = :contaUsuario";
        TypedQuery<Extrato> typedQuery = entityManager.createQuery(jpql, Extrato.class);
        typedQuery.setParameter("contaUsuario", numeroConta);
        List<Extrato> lista = typedQuery.getResultList();
        lista.forEach(ext -> System.out.println("===="+ ext.getIdExtrato() + " ==== " + ext.getNumContaEx()+" ==== "+ ext.getValorTransac()+" ==== "+ ext.getTipoTransacaoEx()+" ==== "+ext.getDataTransac()));
    }*/


}
