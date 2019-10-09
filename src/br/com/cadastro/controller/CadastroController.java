package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.CadastroDAO;
import br.com.cadastro.model.Cadastro;

@Controller
public class CadastroController {
	
	@Autowired
    CadastroDAO daoCadastro;
	
	@RequestMapping("listaCadastro")
	public String lista(Model modelCadastro) throws ClassNotFoundException{
		modelCadastro.addAttribute("cadastro", daoCadastro.lista());
		return "cadastro/lista";
	}
	
	@RequestMapping("novoCadastro")
	public String form() {
		return "cadastro/insere";
	}
	
	@RequestMapping("adicionaCadastro")
	public String adiciona(@Valid Cadastro cadastro, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("nome") || result.hasFieldErrors("sexo") || result.hasFieldErrors("descricao") || result.hasFieldErrors("idCadastroUsuario")) {
			return "cadastro/insere";
		}
		daoCadastro.adiciona(cadastro);
		return "redirect:listaCadastro";
	}
	
	@RequestMapping("editaCadastro")
	public String edita(Long id, Model modelCadastro) throws ClassNotFoundException{
		modelCadastro.addAttribute("cadastro", daoCadastro.buscaPorId(id));
		return "cadastro/edita";
	}
	
	@RequestMapping("alterarCadastro")
	public String alterar(@Valid Cadastro cadastro, BindingResult result) throws ClassNotFoundException{
		if(result.hasFieldErrors("nome") || result.hasFieldErrors("sexo") || result.hasFieldErrors("descricao") || result.hasFieldErrors("idCadastroUsuario")) {
			return "cadastro/edita";
		}
		daoCadastro.altera(cadastro);
		return "redirect:listaCadastro";
	}
	
	@RequestMapping("removeCadastro")
	public String remove(Cadastro cadastro) throws ClassNotFoundException{
		daoCadastro.remove(cadastro);
		return "redirect:listaCadastro";
	}
}
