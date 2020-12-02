package com.redflix;

import java.time.LocalDate;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.repos.ContenidoRepositorio;
import com.repos.DirectorRepositorio;
import com.repos.PeliculaRepositorio;
import com.repos.SerieRepositorio;
import com.repos.TransmisionRepositorio;
import com.repos.UsuarioRepositorio;
import com.tablas.Director;
import com.tablas.Serie;
import com.tablas.Usuario;

@Component
public class Runner implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(Runner.class);
	
	@Autowired
    private UsuarioRepositorio usRepos;
	@Autowired
	private DirectorRepositorio dirRepos;
	@Autowired
	private PeliculaRepositorio peliRepos;
	@Autowired
	private SerieRepositorio serieRepos;
	@Autowired
	private ContenidoRepositorio contRepos;
	@Autowired
	private TransmisionRepositorio trRepos;

	@Override
	public void run(String... args) throws Exception {
		
		
		Backend back = new Backend(usRepos,dirRepos,peliRepos,serieRepos,
				contRepos,trRepos);
		/*HashMap<String, String> us =back.buscar(Constants.usuario, "diva");
		logger.info((us == null)+"");*/
		
		
		logger.info("INIT--------------------------------------------------");
		
		/*Backend back = new Backend();
		back.buscar(Constants.usuario, "Diva");*/
		
		/*Usuario us = new Usuario();
		
		us.setUsrApellido("Ramires");
		us.setUsrCelular("3214569872");
		us.setUsrContrasenna("dfhdfh654");
		us.setUsrEmail("rami@gmail.com"); 
		us.setUsrNombre("Danilo");
		us.setUsrAlias("DRamirez");
		us.setUsrFechana(LocalDate.parse("2001-12-06"));
		
		repositorio.save(us);*/
		
		
		
	}

}
