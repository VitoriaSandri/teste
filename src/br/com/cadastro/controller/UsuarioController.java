package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.UsuarioDAO;
import br.com.cadastro.model.Usuario;

@Controller
public class UsuarioController {
	
    @Autowired
    UsuarioDAO daoUsuario;
    
	@RequestMapping("listaUsuarios")
    public String lista(Model modelUsuario) throws ClassNotFoundException {
        modelUsuario.addAttribute("usuarios", daoUsuario.lista());
        return "usuario/lista";
    }

	@RequestMapping("novoUsuario")
	public String form() {
		return "usuario/insere";
	}
	
	@RequestMapping("adicionaUsuario")
	public String adiciona(@Valid Usuario usuario, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("nome") || result.hasFieldErrors("login") || result.hasFieldErrors("senha") || result.hasFieldErrors("dataNascimento") || result.hasFieldErrors("altura")) {
			 return "usuario/insere";
	     }
		daoUsuario.adiciona(usuario);
		return "redirect:listaUsuarios";
	}
	
	@RequestMapping("editaUsuario")
    public String edita(Long id, Model modelUsuario) throws ClassNotFoundException {
        modelUsuario.addAttribute("usuario", daoUsuario.buscaPorId(id));
        return "usuario/edita";
    }
	
	@RequestMapping("alteraUsuario")
	public String altera(@Valid Usuario usuario, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("nome") || result.hasFieldErrors("login") || result.hasFieldErrors("senha") || result.hasFieldErrors("dataNascimento") || result.hasFieldErrors("altura")) {
			 return "usuario/edita";
	     }
		daoUsuario.altera(usuario);
        return "redirect:listaUsuarios";
    }
	
    @RequestMapping("removeUsuario")
    public String remove(Usuario usuario) throws ClassNotFoundException {
    	daoUsuario.remove(usuario);
        return "redirect:listaUsuarios";
    }
    
}