package com.relaciones.controladores;

import com.relaciones.entidades.Competicion;
import com.relaciones.repositorio.CompeticionRepositorio;
import com.relaciones.repositorio.ClubRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/competiciones")
public class CompeticionController {

    @Autowired
    private CompeticionRepositorio competicionRepositorio;

    @Autowired
    private ClubRepositorio clubRepositorio;

    // Redirige /competiciones → /competiciones/lista
    @GetMapping
    public String redirectLista() {
        return "redirect:/competiciones/lista";
    }

    @GetMapping("/lista")
    @Transactional
    public String listarCompeticiones(Model model) {
        model.addAttribute("competiciones", competicionRepositorio.findAll());
        return "competiciones/lista";
    }

    @GetMapping("/nueva")
    public String formularioNuevaCompeticion(Model model) {
        model.addAttribute("competicion", new Competicion());
        model.addAttribute("clubes", clubRepositorio.findAll());
        return "competiciones/formulario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarCompeticion(@PathVariable Long id, Model model) {
        Competicion competicion = competicionRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Competición no encontrada"));
        model.addAttribute("competicion", competicion);
        model.addAttribute("clubes", clubRepositorio.findAll());
        return "competiciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardarCompeticion(@ModelAttribute Competicion competicion) {
        competicionRepositorio.save(competicion);
        return "redirect:/competiciones/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCompeticion(@PathVariable Long id) {
        competicionRepositorio.deleteById(id);
        return "redirect:/competiciones/lista";
    }
}
