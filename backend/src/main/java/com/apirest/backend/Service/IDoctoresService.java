package com.apirest.backend.Service;

import com.apirest.backend.Model.doctoresModel;
import java.util.List;
import java.util.Optional;

public interface IDoctoresService {

    // Crear un nuevo doctor
    String guardarDoctor(doctoresModel doctor);

    // Actualizar un doctor existente
    String actualizarDoctor(doctoresModel doctor);

    // Eliminar un doctor por ID
    void eliminarDoctor(String id);

    // Obtener un doctor por ID
    Optional<doctoresModel> obtenerDoctorPorId(String id);

    // Obtener todos los doctores
    List<doctoresModel> obtenerTodosLosDoctores();

    // Consultar doctores por especialidad
    List<doctoresModel> obtenerDoctoresPorEspecialidad(String especialidad);
}