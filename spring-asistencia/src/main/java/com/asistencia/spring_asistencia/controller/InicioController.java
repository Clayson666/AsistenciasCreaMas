/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.controller;

import com.asistencia.spring_asistencia.model.Asistencia;
import com.asistencia.spring_asistencia.model.AsistenciaForm;
import com.asistencia.spring_asistencia.model.Creando;
import com.asistencia.spring_asistencia.model.Lugar;
import com.asistencia.spring_asistencia.model.Persona;
import com.asistencia.spring_asistencia.model.Programa;
import com.asistencia.spring_asistencia.model.Semana;
import com.asistencia.spring_asistencia.service.AsistenciaService;
import com.asistencia.spring_asistencia.service.CambioDeSemanaService;
import com.asistencia.spring_asistencia.service.CreandosService;
import com.asistencia.spring_asistencia.service.LugarService;
import com.asistencia.spring_asistencia.service.PersonaService;
import com.asistencia.spring_asistencia.service.ProgramaService;
import com.asistencia.spring_asistencia.service.SemanaService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author eulal
 */
@Controller
@SessionAttributes("idLugar") // Usando @SessionAttributes si se necesita en múltiples métodos
public class InicioController {

    private static final Logger logger = LoggerFactory.getLogger(InicioController.class);

    @Autowired
    private LugarService lugarService;

    @Autowired
    private PersonaService personaService;

    @Autowired
    private CreandosService creandoService;

    @Autowired
    private SemanaService semanaService;

    @Autowired
    private AsistenciaService asistenciaService;

    @Autowired
    private CambioDeSemanaService cambioSemanaService;

    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<Lugar> lugar = lugarService.findAll();
        model.addAttribute("lugar", lugar);
        return "usuario/inicio";
    }

    @PostMapping("/personas")
    public String vistaLugar(@RequestParam Integer idLugar, Model model, HttpSession session) {
        logger.info("id lugar: " + idLugar);
        session.setAttribute("idLugar", idLugar);
        List<Persona> personas = personaService.findByLugarIdLugar(idLugar);
        model.addAttribute("personasLugar", personas);
        return "usuario/personas";
    }

    private void prepararVistaCreandos(Model model, Integer idLugar) {
        int idSemanaActual = cambioSemanaService.semanaActual(idLugar);
        List<Creando> creandos = creandoService.findByLugaridLugar(idLugar);
        model.addAttribute("lugarCreandos", creandos);
        model.addAttribute("idLugar", idLugar);

        Optional<Semana> semanas = semanaService.get(idSemanaActual);
        if (semanas.isPresent()) {
            model.addAttribute("semanaActual", semanas.get());  // Extraer el objeto Semana del Optional
        } else {
            model.addAttribute("semanaActual", new Semana());  // O un valor por defecto
        }
    }

    @GetMapping("/creandos")
    public String vistaCreandos(@RequestParam Integer idLugar, Model model, HttpSession session) {
        
    
            session.setAttribute("idLugar", idLugar);
            prepararVistaCreandos(model, idLugar);  // Reutiliza el método
            return "usuario/agregarCreandos";
        

    }

    @PostMapping("/creandos/guardar")
    public String guardarAsistencica(AsistenciaForm asistenciaForm, HttpSession session, Model model) {
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        if (idLugar == null) {
            // Maneja el caso en que idLugar no está disponible
            // Puedes redirigir a una página de error o mostrar un mensaje
            return "redirect:/error"; // O cualquier otra lógica
        }
        int idSemanaActual = cambioSemanaService.semanaActual(idLugar);
        asistenciaService.guardarAsistencias(asistenciaForm.getAsistencias(), idSemanaActual);

        // Seguir trabajando con los datos almacenados en la sesión
        prepararVistaCreandos(model, idLugar);

        return "redirect:/creandos?idLugar=" + idLugar;

    }

    @GetMapping("/verAsistenciasCreandos")
    public String verAsistenciaCreandos(Model model, HttpSession session) {
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        Integer semanaActual = cambioSemanaService.semanaActual(idLugar);
        List<Asistencia> asistencias = asistenciaService.filtroLugarSemana(idLugar, semanaActual - 1);
        model.addAttribute("asistencias", asistencias);
        List<Object[]> semanas = asistenciaService.obtenerSemanasUnicas();
        logger.info(semanas.toString());
        model.addAttribute("listadoSemanas", semanas);
        return "usuario/verAsistenciasCreandos";
    }

    
    @PostMapping("/filtroSemanas")
    public String filtrarPorSemana(@RequestParam("idsemana") Integer idSemanaSeleccionada, Model model, HttpSession session){
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        List<Asistencia> asistencias = asistenciaService.filtroLugarSemana(idLugar,idSemanaSeleccionada);
        model.addAttribute("asistencias", asistencias);
        List<Object[]> semanas = asistenciaService.obtenerSemanasUnicas();
        model.addAttribute("listadoSemanas", semanas);
        model.addAttribute("idSemanaSeleccionada", idSemanaSeleccionada);
        return "usuario/verAsistenciasCreandos";
    }
}
