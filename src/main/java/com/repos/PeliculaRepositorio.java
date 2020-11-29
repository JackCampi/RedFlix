package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tablas.Pelicula;


@Repository
public interface PeliculaRepositorio extends JpaRepository<Pelicula,String> {
	


}