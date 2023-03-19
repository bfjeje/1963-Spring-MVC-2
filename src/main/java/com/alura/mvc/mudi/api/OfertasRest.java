package com.alura.mvc.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.mvc.mudi.dto.RequestNuevaOferta;
import com.alura.mvc.mudi.model.Oferta;
import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.repository.PedidoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	private Oferta creaOferta(@Valid @RequestBody RequestNuevaOferta request) {
		
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(request.getPedidoId());
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		Oferta nuevaOferta = request.toOferta();
		nuevaOferta.setPedido(pedido);
		pedido.getOfertas().add(nuevaOferta);
		pedidoRepository.save(pedido);
		
		return nuevaOferta;
	}
}
