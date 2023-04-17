package com.example.demo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.dto.CategoriaDTO;
import com.example.demo.model.dto.ProductoDTO;
import com.example.demo.services.CategoriaService;
import com.example.demo.services.ProductoService;
import com.example.demo.services.UsuarioService;

@Controller
public class PagArticulosController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private ProductoService ps;
	
	@Autowired
	private CategoriaService cs;
	
	@GetMapping("/tienda")
	public ModelAndView inicioTienda() {

		log.info("PagArticulosController - PagArticulosController: Pasamos a la página con todos los artículos");
		
		List<ProductoDTO> lpDTO = ps.findAll();
		List<CategoriaDTO> lcDTO = cs.findAll();

		ModelAndView mav = new ModelAndView("clientes/tienda");
		mav.addObject("listaProductosDTO", lpDTO);
		mav.addObject("listaCategoriasDTO", lcDTO);

		return mav;
	}
}
