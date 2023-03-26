package com.alura.mvc.mudi.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.mvc.mudi.interceptor.InterceptadorDeAccesos;
import com.alura.mvc.mudi.interceptor.InterceptadorDeAccesos.Acceso;

@RequestMapping("/api/accesos")
@RestController
public class AccesosRest {

	@GetMapping
	public List<Acceso> getAccesos(){
		return InterceptadorDeAccesos.accesos;
	}
}
