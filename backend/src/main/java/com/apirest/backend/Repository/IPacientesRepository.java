package com.apirest.backend.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.apirest.backend.Model.pacientesModel;

public interface IPacientesRepository extends MongoRepository<pacientesModel, String> {
    
    // Encontrar pacientes por nombre
    List<pacientesModel> findByNombre(String nombre);

    // Encontrar pacientes por apellido
    List<pacientesModel> findByApellido(String apellido);

    // Encontrar pacientes por condición
    List<pacientesModel> findByCondicion(String condicion);

    // Encontrar pacientes por prioridad (alta, media, baja)
    List<pacientesModel> findByPrioridad(String prioridad);

    // Encontrar pacientes por EPS
    List<pacientesModel> findByEps(String eps);

    // Encontrar pacientes por ID del doctor asignado
    List<pacientesModel> findByIddoctor(String iddoctor);

    // Encontrar pacientes en un rango de edad y adscritos a una EPS específica
    @Query("{ 'edad': { $gte: ?0, $lte: ?1 }, 'eps': ?2 }")
    List<pacientesModel> findByEdadBetweenAndEps(int edadMin, int edadMax, String eps);

    // Encontrar pacientes mayores de una edad y con condiciones específicas
    @Query("{ 'edad': { $gt: ?0 }, 'condicion': { $in: ?1 } }")
    List<pacientesModel> findByEdadGreaterThanAndCondicionIn(int edad, List<String> condiciones);

    // Encontrar pacientes adscritos a una EPS y mayores de una edad
    @Query("{ 'eps': ?0, 'edad': { $gt: ?1 } }")
    List<pacientesModel> findByEpsAndEdadGreaterThan(String eps, int edad);
}
