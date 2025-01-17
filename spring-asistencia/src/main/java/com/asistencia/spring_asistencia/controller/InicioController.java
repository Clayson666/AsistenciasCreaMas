/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.controller;

import com.asistencia.spring_asistencia.model.Asistencia;
import com.asistencia.spring_asistencia.model.AsistenciaForm;
import com.asistencia.spring_asistencia.model.Creando;
import com.asistencia.spring_asistencia.model.CreandoLideres;
import com.asistencia.spring_asistencia.model.Lugar;
import com.asistencia.spring_asistencia.model.Persona;
import com.asistencia.spring_asistencia.model.Semana;
import com.asistencia.spring_asistencia.service.*;
import jakarta.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
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

    @Autowired
    private LideresService lideresService;

    @GetMapping("/inicio")
    public String obtenerInicioPorPrograma(Model model,
            @RequestParam(value = "idPrograma", required = true) Integer idPrograma, HttpSession session) {
        List<Lugar> lugar = lugarService.lugarPorPrograma(idPrograma);
        model.addAttribute("lugar", lugar);
        model.addAttribute("idPrograma", idPrograma);
        //SETEAMOS SESIÓN PARA EL PROGRAMA
        session.setAttribute("idPrograma", idPrograma);
        System.out.println(">>>>>>>>>>> "+idPrograma);
        return "usuario/inicio";
    }


    @GetMapping("/dashboard")
    public String dashboard(@RequestParam Integer idLugar, Model model, HttpSession session) {
        List<String> semanasLugar = asistenciaService.obtenerNombreSemanaPorLugar(idLugar);
        List<Integer> data1 = asistenciaService.contarAsistenciasPorSemanaYEstado(idLugar, "Asistió");
        List<Integer> data2 = asistenciaService.contarAsistenciasPorSemanaYEstado(idLugar, "Falta");
        Integer cantidadCreandosActivos = personaService.contarCreandosActivosBaja(idLugar, 1);
        Integer cantidadCreandosBaja = personaService.contarCreandosActivosBaja(idLugar, 2);
        model.addAttribute("labels", semanasLugar);
        model.addAttribute("data1", data1);
        model.addAttribute("data2", data2);
        model.addAttribute("creandosActivos", cantidadCreandosActivos);
        model.addAttribute("creandosBaja", cantidadCreandosBaja);
        return "usuario/dashboard";
    }

    @GetMapping("/lideres")
    public String vistaLideres( Model model, HttpSession session) {
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        Integer idPrograma = (Integer) session.getAttribute("idPrograma");
        System.out.println(">>>>>>>PROGRAMA es: "+idPrograma);
    
        // Verificar si están presentes
        if (idLugar != null && idPrograma != null) {
            model.addAttribute("idLugar", idLugar);
            model.addAttribute("idPrograma", idPrograma);
        } else {
            // Manejo del caso en que no existan en la sesión
            return "error";
        }
        prepararVistaLideres(model, idLugar,idPrograma);
        return "usuario/agregarLideres";
    }
    
    @GetMapping("/creandos")
    public String vistaCreandos(@RequestParam Integer idLugar, Model model, HttpSession session) {
        Integer idPrograma = (Integer) session.getAttribute("idPrograma");
        System.out.println(">>>>CREANDOS/IDPROGRAMA:" + idPrograma);
    
        if (idPrograma == null) {
            // Manejar el caso en que idPrograma no está configurado en la sesión
            return "redirect:/error"; // Redirigir a una página de error o inicio de sesión
        }
    
        session.setAttribute("idLugar", idLugar);
        System.out.println(">>>>>>>>>>> linea 152 " + idLugar);
    
        boolean ruta = prepararVistaCreandos(model, idLugar, idPrograma);


        if (ruta==true) {
            return "usuario/agregarCreandos";
        }else{
            return "usuario/faltaRegistroAsistencia";
        }


        
    }

    @PostMapping("/personas")
    public String vistaLugar(@RequestParam Integer idLugar, Model model, HttpSession session) {
        logger.info("id lugar: " + idLugar);
        session.setAttribute("idLugar", idLugar);
        List<Persona> personas = personaService.findByLugarIdLugar(idLugar);
        model.addAttribute("personasLugar", personas);
        return "usuario/personas";
    }

    private Boolean prepararVistaCreandos(Model model, Integer idLugar, Integer idPrograma) {
        
        LocalDate fechaDeHoy = LocalDate.now();

       
        System.out.println(">>>>>>>>>> IDPROGRAMA : "+idPrograma);
        int idSemanaActual = cambioSemanaService.semanaActual(idLugar,idPrograma);
        
        List<Creando> creandos = creandoService.CreandosActivos(idLugar);
        model.addAttribute("lugarCreandos", creandos);
        model.addAttribute("idLugar", idLugar);

        Optional<Semana> semanas = semanaService.get(idSemanaActual);

        LocalDate fechaInicio = semanas.get().getFechaInicio();
        LocalDate fechaVencimiento = semanas.get().getFechaVencimiento();
        if (semanas.isPresent()) {
            model.addAttribute("semanaActual", semanas.get()); // Extraer el objeto Semana del Optional
        } else {
            model.addAttribute("semanaActual", new Semana()); // O un valor por defecto
        }


        if (fechaDeHoy.isAfter(fechaInicio.minusDays(1)) && fechaDeHoy.isBefore(fechaVencimiento.plusDays(1))) {
            return true;
        }else{
            return false;
        }
    }

    private void prepararVistaLideres(Model model, Integer idLugar, Integer idPrograma) {
        int idSemanaActual = cambioSemanaService.semanaActualLideres(idLugar, idPrograma);
        List<CreandoLideres> creandosLideres = lideresService.LideresActivos(idLugar);
        model.addAttribute("lugarCreandos", creandosLideres);
        model.addAttribute("idLugar", idLugar);

        Optional<Semana> semanas = semanaService.get(idSemanaActual);
        if (semanas.isPresent()) {
            model.addAttribute("semanaActual", semanas.get()); // Extraer el objeto Semana del Optional
        } else {
            model.addAttribute("semanaActual", new Semana()); // O un valor por defecto
        }
    }


    

    @PostMapping("/creandos/guardar")
    public String guardarAsistencica(AsistenciaForm asistenciaForm, HttpSession session, Model model) {
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        Integer idPrograma = (Integer) session.getAttribute("idPrograma");
        if (idLugar == null) {
            // Maneja el caso en que idLugar no está disponible
            // Puedes redirigir a una página de error o mostrar un mensaje
            return "redirect:/error"; // O cualquier otra lógica
        }
        int idSemanaActual = cambioSemanaService.semanaActual(idLugar, idPrograma);
        asistenciaService.guardarAsistencias(asistenciaForm.getAsistencias(), idSemanaActual);

        // Seguir trabajando con los datos almacenados en la sesión
        prepararVistaCreandos(model, idLugar, idPrograma);

        return "redirect:/creandos?idPrograma="+idPrograma+"&idLugar="+idLugar;

    }

    @PostMapping("/lideres/guardar")
    public String guardarAsistencicaLideres(AsistenciaForm asistenciaForm, HttpSession session, Model model) {
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        Integer idPrograma = (Integer) session.getAttribute("idPrograma");
        if (idLugar == null) {
            // Maneja el caso en que idLugar no está disponible
            // Puedes redirigir a una página de error o mostrar un mensaje
            return "redirect:/error"; // O cualquier otra lógica
        }
        int idSemanaActual = cambioSemanaService.semanaActualLideres(idLugar, idPrograma);
        asistenciaService.guardarAsistencias(asistenciaForm.getAsistencias(), idSemanaActual);

        // Seguir trabajando con los datos almacenados en la sesión
        prepararVistaLideres(model, idLugar, idPrograma);

        return "redirect:/lideres?idLugar=" + idLugar;

    }

    @GetMapping("/editar")
    public String mostrarFormularioEdicion(@RequestParam("id") Integer id, Model model) {
        Optional<Asistencia> asistencia = asistenciaService.mostrarPorIdAsistencia(id);
        if (asistencia.isPresent()) {
            model.addAttribute("asistencia", asistencia.get());
            return "usuario/editarCreandos";
        } else {
            return "redirect:/error";
        }
    }

    @PostMapping("/editar")
    public String updateAttendance(@RequestParam("id") Integer id, @RequestParam("asistencia") String asistencia,
            HttpSession session) {
        Asistencia asistenciaActual = asistenciaService.encontrarPorIdasistencia(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid attendance Id:" + id));
        asistenciaActual.setAsistencia(asistencia);
        asistenciaService.savePorAsistencia(asistenciaActual);
        return "redirect:/verAsistenciasCreandos";
    }

    @GetMapping("/verAsistenciasCreandos")
    public String verAsistenciaCreandos(Model model, HttpSession session) {
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        Integer idPrograma = (Integer) session.getAttribute("idPrograma");
        Integer semanaActual = cambioSemanaService.ultimaSemanaRegistrada(idLugar,idPrograma);
        System.out.println(">>>>>>>> SEMANA ACTUAL ES: "+semanaActual);
        List<Asistencia> asistencias = asistenciaService.filtroLugarSemanaCreando(idLugar, semanaActual);
        System.out.println(">>>>> CONTROL 226: "+asistencias);
        //EN CASO NO SE HAYAN REGISTRADO ASISTENCIAS ESTE DEBE MOSTRAR UNA VISTA DONDE REQUIERE LA ASISTENCIA
        if (asistencias.isEmpty()) {
            return "usuario/faltaRegistroAsistencia";
        }
        model.addAttribute("asistencias", asistencias);
        List<Object[]> semanas = asistenciaService.obtenerSemanasUnicasCreandos(idLugar, idPrograma);
        logger.info(semanas.toString());
        model.addAttribute("listadoSemanas", semanas);
        return "usuario/verAsistenciasCreandos";
    }

    @GetMapping("/verAsistenciasLideres")
    public String verAsistenciaLideres(Model model, HttpSession session) {
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        Integer idPrograma = (Integer) session.getAttribute("idPrograma");
        Integer semanaActual = cambioSemanaService.ultimaSemanaRegistradaLideres(idLugar, idPrograma);
        List<Asistencia> asistencias = asistenciaService.filtroLugarSemanaLideres(idLugar, semanaActual);
        System.out.println(">>>>> CONTROL 239: "+asistencias);
        model.addAttribute("asistencias", asistencias);
        List<Object[]> semanas = asistenciaService.obtenerSemanasUnicasLideres(idLugar, idPrograma);
        logger.info(semanas.toString());
        model.addAttribute("listadoSemanas", semanas);
        return "usuario/verAsistenciasLideres";
    }

    @PostMapping("/filtroSemanasCreandos")
    public String filtrarPorSemanaCreandos(@RequestParam("idsemana") Integer idSemanaSeleccionada, Model model,
            HttpSession session) {
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        Integer idPrograma = (Integer) session.getAttribute("idPrograma");
        List<Asistencia> asistencias = asistenciaService.filtroLugarSemanaCreando(idLugar, idSemanaSeleccionada);
        model.addAttribute("asistencias", asistencias);
        List<Object[]> semanas = asistenciaService.obtenerSemanasUnicasCreandos(idLugar, idPrograma);
        model.addAttribute("listadoSemanas", semanas);
        model.addAttribute("idSemanaSeleccionada", idSemanaSeleccionada);
        return "usuario/verAsistenciasCreandos";
    }

    @PostMapping("/filtroSemanasLideres")
    public String filtrarPorSemanaLideres(@RequestParam("idsemana") Integer idSemanaSeleccionada, Model model,
            HttpSession session) {
        Integer idLugar = (Integer) session.getAttribute("idLugar");
        Integer idPrograma = (Integer) session.getAttribute("idPrograma");
        List<Asistencia> asistencias = asistenciaService.filtroLugarSemanaLideres(idLugar, idSemanaSeleccionada);
        model.addAttribute("asistencias", asistencias);
        List<Object[]> semanas = asistenciaService.obtenerSemanasUnicasLideres(idLugar, idPrograma);
        model.addAttribute("listadoSemanas", semanas);
        model.addAttribute("idSemanaSeleccionada", idSemanaSeleccionada);
        return "usuario/verAsistenciasLideres";
    }

}
