package br.com.cadastro.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.LoginDAO;
import br.com.cadastro.model.Usuario;

@Controller
public class LoginController{

    @RequestMapping("loginForm") //envia para a mesma pagina
    public String loginForm() {
        return "login/login";
    }
   
    @RequestMapping("efetuaLogin") //autentica e loga
    public String efetuaLogin(Usuario usuario, HttpSession session) throws ClassNotFoundException {
        if(new LoginDAO().existeUsuario(usuario)) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:listaPrincipal";
        }
        return "redirect:loginForm";
    }
    
    @RequestMapping("logout") //desloga
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:loginForm";
    }
    
}