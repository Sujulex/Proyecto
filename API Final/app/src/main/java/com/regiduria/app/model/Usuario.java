package com.regiduria.app.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cct_usuario", nullable = false, unique = true, length = 50)
    private String cctUsuario;

    @Column(nullable = false)
    private String password;

    @Column(name = "nombre_escuela", nullable = false, length = 100)
    private String nombreEscuela;

    @Column(name = "nombre_director", length = 100)
    private String nombreDirector;

    // Relación con Niveles Educativos
    @ManyToOne
    @JoinColumn(name = "nivel_id") 
    private NivelEducativo nivelEducativo;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @CreationTimestamp
    @Column(name = "creado_en", updatable = false)
    private LocalDateTime creadoEn;

    // Enum para el Rol (definido dentro de la clase o fuera)
    public enum Rol {
        admin, escuela
    }
}