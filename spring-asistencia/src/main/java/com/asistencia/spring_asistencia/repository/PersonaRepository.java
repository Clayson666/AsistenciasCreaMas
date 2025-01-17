/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.repository;

import com.asistencia.spring_asistencia.model.Persona;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eulal
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
       List<Persona> findByLugarIdLugar(Integer lugarId);

       //OBTENIENDO CUENTA DE CREANDOS ACTIVOS SEA ACTIVOS O DE BAJA SEGÚN EL LUGAR
       @Query("SELECT COUNT(p) FROM Persona p WHERE p.estado.id = :idEstado AND p.lugar.idLugar= :idLugar")
       Integer contarCreandosActivosBaja(@Param("idLugar") Integer idLugar, @Param("idEstado") Integer idEstado);


      
    
}
