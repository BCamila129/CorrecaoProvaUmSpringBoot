package com.example.CorrecaoProvaUmSpringBoot.controller;

import com.example.CorrecaoProvaUmSpringBoot.entity.Cliente;
import com.example.CorrecaoProvaUmSpringBoot.repository.ClienteRepository;
import com.example.CorrecaoProvaUmSpringBoot.utils.Calculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente/v1")

public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private Calculo calcs;


    @PostMapping
    @ResponseBody
    public Cliente create(@RequestBody Cliente cliente) {
        Cliente clienteSocialializado = calcs.calc(cliente);
        Cliente clienteSaved = clienteRepository.save(cliente);
        return clienteSaved;
    }
    @GetMapping("{id}")
    @ResponseBody
    public Optional<Cliente> getClienteById(@PathVariable Long id) {
      Optional<Cliente> clienteReturned = clienteRepository.findById(id);
        return clienteReturned;
    }
    @GetMapping
    public List<Cliente> getAllCliente(){
        return clienteRepository.findAll();
    }
    @DeleteMapping
    public String deleteClienteById(@PathVariable Long id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if(clienteOptional.isPresent()){
            clienteRepository.deleteById(id);
            return "Cliente de id " + id + "foi deletado com sucesso0";
        }else{
            return "Cliente inexistente!";
        }
    }
    @PutMapping("update/{id}")
    public String updateClienteById(@PathVariable Long id, String novoNome){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()){
            Cliente c = clienteOptional.get();
            clienteRepository.save(c);
            return "Cliente de id " + id + "salvo com sucesso!";
        }else {
            return "Cliente inexistente";
        }
    }
}




