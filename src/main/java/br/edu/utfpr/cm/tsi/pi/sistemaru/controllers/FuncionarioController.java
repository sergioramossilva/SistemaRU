package br.edu.utfpr.cm.tsi.pi.sistemaru.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/administracao/funcionarios")
public class FuncionarioController {

	
	@RequestMapping("/novo")
	public void novo() {
	System.out.println("PASSOU AQUI!!!");	
	}
/*    private final FuncionarioDao fdao;
    private final CargoDao cdao;

    public FuncionarioController() {
        fdao = new FuncionarioDao();
        cdao = new CargoDao();
    }
    
    @RequestMapping("incluirFuncionario")
    public String incluir(Model model) {
        List<Cargo> cargos = cdao.getAll();
        model.addAttribute("listaCargos", cargos);
        return "cadastros/formFuncionario";
    }

    @RequestMapping("salvarFuncionario")
    public String salvar(Funcionario funcionario, @RequestParam("idCargo") Long idCargo) {
        Cargo cargo = cdao.findById(idCargo);
        funcionario.setCargo(cargo);
        fdao.save(funcionario);
        return "forward:listarFuncionarios";
    }

    @RequestMapping("excluirFuncionario")
    public String excluir(Funcionario funcionario) {
        fdao.delete(funcionario);
        return "forward:listarFuncionarios";
    }

    @RequestMapping("alterarFuncionario")
    public String alterar(Long id, Model model) {
        List<Cargo> cargos = cdao.getAll();
        model.addAttribute("funcionario", fdao.findById(id)); 
        model.addAttribute("listaCargos", cargos);
        return "cadastros/formFuncionario";
    }

    @RequestMapping("listarFuncionarios")
    public String lista(Model model) {
        List<Funcionario> funcionarios = fdao.getAll();
        model.addAttribute("funcionarios", funcionarios);
        return "listas/listaFuncionarios";
    }
*/
}