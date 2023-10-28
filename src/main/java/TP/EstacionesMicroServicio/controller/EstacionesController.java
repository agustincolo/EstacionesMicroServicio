package TP.EstacionesMicroServicio.controller;


import TP.EstacionesMicroServicio.entity.Estaciones;
import TP.EstacionesMicroServicio.service.EstacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstacionesController {

  @Autowired
  private EstacionesService service;

  @GetMapping("/estaciones")
  public List<Estaciones> findAllArtist(){
    return service.findAll();
  }

  @GetMapping("/estaciones/{id}")
  public Optional<Estaciones> findOneEstacion(@PathVariable int id){
    return service.findOne(id);
  }

  @PostMapping("/api/estaciones")
  public ResponseEntity<?> addArtist(@RequestBody Estaciones estaciones){
    try{
      service.create(estaciones);
      return ResponseEntity.status(201).body(estaciones);
    }catch (Exception e){
      return ResponseEntity.status(400).body(e.getMessage());
    }
  }

  @DeleteMapping("/estaciones/{id}")
  public ResponseEntity<?> deleteArtist(@PathVariable int id){
    try {
      service.deleteEstacion(id);
      return ResponseEntity.status(204).build();
    }catch (Exception e){
      return ResponseEntity.status(400).body("No se encontro el id");
    }
  }

  @PutMapping("/api/estaciones")
  public ResponseEntity<?> putArtist(@RequestBody Estaciones estaciones){
    try {
      service.modificarEstacion(estaciones);
      return ResponseEntity.status(201).build();
    }catch (Exception e){
      return ResponseEntity.status(400).body("No se logro hacer el put");
    }
  }

}
