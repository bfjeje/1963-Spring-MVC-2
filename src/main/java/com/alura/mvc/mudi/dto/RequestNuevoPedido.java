package com.alura.mvc.mudi.dto;

import javax.validation.constraints.NotBlank;

import com.alura.mvc.mudi.model.Pedido;
import com.alura.mvc.mudi.model.StatusPedido;

public class RequestNuevoPedido {
	
	@NotBlank()
	private String nombreProducto;
	
	@NotBlank
	private String urlProducto;
	
	@NotBlank
	private String urlImagen;
	private String descripcion;
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getUrlProducto() {
		return urlProducto;
	}
	public void setUrlProducto(String urlProducto) {
		this.urlProducto = urlProducto;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Pedido toPedido() {
		
		Pedido pedido = new Pedido();
		pedido.setNombreDelProducto(nombreProducto);
		pedido.setDescripcion(descripcion);
		pedido.setUrlProducto(urlProducto);
		pedido.setUrlImagen(urlImagen);
		pedido.setStatus(StatusPedido.ESPERANDO);
		
		return pedido;
	}
}
