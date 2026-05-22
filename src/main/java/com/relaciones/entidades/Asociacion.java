package com.relaciones.entidades;

import jakarta.persistence.*;

@Entity
public class Asociacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String pais;
    private String presidente;

    // OneToOne con Club (una asociacion regula un club principal)
    @OneToOne(mappedBy = "asociacion")
    private Club club;

    public Asociacion() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getPresidente() { return presidente; }
    public void setPresidente(String presidente) { this.presidente = presidente; }
    public Club getClub() { return club; }
    public void setClub(Club club) { this.club = club; }
}
