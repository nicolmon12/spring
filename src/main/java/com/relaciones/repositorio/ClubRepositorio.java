package com.relaciones.repositorio;
import com.relaciones.entidades.Club;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClubRepositorio extends JpaRepository<Club, Long> {}
