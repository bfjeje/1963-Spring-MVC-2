package com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreDelProducto;
	private BigDecimal valorNegociado;
	private LocalDate fechaDeEntrega;
	private String urlProducto;
	private String descripcion;
	private String urlImagen;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;
	
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public String getNombreDelProducto() {
		return nombreDelProducto;
	}
	public void setNombreDelProducto(String nombreDelProducto) {
		this.nombreDelProducto = nombreDelProducto;
	}
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public LocalDate getFechaDeEntrega() {
		return fechaDeEntrega;
	}
	public void setFechaDeEntrega(LocalDate fechaDeEntrega) {
		this.fechaDeEntrega = fechaDeEntrega;
	}
	public String getUrlProducto() {
		return urlProducto;
	}
	public void setUrlProducto(String urlProducto) {
		this.urlProducto = urlProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	
	
}
