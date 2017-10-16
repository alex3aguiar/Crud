package br.com.alura.listavip.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private String email;

	private BigDecimal saldo;

	private Boolean ativo;

	public Cliente() {
	}

	public Cliente(String nome, String email, BigDecimal saldo, Boolean ativo) {
		super();
		this.nome = nome;
		this.email = email;
		this.saldo = saldo;
		this.ativo = ativo;
	}

	Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
}
