package com.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tablas.Director;


@Repository
public interface DirectorRepositorio extends JpaRepository<Director,String> {
	
	@Query("SELECT d FROM director d WHERE d.dirNombre = :name")
	public Optional<Director> findByName(@Param("name") String name);

}
