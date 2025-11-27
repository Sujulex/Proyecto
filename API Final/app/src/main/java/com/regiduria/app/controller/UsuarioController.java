package com.regiduria.app.controller;

import com.regiduria.app.model.Usuario;
import com.regiduria.app.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier frontend
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // 1. OBTENER TODOS LOS USUARIOS
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // 2. OBTENER UN USUARIO POR ID (Aquí tuviste el problema antes)
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Integer id) {
        return usuarioRepository.findById(id)
                .map(usuario -> ResponseEntity.ok().body(usuario)) // Si existe, devuelve 200 OK
                .orElse(ResponseEntity.notFound().build());        // Si no existe, devuelve 404 Not Found
    }

    // 3. CREAR UN USUARIO NUEVO
    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // 4. ACTUALIZAR USUARIO
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Integer id, @RequestBody Usuario datosActualizados) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNombreEscuela(datosActualizados.getNombreEscuela());
                    usuario.setNombreDirector(datosActualizados.getNombreDirector());
                    usuario.setCctUsuario(datosActualizados.getCctUsuario());
                    // Actualiza el resto de campos necesarios...
                    Usuario actualizado = usuarioRepository.save(usuario);
                    return ResponseEntity.ok().body(actualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    // 5. ELIMINAR USUARIO (Usar con cuidado)
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Integer id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
