/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.repository;

import com.asistencia.spring_asistencia.model.Semana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eulal
 */

@Repository
public interface SemanaRepository extends JpaRepository<Semana, Integer>{
    
    @Query("SELECT count(s) FROM Semana s WHERE s.programa.idprograma = : idPrograma")
    int conteo(@Param("idPrograma") Integer idPrograma);
    
    
}
