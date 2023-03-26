package com.alura.mvc.mudi.interceptor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InterceptadorDeAccesos implements HandlerInterceptor{
	
	public static List<Acceso> accesos = new ArrayList<Acceso>();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Acceso acceso = new Acceso();
		acceso.setPath(request.getRequestURI());
		acceso.setFecha(LocalDateTime.now());
		request.setAttribute("acceso", acceso);
		return true;
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Acceso acceso = (Acceso) request.getAttribute("acceso");
		acceso.setDuracion(Duration.between(acceso.getFecha(), LocalDateTime.now()));
		accesos.add(acceso);
	}
	
	
	public class Acceso{
		private String path;
		private LocalDateTime fecha;
		private Duration duracion;
		
		public String getPath() {
			return path;
		}
		public void setPath(String path) {
			this.path = path;
		}
		public LocalDateTime getFecha() {
			return fecha;
		}
		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}
		public Duration getDuracion() {
			return duracion;
		}
		public void setDuracion(Duration duracion) {
			this.duracion = duracion;
		}
	}
}
