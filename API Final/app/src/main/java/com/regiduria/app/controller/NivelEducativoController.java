package com.regiduria.app.controller;

import com.regiduria.app.model.NivelEducativo;
import com.regiduria.app.repository.NivelEducativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/niveles") // La URL será: localhost:8080/api/niveles
@CrossOrigin(origins = "*")
public class NivelEducativoController {

    @Autowired
    private NivelEducativoRepository nivelEducativoRepository;

    // 1. OBTENER TODOS LOS NIVELES (Para llenar listas desplegables)
    @GetMapping
    public List<NivelEducativo> listarNiveles() {
        return nivelEducativoRepository.findAll();
    }

    // 2. CREAR UN NIVEL (Por si necesitas agregar "Universidad" en el futuro)
    @PostMapping
    public NivelEducativo crearNivel(@RequestBody NivelEducativo nivel) {
        return nivelEducativoRepository.save(nivel);
    }
}
