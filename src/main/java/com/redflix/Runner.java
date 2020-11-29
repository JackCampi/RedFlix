package com.redflix;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.repos.DirectorRepositorio;
import com.repos.UsuarioRepositorio;
import com.tablas.Director;
import com.tablas.Serie;
import com.tablas.Usuario;

@Component
public class Runner implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(Runner.class);
	
	@Autowired
	private UsuarioRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario us = new Usuario();
		
		us.setUsrApellido("Ramirez");
		us.setUsrCelular("3214569872");
		us.setUsrContrasenna("dfhdfh654");
		us.setUsrEmail("rami@gmail.com"); 
		us.setUsrNombre("Danilo");
		us.setUsrAlias("DRamirez");
		us.setUsrFechana(LocalDate.parse("2001-12-06"));
		
		repositorio.save(us);
		
		
		
	}

}
