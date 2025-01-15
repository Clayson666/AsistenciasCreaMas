/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.repository.AsistenciaRepository;
import com.asistencia.spring_asistencia.repository.SemanaRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author eulal
 */
@Service
public class CambioDeSemanaService {
    
   private static final Logger logger = LoggerFactory.getLogger(CambioDeSemanaService.class);
    
    @Autowired
    private AsistenciaService asistenciaService;
    
    @Autowired
    private SemanaService semanaService;
    
    public Integer semanaActual(Integer idLugar, Integer idPrograma){

        Integer ordenSemanaActual = asistenciaService.obtenerSemanasActuales(idPrograma, idLugar);
        if (ordenSemanaActual==null) {
            ordenSemanaActual = 1;
        }
        System.out.println(">>>>SEMANAS ACTUALES INGRESO A SERVIDOR DE CAMBIO Y ES :" +ordenSemanaActual);
        Integer semanaSumaActual = ordenSemanaActual+1;
        System.out.println(">>>>>>>>SEMANA SUMA ACTUALLLLLL: "+semanaSumaActual);
        Integer idSemanaActual = asistenciaService.obtenerIdSemana(idPrograma, semanaSumaActual);
        System.out.println(">>>>>>>>>>> EL ID DE LA SEMANA ACTUAL ES: "+idSemanaActual);
       // System.out.println(">>>>>>>>> EL LUGAR ES:"+idLugar+" y EL PROGRAMA ES: "+ idPrograma);
       // Integer semanaActual=8; 
       //AVERRR LA SUMA ES PARA QUE CUANDO LA ASISTENCIA SE LLENE DE "1" PASE A LA SEMANA QUE SIGUE AUN NO SE LLENA QUE ES LA 2 Y ASI CON TODOS OJALA NO TE OLVIDES ESO EMANUEEELLLLL!!!!!! 
        return idSemanaActual;
    }

    // SOLO PARA CREANDOS -  NO LIDERES
    public Integer ultimaSemanaRegistrada(Integer idLugar, Integer idPrograma){
        Integer ordenSemanaActual = asistenciaService.obtenerSemanasActuales(idPrograma, idLugar);
        if (ordenSemanaActual==null) {
            ordenSemanaActual = 1;
        }
        Integer idSemanaActual = asistenciaService.obtenerIdSemana(idPrograma, ordenSemanaActual);
        return idSemanaActual;
    }


    public int semanaActualLideres(Integer idLugar, Integer idPrograma){

        Integer ordenSemanaActual = asistenciaService.obtenerSemanasActualesLideres(idPrograma, idLugar);
        if (ordenSemanaActual==null) {
            ordenSemanaActual = 0;
        }
        System.out.println(">>>>SEMANAS ACTUALES INGRESO A SERVIDOR DE CAMBIO Y ES :" +ordenSemanaActual);
        Integer semanaSumaActual = ordenSemanaActual+1;
        System.out.println(">>>>>>>>SEMANA SUMA ACTUALLLLLL: "+semanaSumaActual);
        Integer idSemanaActual = asistenciaService.obtenerIdSemana(idPrograma, semanaSumaActual);
        System.out.println(">>>>>>>>>>> EL ID DE LA SEMANA ACTUAL ES: "+idSemanaActual);
       // System.out.println(">>>>>>>>> EL LUGAR ES:"+idLugar+" y EL PROGRAMA ES: "+ idPrograma);
       // Integer semanaActual=8; 
       //AVERRR LA SUMA ES PARA QUE CUANDO LA ASISTENCIA SE LLENE DE "1" PASE A LA SEMANA QUE SIGUE AUN NO SE LLENA QUE ES LA 2 Y ASI CON TODOS OJALA NO TE OLVIDES ESO EMANUEEELLLLL!!!!!! 
        return idSemanaActual;
    }
    
    //ESTO ES PARA LIDERESSSS
    public Integer ultimaSemanaRegistradaLideres(Integer idLugar, Integer idPrograma){
        Integer ordenSemanaActual = asistenciaService.obtenerSemanasActualesLideres(idPrograma, idLugar);
        if (ordenSemanaActual==null) {
            ordenSemanaActual = 1;
        }
        Integer idSemanaActual = asistenciaService.obtenerIdSemana(idPrograma, ordenSemanaActual);
        return idSemanaActual;
    }
    
}
