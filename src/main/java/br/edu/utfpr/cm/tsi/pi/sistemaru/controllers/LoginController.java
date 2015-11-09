package br.edu.utfpr.cm.tsi.pi.sistemaru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.tsi.pi.sistemaru.models.Funcionario;
import br.edu.utfpr.cm.tsi.pi.sistemaru.services.FuncionarioService;

@Controller
public class LoginController {

	@Autowired
	FuncionarioService funcionarioService;

	@RequestMapping("/efetuarLogin")
	public String efetuarLogin(Funcionario funcionario) {

		Funcionario funcionarioLogado = funcionarioService.autenticar(funcionario.getLogin(), funcionario.getSenha());

		if (funcionarioLogado != null) {
			return "loginInvalido";
		} else {
			return "loginInvalido";
		}
	}
	
	@RequestMapping("/efetuarLogout")
	public String logout() {
		return null;
	}
}