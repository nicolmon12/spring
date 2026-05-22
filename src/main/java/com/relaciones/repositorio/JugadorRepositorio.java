package com.relaciones.repositorio;
import com.relaciones.entidades.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
public interface JugadorRepositorio extends JpaRepository<Jugador, Long> {}
