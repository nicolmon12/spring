package com.relaciones.entidades;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Competicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private BigDecimal montoPremio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // ManyToMany con Club
    @ManyToMany
    @JoinTable(
        name = "competicion_clubes",
        joinColumns = @JoinColumn(name = "competicion_id"),
        inverseJoinColumns = @JoinColumn(name = "clubes_id")
    )
    private List<Club> clubes;

    public Competicion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public BigDecimal getMontoPremio() { return montoPremio; }
    public void setMontoPremio(BigDecimal montoPremio) { this.montoPremio = montoPremio; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public List<Club> getClubes() { return clubes; }
    public void setClubes(List<Club> clubes) { this.clubes = clubes; }
}
