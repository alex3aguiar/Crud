package br.com.alura.listavip;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.listavip.model.Cliente;
import br.com.alura.listavip.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService service;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaclientes")
	public String listaConvidados(Model model) {
		Iterable<Cliente> clientes = service.obterTodos();
		model.addAttribute("clientes", clientes);

		return "listaclientes";
	}

	@RequestMapping(value = "pesquisa", method = RequestMethod.GET)
	public String lista(@RequestParam("filtro") String filtro, Model model) {
		Iterable<Cliente> clientes = null;

		if ("".equals(filtro.trim())) {
			clientes = service.obterTodos();
		} else {
			clientes = service.pesquisarPorNome(filtro);
		}

		model.addAttribute("clientes", clientes);
		return "listaclientes";

	}

	@RequestMapping(value = "deletar", method = RequestMethod.POST)
	public String deletar(@RequestParam("filtro") String filtro, Model model) {
		service.deletar(filtro);
		Iterable<Cliente> clientes = service.obterTodos();
		model.addAttribute("clientes", clientes);

		return "listaclientes";

	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("saldo") BigDecimal saldo, Model model) {

		if ("".equals(nome.trim())) {
			return "erroform";

		}
		if ("".equals(email.trim())) {
			return "erroform";
		}
		if (saldo == null) {
			return "erroform";
		}
		Cliente novoClinente = new Cliente(nome, email, saldo, true);
		service.salvar(novoClinente);
		Iterable<Cliente> clientes = service.obterTodos();
		model.addAttribute("clientes", clientes);

		return "listaclientes";

	}
	
	
	@RequestMapping("recriar")
	public String recriar(Model model) {
		service.recriar();
		
		Iterable<Cliente> clientes = service.obterTodos();
		model.addAttribute("clientes", clientes);

		return "listaclientes";
	}
}
