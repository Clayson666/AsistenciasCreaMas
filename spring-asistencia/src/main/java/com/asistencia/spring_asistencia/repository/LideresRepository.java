/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.repository;

import com.asistencia.spring_asistencia.model.Creando;
import com.asistencia.spring_asistencia.model.CreandoLideres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author eulal
 */
@Repository
public interface LideresRepository extends JpaRepository<CreandoLideres, Integer> {

    List<CreandoLideres> findByLugarIdLugar(Integer lugarId);
    
    

    
    
    
    
}
