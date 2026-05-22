package com.relaciones.controladores;

import com.relaciones.entidades.Asociacion;
import com.relaciones.repositorio.AsociacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asociaciones")
public class AsociacionController {

    @Autowired
    private AsociacionRepositorio asociacionRepositorio;

    @GetMapping
    public String redirectLista() {
        return "redirect:/asociaciones/lista";
    }

    @GetMapping("/nueva")
    public String formularioNuevaAsociacion(Model model) {
        model.addAttribute("asociacion", new Asociacion());
        return "asociaciones/formulario";
    }

    @PostMapping("/guardar")
    public String guardarAsociacion(@ModelAttribute Asociacion asociacion) {
        asociacionRepositorio.save(asociacion);
        return "redirect:/asociaciones/lista";
    }

    @Transactional
    @GetMapping("/lista")
    public String listarAsociaciones(Model model) {
        model.addAttribute("asociaciones", asociacionRepositorio.findAll());
        return "asociaciones/lista";
    }
}
