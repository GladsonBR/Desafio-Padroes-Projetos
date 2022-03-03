package com.dio.desafio.BancoGFB.Model;

import javax.persistence.*;

@Entity
@Table(name = "Extrato")
public class Extrato {
    @Id
    int numContaEx;
    Long idExtrato;
    String tipoTransacaoEx;
    double valorTransac;
    String dataTransac;

    @Override
    public String toString() {
        return "Extrato{" +
                "idExtrato=" + idExtrato +
                ", numContaEx=" + numContaEx +
                ", tipoTransacaoEx='" + tipoTransacaoEx + '\'' +
                ", valorTransac=" + valorTransac +
                ", dataTransac=" + dataTransac +
                '}';
    }


    public Long getIdExtrato() {
        return idExtrato;
    }

    public void setIdExtrato(Long idExtrato) {
        this.idExtrato = idExtrato;
    }

    public int getNumContaEx() {
        return numContaEx;
    }

    public void setNumContaEx(int numContaEx) {
        this.numContaEx = numContaEx;
    }

    public String getTipoTransacaoEx() {
        return tipoTransacaoEx;
    }

    public void setTipoTransacaoEx(String tipoTransacaoEx) {
        this.tipoTransacaoEx = tipoTransacaoEx;
    }

    public double getValorTransac() {
        return valorTransac;
    }

    public void setValorTransac(double valorTransac) {
        this.valorTransac = valorTransac;
    }

    public String getDataTransac() {
        return dataTransac;
    }

    public void setDataTransac(String dataTransac) {
        this.dataTransac = dataTransac;
    }




}
