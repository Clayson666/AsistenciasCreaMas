/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asistencia.spring_asistencia.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.asistencia.spring_asistencia.service.LideresService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author eulal
 */
@Controller
@RequestMapping("/persona")
public class LideresController {
    
    @Autowired
    private LideresService LideresService;
    
    @GetMapping("")
    public String verlideres(Model model){
        model.addAttribute("lideres",LideresService.findAll());
        return "persona/lideres";
    }  
    
}
