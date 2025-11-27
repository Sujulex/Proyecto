package com.regiduria.app.controller;

import com.regiduria.app.model.Aviso;
import com.regiduria.app.repository.AvisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avisos")
@CrossOrigin(origins = "*")
public class AvisoController {

    @Autowired
    private AvisoRepository avisoRepository;

    @GetMapping
    public List<Aviso> listarAvisos() {
        return avisoRepository.findAll();
    }

    @PostMapping
    public Aviso crearAviso(@RequestBody Aviso aviso) {
        return avisoRepository.save(aviso);
    }
}
