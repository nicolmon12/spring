package com.relaciones.controladores;

import com.relaciones.entidades.Club;
import com.relaciones.repositorio.AsociacionRepositorio;
import com.relaciones.repositorio.ClubRepositorio;
import com.relaciones.repositorio.CompeticionRepositorio;
import com.relaciones.repositorio.EntrenadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    @Autowired
    private ClubRepositorio clubRepositorio;

    @Autowired
    private AsociacionRepositorio asociacionRepositorio;

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    // Redirige /clubes → /clubes/lista
    @GetMapping
    public String redirectLista() {
        return "redirect:/clubes/lista";
    }

    @GetMapping("/lista")
    @Transactional
    public String listarClubes(Model model) {
        model.addAttribute("clubes", clubRepositorio.findAll());
        return "clubes/lista";
    }

    @GetMapping("/nuevo")
    @Transactional
    public String formularioNuevoClub(Model model) {
        model.addAttribute("club", new Club());
        model.addAttribute("asociaciones", asociacionRepositorio.findAll());
        model.addAttribute("entrenadores", entrenadorRepositorio.findAll());
        model.addAttribute("competiciones", competicionRepositorio.findAll());
        return "clubes/formulario";
    }

    @GetMapping("/editar/{id}")
    @Transactional
    public String formularioEditarClub(@PathVariable Long id, Model model) {
        Club club = clubRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Club no encontrado"));
        model.addAttribute("club", club);
        model.addAttribute("asociaciones", asociacionRepositorio.findAll());
        model.addAttribute("entrenadores", entrenadorRepositorio.findAll());
        model.addAttribute("competiciones", competicionRepositorio.findAll());
        return "clubes/formulario";
    }

    @PostMapping("/guardar")
    public String guardarClub(@ModelAttribute Club club) {
        clubRepositorio.save(club);
        return "redirect:/clubes/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarClub(@PathVariable Long id) {
        clubRepositorio.deleteById(id);
        return "redirect:/clubes/lista";
    }
}
