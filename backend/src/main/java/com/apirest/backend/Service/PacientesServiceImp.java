package com.apirest.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.pacientesModel;
import com.apirest.backend.Repository.IPacientesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PacientesServiceImp implements IPacientesService {

    @Autowired
    IPacientesRepository pacientesRepository;

    @Override
    public String guardarPaciente(pacientesModel paciente) {
        pacientesRepository.save(paciente);
        return "El paciente con el Id " + paciente.getId() + " fue creado con éxito";
    }

    @Override
    public String actualizarPaciente(pacientesModel paciente) {
        if (pacientesRepository.existsById(paciente.getId())) {
            pacientesRepository.save(paciente);
            return "El paciente con el Id " + paciente.getId() + " fue actualizado con éxito";
        } else {
            return "Paciente no encontrado";
        }
    }

    @Override
    public void eliminarPaciente(String id) {
        pacientesRepository.deleteById(id);
    }

    @Override
    public Optional<pacientesModel> obtenerPacientePorId(String id) {
        return pacientesRepository.findById(id);
    }

    @Override
    public List<pacientesModel> obtenerTodosLosPacientes() {
        return pacientesRepository.findAll();
    }

    @Override
    public List<pacientesModel> obtenerPacientesPorRangoEdadYEps(int edadMin, int edadMax, String eps) {
        return pacientesRepository.findByEdadBetweenAndEps(edadMin, edadMax, eps);
    }

    @Override
    public void actualizarPrioridadPacientesEspeciales() {
        List<pacientesModel> pacientes = pacientesRepository.findByEdadGreaterThanAndCondicionIn(
                65, List.of("hipertension", "diabetes", "cancer")
        );
        for (pacientesModel paciente : pacientes) {
            paciente.setPrioridad("Alta");
            pacientesRepository.save(paciente);
        }
    }

    @Override
    public List<pacientesModel> obtenerPacientesPorEpsYEdad(String eps, int edad) {
        return pacientesRepository.findByEpsAndEdadGreaterThan(eps, edad);
    }
}
