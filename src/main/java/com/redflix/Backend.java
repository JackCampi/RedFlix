package com.redflix;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

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
	private static DirectorRepositorio dirRepos;
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
			    dirRepos.save(usuario);  
			    
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
		
		HashMap<String,String> map;
		if(tabla.equals(Constants.usuario)){
			
			Optional<Usuario> optional = usRepos.findById(busqueda);
			if(optional.isPresent()) return getUsuarioDic(optional.get());
			else return getEmptyUsuarioDic();

		    
	    }else if(tabla.equals(Constants.director)){
	    	
	    	Optional<Director> optional = dirRepos.findByName(busqueda);
			if(optional.isPresent()) return getDirectorDic(optional.get());
			else return getEmptyDirectorDic();
		    
	    }else if(tabla.equals(Constants.pelicula)){
	    	
	    	Optional<Pelicula> optional = peliRepos.findById(busqueda);
			if(optional.isPresent()) return getPeliculaDic(optional.get());
			else return getEmptyPeliculaDic(); 
		    
	    }else if(tabla.equals(Constants.serie)){
	    	
	    	Optional<Serie> optional = serieRepos.findById(busqueda);
			if(optional.isPresent()) return getSerieDic(optional.get());
			else return getEmptySerieDic();
		    
	    }else {
	    	return null;
	    }
	
	}


	public static boolean eliminar(String tabla, String llave_primaria){
	
		try {
			
			if(tabla.equals(Constants.usuario)){

			    usRepos.deleteById(llave_primaria); 
			    
		    }else if(tabla.equals(Constants.director)){
		    	
		    	dirRepos.deleteById(llave_primaria);  
			    
		    }else if(tabla.equals(Constants.pelicula)){
		    	
			    peliRepos.deleteById(llave_primaria); 
			    
		    }else if(tabla.equals(Constants.serie)){
		    	
			    serieRepos.deleteById(llave_primaria); 
			    
		    }else if(tabla.equals(Constants.contenido)){
		    	
			    contRepos.deleteById(llave_primaria); 		
			    
		    }else if(tabla.equals(Constants.transmision)){
		    	
			    trRepos.deleteById(llave_primaria); 
			    
		    }
			
			return true;
			
		}catch(Exception e) {
			
			return false;
			
		}
	
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
	
	public static HashMap<String,String> getSerieDic(Serie serie){
		HashMap<String,String> serieDic = new HashMap<String,String>();
		serieDic.put(Constants.serie_titulo, serie.getSrTitulo());
		serieDic.put(Constants.serie_episodios, serie.getSrEpisodios().toString());
		serieDic.put(Constants.serie_episodios, serie.getSrTemp().toString());
		return serieDic;
	}
	
	public static HashMap<String,String> getPeliculaDic(Pelicula pelicula){
		HashMap<String,String> peliDic = new HashMap<String,String>();
		peliDic.put(Constants.pelicula_titulo, pelicula.getPeliTitulo());
		peliDic.put(Constants.pelicula_resumen, pelicula.getPeliResumen());
		peliDic.put(Constants.pelicula_director, pelicula.getDirector().toString());
		peliDic.put(Constants.pelicula_agno, pelicula.getPeliAnno().toString());
		return peliDic;
	}
	
	public static HashMap<String,String> getDirectorDic(Director director){
		HashMap<String,String> directorDic = new HashMap<String,String>();
		directorDic.put(Constants.director_id, director.getDirId().toString());
		directorDic.put(Constants.director_nombre,director.getDirNombre());
		directorDic.put(Constants.director_apellido, director.getDirApellido());
		directorDic.put(Constants.director_nacionalidad, director.getDirNacionalidad());
		return directorDic;
	}
	
	public static HashMap<String,String> getUsuarioDic(Usuario usuario){
		HashMap<String,String> usuarioDic = new HashMap<String,String>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		usuarioDic.put(Constants.usuario_alias, usuario.getUsrAlias());
		usuarioDic.put(Constants.usuario_nombre, usuario.getUsrNombre());
		usuarioDic.put(Constants.usuario_apellido, usuario.getUsrApellido());
		usuarioDic.put(Constants.usuario_celular, usuario.getUsrCelular());
		usuarioDic.put(Constants.usuario_contrasegna, usuario.getUsrContrasenna());
		usuarioDic.put(Constants.usuario_email, usuario.getUsrEmail());
		usuarioDic.put(Constants.usuario_fecha_nacimiento, usuario.getUsrFechana().format(formatter));
		return usuarioDic;
	}
	
	public static HashMap<String,String> getEmptySerieDic(){
		HashMap<String,String> serieDic = new HashMap<String,String>();
		serieDic.put(Constants.serie_titulo, "No encontrado");
		serieDic.put(Constants.serie_episodios, "No encontrado");
		serieDic.put(Constants.serie_episodios, "No encontrado");
		return serieDic;
	}
	
	public static HashMap<String,String> getEmptyPeliculaDic(){
		HashMap<String,String> peliDic = new HashMap<String,String>();
		peliDic.put(Constants.pelicula_titulo, "No encontrado");
		peliDic.put(Constants.pelicula_resumen, "No encontrado");
		peliDic.put(Constants.pelicula_director, "No encontrado");
		peliDic.put(Constants.pelicula_agno, "No encontrado");
		return peliDic;
	}
	
	public static HashMap<String,String> getEmptyDirectorDic(){
		HashMap<String,String> directorDic = new HashMap<String,String>();
		directorDic.put(Constants.director_id, "No encontrado");
		directorDic.put(Constants.director_nombre,"No encontrado");
		directorDic.put(Constants.director_apellido, "No encontrado");
		directorDic.put(Constants.director_nacionalidad, "No encontrado");
		return directorDic;
	}
	
	public static HashMap<String,String> getEmptyUsuarioDic(){
		HashMap<String,String> usuarioDic = new HashMap<String,String>();
		usuarioDic.put(Constants.usuario_alias, "No encontrado");
		usuarioDic.put(Constants.usuario_nombre, "No encontrado");
		usuarioDic.put(Constants.usuario_apellido, "No encontrado");
		usuarioDic.put(Constants.usuario_celular, "No encontrado");
		usuarioDic.put(Constants.usuario_contrasegna, "No encontrado");
		usuarioDic.put(Constants.usuario_email, "No encontrado");
		usuarioDic.put(Constants.usuario_fecha_nacimiento, "No encontrado");
		return usuarioDic;
	}

}
