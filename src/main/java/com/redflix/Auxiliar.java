package com.redflix;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.tablas.Director;
import com.tablas.Pelicula;
import com.tablas.Serie;
import com.tablas.Usuario;

public class Auxiliar {
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
