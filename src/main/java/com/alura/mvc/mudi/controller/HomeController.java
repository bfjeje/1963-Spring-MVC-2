package com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.StatusPedido;
import com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping
	public String home(Model model, Principal principal) {
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGADO);
		model.addAttribute("pedidos",pedidos);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
