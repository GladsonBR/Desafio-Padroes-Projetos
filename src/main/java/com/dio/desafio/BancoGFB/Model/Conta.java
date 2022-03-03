package com.dio.desafio.BancoGFB.Model;
import javax.persistence.*;

@Entity
@Table(name = "Contas")
public class Conta {

    @Id
    String nomeCliente;

    @Column(name = "agConta")
    int agencia;

    @Column(name = "numeroConta")
    Integer conta;
    String tipoConta;

    @Column(name = "saldoConta")
    double saldo;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public String toString() {
        return "Conta{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", conta=" + conta +
                ", agencia=" + agencia +
                ", tipoConta='" + tipoConta + '\'' +
                ", saldo=" + saldo +
                '}';
    }



}
