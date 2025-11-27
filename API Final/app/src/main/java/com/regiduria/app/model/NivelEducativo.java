package com.regiduria.app.model;

import jakarta.persistence.*;
import lombok.Data; // Lombok genera getters y setters automáticos

@Data
@Entity
@Table(name = "niveles_educativos")
public class NivelEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(name = "orden_salida", nullable = false)
    private Integer ordenSalida;

    @Column(name = "color_mapa", nullable = false, length = 20)
    private String colorMapa;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
}
