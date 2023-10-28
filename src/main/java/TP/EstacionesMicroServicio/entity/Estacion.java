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

public class Estacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Basic
    private String NOMBRE;
    @Basic
    private LocalDate FECHA_HORA_CREACION;
    @Basic
    private float LATITUD;
    @Basic
    private float LONGITUD;

    public float calcularDistancia(float longitud, float latitud){
        float distancia = (float)Math.sqrt( Math.pow(longitud - LONGITUD,2) + Math.pow(latitud - LATITUD,2) );
        return distancia;
    }


}
