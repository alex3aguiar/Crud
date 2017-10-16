package br.com.alura.listavip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.listavip.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	 @Query(value = "SELECT * FROM cliente WHERE nome LIKE ?1% ", nativeQuery = true)
	 List<Cliente> findByname(String nome);

	

	 
}



