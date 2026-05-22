package com.relaciones.repositorio;
import com.relaciones.entidades.Competicion;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CompeticionRepositorio extends JpaRepository<Competicion, Long> {}
