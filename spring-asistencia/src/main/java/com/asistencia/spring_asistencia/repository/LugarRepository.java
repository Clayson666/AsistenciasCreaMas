/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.repository;

import com.asistencia.spring_asistencia.model.Lugar;

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
public interface LugarRepository extends JpaRepository<Lugar, Integer>{

    @Query("SELECT l FROM Lugar l WHERE l.programa.idprograma=:idPrograma")
    List<Lugar> lugarPorPrograma(@Param("idPrograma") Integer idPrograma);
    
}
