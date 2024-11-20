package com.apirest.backend.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.apirest.backend.Model.doctoresModel;

public interface IDoctoresRepository extends MongoRepository<doctoresModel, String> {
    
    // Encontrar doctores por nombre
    List<doctoresModel> findByNombre(String nombre);

    // Encontrar doctores por apellido
    List<doctoresModel> findByApellido(String apellido);

    // Encontrar doctores por especialidad
    List<doctoresModel> findByEspecialidad(String especialidad);

    // Encontrar doctores por edad
    List<doctoresModel> findByEdad(int edad);

    // Encontrar doctores por número de cédula
    doctoresModel findByCedula(String cedula);
}

