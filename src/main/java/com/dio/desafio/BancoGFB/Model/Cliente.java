package com.dio.desafio.BancoGFB.Model;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

   @Id
   private Long idCliente;
   private String nomeCliente;
   private int telCliente;
   private String cep;
   @ManyToOne
   private Endereco endereco;
   @OneToOne
   private Conta conta;

   public int getNumConta() {
      return numConta;
   }

   public void setNumConta(int numConta) {
      this.numConta = numConta;
   }

   private int numConta;



   public Endereco getEndereco() {
      return endereco;
   }

   public void setEndereco(Endereco endereco) {
      this.endereco = endereco;
   }

   public Conta getConta() {
      return conta;
   }

   public void setConta(Conta conta) {
      this.conta = conta;
   }

   public Long getIdCliente() {
      return idCliente;
   }

   public void setIdCliente(Long idCliente) {
      this.idCliente = idCliente;
   }

   public String getNomeCliente() {
      return nomeCliente;
   }

   public void setNomeCliente(String nomeCliente) {
      this.nomeCliente = nomeCliente;
   }

   public int getTelCliente() {
      return telCliente;
   }

   public void setTelCliente(int telCliente) {
      this.telCliente = telCliente;
   }

   public String getCep() {
      return cep;
   }

   public void setCep(String cep) {
      this.cep = cep;
   }

 }
