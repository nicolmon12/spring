package com.relaciones.controladores;

import com.relaciones.entidades.Jugador;
import com.relaciones.repositorio.JugadorRepositorio;
import com.relaciones.repositorio.ClubRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepositorio jugadorRepositorio;

    @Autowired
    private ClubRepositorio clubRepositorio;

    // Redirige /jugadores → /jugadores/lista
    @GetMapping
    public String redirectLista() {
        return "redirect:/jugadores/lista";
    }

    @GetMapping("/lista")
    @Transactional
    public String listarJugadores(Model model) {
        model.addAttribute("jugadores", jugadorRepositorio.findAll());
        return "jugadores/lista";
    }

    @GetMapping("/nuevo")
    public String formularioNuevoJugador(Model model) {
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("clubes", clubRepositorio.findAll());
        return "jugadores/formulario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarJugador(@PathVariable Long id, Model model) {
        Jugador jugador = jugadorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado"));
        model.addAttribute("jugador", jugador);
        model.addAttribute("clubes", clubRepositorio.findAll());
        return "jugadores/formulario";
    }

    @PostMapping("/guardar")
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        jugadorRepositorio.save(jugador);
        return "redirect:/jugadores/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarJugador(@PathVariable Long id) {
        jugadorRepositorio.deleteById(id);
        return "redirect:/jugadores/lista";
    }
}
