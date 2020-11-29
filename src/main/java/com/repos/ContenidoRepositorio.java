package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tablas.Contenido;


@Repository
public interface ContenidoRepositorio extends JpaRepository<Contenido,String> {
	


}