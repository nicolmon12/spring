package com.relaciones.controladores;

import com.relaciones.entidades.Entrenador;
import com.relaciones.repositorio.EntrenadorRepositorio;
import com.relaciones.repositorio.ClubRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadorRepositorio entrenadorRepositorio;

    @Autowired
    private ClubRepositorio clubRepositorio;

    // Redirige /entrenadores → /entrenadores/lista
    @GetMapping
    public String redirectLista() {
        return "redirect:/entrenadores/lista";
    }

    @GetMapping("/lista")
    @Transactional
    public String listarEntrenadores(Model model) {
        model.addAttribute("entrenadores", entrenadorRepositorio.findAll());
        return "entrenadores/lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevoEntrenador(Model model) {
        model.addAttribute("entrenador", new Entrenador());
        model.addAttribute("clubes", clubRepositorio.findAll());
        return "entrenadores/formulario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarEntrenador(@PathVariable Long id, Model model) {
        Entrenador entrenador = entrenadorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrenador no encontrado"));
        model.addAttribute("entrenador", entrenador);
        model.addAttribute("clubes", clubRepositorio.findAll());
        return "entrenadores/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEntrenador(@ModelAttribute Entrenador entrenador) {
        entrenadorRepositorio.save(entrenador);
        return "redirect:/entrenadores/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarEntrenador(@PathVariable Long id) {
        entrenadorRepositorio.deleteById(id);
        return "redirect:/entrenadores/lista";
    }
}
