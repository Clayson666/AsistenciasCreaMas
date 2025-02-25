/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.asistencia.spring_asistencia.repository;


import com.asistencia.spring_asistencia.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eulal
 */
@Repository
public interface ProgramaRepository extends JpaRepository<Programa,Integer>{

    @Query("SELECT p FROM Programa p WHERE p.idprograma = :idPrograma AND p.contrasena = :contrasena")
    Programa validarContrasena(@Param("idPrograma") Integer idPrograma, @Param("contrasena") String contrasena);
    
}
