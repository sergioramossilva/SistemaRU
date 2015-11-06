package br.edu.utfpr.cm.tsi.pi.sistemaru.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.utfpr.cm.tsi.pi.sistemaru.daos.FuncionarioDao;
import br.edu.utfpr.cm.tsi.pi.sistemaru.model.Funcionario;

@Controller
public class LoginController {
	
	@Autowired
	FuncionarioDao fdao;

	@RequestMapping("/efetuarLogin")
	public String efetuarLogin(Funcionario funcionario, HttpSession session) {

		Funcionario fun = fdao.getAutenticao(funcionario.getLogin(),
				funcionario.getSenha());

		if (fun != null) {

			session.setAttribute("func", fun);
			return "bemVindo";
		}
		return "loginInvalido";
	}
}