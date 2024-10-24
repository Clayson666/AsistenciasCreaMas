/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.service;

import com.asistencia.spring_asistencia.repository.AsistenciaRepository;
import com.asistencia.spring_asistencia.repository.SemanaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public int semanaActual(Integer idLugar){
        logger.info("El lugar actual es",Integer.toString(idLugar));
        int semanaActual; 
        int ultimaSemana = asistenciaService.obtenerUltimaSemana(idLugar);
        int cantidadSemanas = semanaService.conteoDeSemanas();
        logger.info("Verificando que lleguen el dato de ultima semana {} y la cantidad de semanas {}",ultimaSemana,cantidadSemanas);
        if (ultimaSemana<cantidadSemanas) {
            semanaActual = ultimaSemana+1;
        }else{
            semanaActual = 0;
        }
        logger.info("la semana actual es:{}",semanaActual);
        return semanaActual;
    }
    
    
}
