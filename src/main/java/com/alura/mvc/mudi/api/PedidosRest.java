package com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.StatusPedido;
import com.alura.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("esperando")
	public List<Pedido> getPedidosEsperandoOfertas(){
		
		Sort sort = Sort.by("id").descending();
		PageRequest paginacion = PageRequest.of(0, 10, sort);
		
		return pedidoRepository.findByStatus(StatusPedido.ESPERANDO, paginacion);
	}

}
