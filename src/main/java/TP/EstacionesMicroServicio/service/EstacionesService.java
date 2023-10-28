package TP.EstacionesMicroServicio.service;

import TP.EstacionesMicroServicio.entity.Estaciones;
import TP.EstacionesMicroServicio.repository.EstacionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstacionesService {
  @Autowired
  EstacionesRepository repository;

  public List<Estaciones> findAll() {
    return repository.findAll();
  }
  public Optional<Estaciones> findOne(int id){
    return repository.findById(id);
  }

  public Estaciones create(Estaciones estaciones){
    return repository.save(estaciones);
  }
  public void deleteEstacion(int id){
    repository.deleteById(id);
  }

  public void modificarEstacion(Estaciones estaciones){
    Estaciones estaciones_find = repository.findById(estaciones.getID()).orElse(null);
    assert estaciones_find != null;
    estaciones_find.setNOMBRE(estaciones.getNOMBRE());
    estaciones_find.setLATITUD(estaciones.getLATITUD());
    estaciones_find.setLONGITUD(estaciones.getLONGITUD());
    repository.save(estaciones_find);
  }







}
