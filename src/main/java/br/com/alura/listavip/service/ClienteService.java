package br.com.alura.listavip.service;

import java.io.IOException;
import java.util.List;

import org.omg.CORBA.portable.InputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import br.com.alura.listavip.model.Cliente;
import br.com.alura.listavip.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Iterable<Cliente> obterTodos() {
		System.out.println("obtendo todos");
		Iterable<Cliente> clientes = repository.findAll();
		return clientes;
	}

	public Iterable<Cliente> pesquisarPorNome(String filtro) {
		Iterable<Cliente> clientes = repository.findByname(filtro);
		System.out.println("pesquisando");
		return clientes;
	}

	public void salvar(Cliente cliente) {
	
		repository.save(cliente);
	}

	public void deletar(String filtro) {
		Iterable<Cliente> clientes = repository.findByname(filtro);
		repository.delete(clientes);
		
	}

	public void recriar() {
		
		

	}
}
