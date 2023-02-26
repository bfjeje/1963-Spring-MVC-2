package com.alura.mvc.mudi.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alura.mvc.mudi.dto.RequestNuevoPedido;
import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.User;
import com.alura.mvc.mudi.repository.PedidoRepository;
import com.alura.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	public String formulario(RequestNuevoPedido request) {
		return "pedido/formulario";
	}
	
	@PostMapping("nuevo")
	public String nuevo(@Valid RequestNuevoPedido request, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Pedido pedido = request.toPedido();
		User user = userRepository.findUserByUsername(username);
		pedido.setUser(user);
		
		pedidoRepository.save(pedido);
		
		return "redirect:/home";
	}
}
