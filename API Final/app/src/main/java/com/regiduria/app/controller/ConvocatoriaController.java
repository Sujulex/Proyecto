package com.regiduria.app.controller;

import com.regiduria.app.model.Convocatoria;
import com.regiduria.app.repository.ConvocatoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/convocatorias")
@CrossOrigin(origins = "*")
public class ConvocatoriaController {

    @Autowired
    private ConvocatoriaRepository convocatoriaRepository;

    @GetMapping
    public List<Convocatoria> listarConvocatorias() {
        return convocatoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Convocatoria> obtenerConvocatoria(@PathVariable Integer id) {
        return convocatoriaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Convocatoria crearConvocatoria(@RequestBody Convocatoria convocatoria) {
        return convocatoriaRepository.save(convocatoria);
    }

    // Endpoint para cambiar el estado (ej. de 'activa' a 'cerrada')
    @PutMapping("/{id}/estado")
    public ResponseEntity<Convocatoria> cambiarEstado(@PathVariable Integer id, @RequestParam Convocatoria.Estado nuevoEstado) {
        return convocatoriaRepository.findById(id)
            .map(convocatoria -> {
                convocatoria.setEstado(nuevoEstado);
                return ResponseEntity.ok(convocatoriaRepository.save(convocatoria));
            })
            .orElse(ResponseEntity.notFound().build());
    }
}