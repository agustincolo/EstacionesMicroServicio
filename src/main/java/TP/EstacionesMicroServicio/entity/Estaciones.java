package TP.EstacionesMicroServicio.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "ESTACIONES")
@NoArgsConstructor
@AllArgsConstructor

public class Estaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Basic
    private String NOMBRE;
    @Basic
    private LocalDate FECHA_HORA_CREACION;
    @Basic
    private float LATITUD;
    private float LONGITUD;


}
