/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.repository;


import com.asistencia.spring_asistencia.model.CreandoLideres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author eulal
 */
@Repository
public interface LideresRepository extends JpaRepository<CreandoLideres, Integer> {

   @Query("SELECT c FROM CreandoLideres c WHERE c.estado.id = 1 AND c.lugar.idLugar = :lugarId")
    List<CreandoLideres> LideresActivos(@Param("lugarId") Integer lugarId);
    
    

    
    
    
    
}
