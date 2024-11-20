package com.apirest.backend.Service;

import com.apirest.backend.Model.citasMedicasModel;
import java.util.List;
import java.util.Optional;

public interface ICitasMedicasService {

    // Crear una nueva cita médica
    String guardarCitaMedica(citasMedicasModel citaMedica);

    // Actualizar una cita médica
    String actualizarCitaMedica(citasMedicasModel citaMedica);

    // Eliminar una cita médica por ID
    void eliminarCitaMedica(String id);

    // Obtener una cita médica por ID
    Optional<citasMedicasModel> obtenerCitaMedicaPorId(String id);

    // Obtener todas las citas médicas
    List<citasMedicasModel> obtenerTodasLasCitasMedicas();

    // Consultar citas por ID del doctor
    List<citasMedicasModel> obtenerCitasPorIdDoctor(String idDoctor);

    // Consultar citas por ID del paciente
    List<citasMedicasModel> obtenerCitasPorIdPaciente(String idPaciente);
}