package com.dio.desafio.BancoGFB.Controller;

import com.dio.desafio.BancoGFB.Model.Cliente;
import com.dio.desafio.BancoGFB.Model.Conta;
import com.dio.desafio.BancoGFB.Model.Extrato;
import com.dio.desafio.BancoGFB.Repository.ContaRepository;
import com.dio.desafio.BancoGFB.Repository.ExtratoRepository;
import com.dio.desafio.BancoGFB.Service.ClienteService;
import com.dio.desafio.BancoGFB.Service.TransacaoService;
import com.dio.desafio.BancoGFB.Service.impl.TransacaoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    private TransacaoService transacaoService;

    private ContaRepository contaRepository;

    private ExtratoRepository extratoRepository;

    private Conta conta;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {return ResponseEntity.ok(clienteService.buscarTodos());}

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }


    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/saque/{numConta}")

    public ResponseEntity<Conta> GetBynumConta(@PathVariable(value = "numConta") int numConta)
    {
        Optional<Conta> conta = contaRepository.findById(numConta);
        if(conta.isPresent()) {
            transacaoService.saque(numConta, conta.get());
            return new ResponseEntity<Conta>(conta.get(), HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/deposito/{numConta}")
    public ResponseEntity<Conta> GetByInumConta(@PathVariable(value = "numConta") int numConta)
    {
        Optional<Conta> conta = contaRepository.findById(numConta);
        if(conta.isPresent()) {
            transacaoService.deposito(numConta, conta.get());
            return new ResponseEntity<Conta>(conta.get(), HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/extrato/{numConta}")
    public ResponseEntity<Extrato> GetByInumCont(@PathVariable(value = "numConta") Long numContaE)
    {
        Optional<Extrato> extrato = extratoRepository.findById(numContaE);
        if(extrato.isPresent()) {
            transacaoService.buscarPorId(numContaE);
            return new ResponseEntity<Extrato>(extrato.get(), HttpStatus.OK);
        }else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
