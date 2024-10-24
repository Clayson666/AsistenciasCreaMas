/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.repository;

import com.asistencia.spring_asistencia.model.Asistencia;

import org.springframework.data.domain.Pageable;
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
public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {

    List<Asistencia> findByPersonaLugarIdLugar(Integer id);
    @Query("SELECT a FROM Asistencia a WHERE a.persona.lugar.idLugar = :lugarId AND a.semana.idsemana = :semanaId")
    List<Asistencia> filtroLugarSemana(@Param("lugarId") Integer idLugar, @Param("semanaId") Integer idSemana);


    @Query("SELECT a.semana.idsemana FROM Asistencia a WHERE a.persona.lugar.idLugar = :lugarId ORDER BY a.semana.idsemana DESC")
    List<Integer> listaDeSemanasPorLugar(@Param("lugarId") Integer idLugar, Pageable pageable);

    
    
    @Query("SELECT DISTINCT a.semana.idsemana, a.semana.nombreSemana FROM Asistencia a ORDER BY a.semana.idsemana DESC")
    List<Object[]> obtenerSemanasUnicas();

}
