package com.dio.desafio.BancoGFB.Service.impl;


import com.dio.desafio.BancoGFB.Model.Cliente;
import com.dio.desafio.BancoGFB.Model.Endereco;
import com.dio.desafio.BancoGFB.Repository.ClienteRepository;
import com.dio.desafio.BancoGFB.Repository.EnderecoRepository;
import com.dio.desafio.BancoGFB.Service.ClienteService;
import com.dio.desafio.BancoGFB.Service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
            Optional<Cliente> cliente = clienteRepository.findById(id);
            return cliente.get();

    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }


    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBD = clienteRepository.findById(id);
        if (clienteBD.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }


    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);

    }
}
