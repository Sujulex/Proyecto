package com.regiduria.app.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "convocatorias")
public class Convocatoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(name = "tipo_evento", nullable = false, length = 50)
    private String tipoEvento;

    @Column(name = "fecha_evento", nullable = false)
    private LocalDate fechaEvento; // Solo fecha (YYYY-MM-DD)

    @Column(name = "hora_reunion", nullable = false)
    private LocalTime horaReunion; // Solo hora (HH:MM:SS)

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "archivo_pdf")
    private String archivoPdf;

    @Enumerated(EnumType.STRING)
    private Estado estado; // Usamos el Enum de abajo

    @CreationTimestamp
    @Column(name = "creado_en", updatable = false)
    private LocalDateTime creadoEn;

    // Enum para el estado de la convocatoria
    public enum Estado {
        activa, cerrada, finalizada
    }
}
