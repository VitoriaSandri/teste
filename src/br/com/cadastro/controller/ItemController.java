package br.com.cadastro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cadastro.dao.ItemDAO;
import br.com.cadastro.model.Item;

@Controller
public class ItemController {

	@Autowired
	ItemDAO daoItem;
	
	@RequestMapping("listaItem")
	public String lista(Model modelItem)throws ClassNotFoundException{
		modelItem.addAttribute("item", daoItem.lista());
		return "item/lista";
	}
	
	@RequestMapping("novoItem")
	public String form() {
		return "item/insere";
	}
	
	@RequestMapping("adicionaItem")
	public String adiciona(@Valid Item item, BindingResult result) throws ClassNotFoundException {
		if(result.hasFieldErrors("id") || result.hasFieldErrors("nomeItem")) {
			return "item/insere";
		}
		daoItem.adiciona(item);
		return "redirect:listaItem";
	}
	
	@RequestMapping("editaItem")
	public String edita(Long id, Model modelItem) throws ClassNotFoundException{
		modelItem.addAttribute("item", daoItem.buscaPorId(id));
		return "item/edita";
	}
	
	@RequestMapping("alterarItem")
	public String alterar(@Valid Item item, BindingResult result) throws ClassNotFoundException{
		if(result.hasFieldErrors("id") || result.hasFieldErrors("nomeItem")) {
			return "item/edita";
		}
		daoItem.altera(item);
		return "redirect:listaItem";
	}
	
	@RequestMapping("removeItem")
	public String remove(Item item) throws ClassNotFoundException{
		daoItem.remove(item);
		return "redirect:listaItem";
	}
}
