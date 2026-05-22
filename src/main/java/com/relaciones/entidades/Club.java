package com.relaciones.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ciudad;

    // OneToOne con Asociacion
    @OneToOne
    @JoinColumn(name = "asociacion_id")
    private Asociacion asociacion;

    // OneToOne con Entrenador (el entrenador principal del club)
    @OneToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;

    // OneToMany con Jugador
    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Jugador> jugadores;

    // OneToMany con Entrenadores (staff completo)
    @OneToMany(mappedBy = "club")
    private List<Entrenador> entrenadores;

    // ManyToMany con Competicion
    @ManyToMany(mappedBy = "clubes")
    private List<Competicion> competiciones;

    public Club() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public Asociacion getAsociacion() { return asociacion; }
    public void setAsociacion(Asociacion asociacion) { this.asociacion = asociacion; }
    public Entrenador getEntrenador() { return entrenador; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }
    public List<Jugador> getJugadores() { return jugadores; }
    public void setJugadores(List<Jugador> jugadores) { this.jugadores = jugadores; }
    public List<Entrenador> getEntrenadores() { return entrenadores; }
    public void setEntrenadores(List<Entrenador> entrenadores) { this.entrenadores = entrenadores; }
    public List<Competicion> getCompeticiones() { return competiciones; }
    public void setCompeticiones(List<Competicion> competiciones) { this.competiciones = competiciones; }
}
