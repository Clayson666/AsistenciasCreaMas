/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.repository;

import com.asistencia.spring_asistencia.model.Creando;
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
public interface CreandoRepository extends JpaRepository<Creando, Integer>{
    @Query("SELECT c FROM Creando c WHERE c.estado.id = 1 AND c.lugar.idLugar = :lugarId")
    List<Creando> CreandosActivos(@Param("lugarId") Integer lugarId);

    
}
