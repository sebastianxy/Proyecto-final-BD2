package com.apirest.backend.Service;

import com.apirest.backend.Model.pacientesModel;
import java.util.List;
import java.util.Optional;

public interface IPacientesService {

    // Crear un nuevo paciente
    String guardarPaciente(pacientesModel paciente);

    // Actualizar un paciente existente
    String actualizarPaciente(pacientesModel paciente);

    // Eliminar un paciente por ID
    void eliminarPaciente(String id);

    // Obtener un paciente por ID
    Optional<pacientesModel> obtenerPacientePorId(String id);

    // Obtener todos los pacientes
    List<pacientesModel> obtenerTodosLosPacientes();

    // Consultar pacientes por rango de edad y EPS
    List<pacientesModel> obtenerPacientesPorRangoEdadYEps(int edadMin, int edadMax, String eps);

    // Cambiar prioridad de pacientes mayores de 65 años con condiciones especiales
    void actualizarPrioridadPacientesEspeciales();

    // Consultar pacientes mayores de 65 años por EPS
    List<pacientesModel> obtenerPacientesPorEpsYEdad(String eps, int edad);
}