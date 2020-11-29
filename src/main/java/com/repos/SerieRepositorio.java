package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tablas.Serie;


@Repository
public interface SerieRepositorio extends JpaRepository<Serie,String> {
	


}
