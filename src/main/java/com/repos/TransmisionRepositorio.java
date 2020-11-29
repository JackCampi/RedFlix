package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tablas.Transmision;


@Repository
public interface TransmisionRepositorio extends JpaRepository<Transmision,String> {
	


}
