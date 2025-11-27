package com.regiduria.app.controller;

import com.regiduria.app.model.Participacion;
import com.regiduria.app.repository.ParticipacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participaciones")
@CrossOrigin(origins = "*")
public class ParticipacionController {

    @Autowired
    private ParticipacionRepository participacionRepository;

    @GetMapping
    public List<Participacion> listarTodas() {
        return participacionRepository.findAll();
    }

    @PostMapping
    public Participacion registrarParticipacion(@RequestBody Participacion participacion) {
        // Aquí Spring Boot espera que en el JSON le envíes el ID de la escuela y de la convocatoria
        return participacionRepository.save(participacion);
    }
    
    // Aquí podrías agregar métodos para calificar asistencia, etc.
}