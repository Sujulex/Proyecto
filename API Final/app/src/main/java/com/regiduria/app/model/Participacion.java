package com.regiduria.app.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "participaciones")
public class Participacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación con Convocatoria
    @ManyToOne
    @JoinColumn(name = "convocatoria_id", nullable = false)
    private Convocatoria convocatoria;

    // Relación con Usuario (Escuela)
    @ManyToOne
    @JoinColumn(name = "escuela_id", nullable = false)
    private Usuario escuela;

    @Column(name = "director_responsable", length = 100)
    private String directorResponsable;

    @Column(name = "maestros_acompanantes", columnDefinition = "TEXT")
    private String maestrosAcompanantes;

    @Column(name = "num_grupos")
    private Integer numGrupos;

    @Column(name = "alumnos_programados")
    private Integer alumnosProgramados;

    @Column(name = "alumnos_reales")
    private Integer alumnosReales;

    @Column(name = "resena_historica")
    private String resenaHistorica; // Ruta del archivo

    @Column(name = "orden_asignado")
    private Integer ordenAsignado;

    @CreationTimestamp
    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;
}
