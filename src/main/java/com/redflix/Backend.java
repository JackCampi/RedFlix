package com.redflix;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.repos.*;
import com.tablas.Contenido;
import com.tablas.Director;
import com.tablas.Pelicula;
import com.tablas.Serie;
import com.tablas.Transmision;
import com.tablas.Usuario;

class Backend {
	
	@Autowired
    private static UsuarioRepositorio usRepos;
	@Autowired
	private static DirectorRepositorio diRrepos;
	@Autowired
	private static PeliculaRepositorio peliRepos;
	@Autowired
	private static SerieRepositorio serieRepos;
	@Autowired
	private static ContenidoRepositorio contRepos;
	@Autowired
	private static TransmisionRepositorio trRepos;
	
	public static boolean actualizar(String tabla, HashMap<String,String> map) {
		
		try {
			
			if(tabla.equals(Constants.usuario)){
				
			    Usuario usuario = getUsuario(map);
			    usRepos.save(usuario);
			    
		    }else if(tabla.equals(Constants.director)){
		    	
		    	
			    Director usuario = getDirector(map);
			    diRrepos.save(usuario);  
			    
		    }else if(tabla.equals(Constants.pelicula)){
		    	
		    	
			    Pelicula usuario = getPelicula(map);
			    peliRepos.save(usuario);
			    
		    }else if(tabla.equals(Constants.serie)){
		    	
		    	
			    Serie usuario = getSerie(map);
			    serieRepos.save(usuario);  	
			    
		    }else if(tabla.equals(Constants.contenido)){
		    	
		    	
			    Contenido usuario = getContenido(map);
			    contRepos.save(usuario);  		
			    
		    }else if(tabla.equals(Constants.transmision)){
		    	
		    	
			    Transmision usuario = getTransmision(map);
			    trRepos.save(usuario);
			    
		    }
			
			return true;
			
		}catch(Exception e) {
			
			return false;
			
		}
		
	}
	
	
	public static HashMap<String,String> buscar(String tabla, String busqueda){
		
		//empty keys
		return null;
	
	}


	public static boolean eliminar(String tabla, String llave_primaria){
	
		return true;
	
	}
	
	private static Director getDirector(HashMap<String, String> dirInfo){
		Director director = new Director();
		director.setDirId(Integer.parseInt(dirInfo.get(Constants.director_id)));
		director.setDirNombre(dirInfo.get(Constants.director_nombre));
		director.setDirApellido(dirInfo.get(Constants.director_apellido));
		director.setDirNacionalidad(dirInfo.get(Constants.director_nacionalidad));
		return director;
	}

	private static Contenido getContenido(HashMap<String, String> contInfo){
		Contenido contenido = new Contenido();
		contenido.setContID(Integer.parseInt(contInfo.get(Constants.contenido_id)));
		contenido.setContTitulo(contInfo.get(Constants.contenido_titulo));
		contenido.setContTipo(contInfo.get(Constants.contenido_tipo));
		return contenido;
	}

	private static Pelicula getPelicula(HashMap<String, String> pelInfo){
		Pelicula pelicula = new Pelicula();
		pelicula.setPeliTitulo(pelInfo.get(Constants.pelicula_titulo));
		pelicula.setPeliResumen(pelInfo.get(Constants.pelicula_resumen));
		pelicula.setPeliAnno(Integer.parseInt(pelInfo.get(Constants.pelicula_agno)));
		pelicula.setDirector(Integer.parseInt(pelInfo.get(Constants.pelicula_director)));
		return pelicula;
	}

	private static Serie getSerie(HashMap<String, String> serInfo){
		Serie serie = new Serie();
		serie.setSrTitulo(serInfo.get(Constants.serie_titulo));
		serie.setSrEpisodios(Integer.parseInt(serInfo.get(Constants.serie_episodios)));
		serie.setSrTemp(Integer.parseInt(serInfo.get(Constants.serie_temporadas)));
		return serie;
	}

	private static Transmision getTransmision(HashMap<String, String> trInfo){
		Transmision transmision = new Transmision();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime dateTime = LocalDateTime.parse(trInfo.get(Constants.transmision_fecha_hora), formatter);
		transmision.setTrID(Integer.parseInt(trInfo.get(Constants.transmision_id)));
		transmision.setTrUsuario(trInfo.get(Constants.transmision_usuario));
		transmision.setTrContenido(Integer.parseInt(trInfo.get(Constants.transmision_contenido)));
		transmision.setTrFechaHora(dateTime);

		return transmision;
	}

	private static Usuario getUsuario(HashMap<String, String> usrInfo){
		Usuario usuario = new Usuario();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(usrInfo.get(Constants.usuario_fecha_nacimiento), formatter);

		usuario.setUsrAlias(usrInfo.get(Constants.usuario_alias));
		usuario.setUsrNombre(usrInfo.get(Constants.usuario_nombre));
		usuario.setUsrApellido(usrInfo.get(Constants.usuario_apellido));
		usuario.setUsrEmail(usrInfo.get(Constants.usuario_email));
		usuario.setUsrCelular(usrInfo.get(Constants.usuario_celular));
		usuario.setUsrContrasenna(usrInfo.get(Constants.usuario_contrasegna));
		usuario.setUsrFechana(localDate);

		return usuario;
	}

}
