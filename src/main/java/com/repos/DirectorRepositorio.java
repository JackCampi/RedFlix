package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tablas.Director;


@Repository
public interface DirectorRepositorio extends JpaRepository<Director,String> {
	


}
