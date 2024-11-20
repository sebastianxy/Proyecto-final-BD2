package com.apirest.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.doctoresModel;
import com.apirest.backend.Repository.IDoctoresRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctoresServiceImp implements IDoctoresService {

    @Autowired
    IDoctoresRepository doctoresRepository;

    @Override
    public String guardarDoctor(doctoresModel doctor) {
        doctoresRepository.save(doctor);
        return "El doctor con el Id " + doctor.getId() + " fue creado con éxito";
    }

    @Override
    public String actualizarDoctor(doctoresModel doctor) {
        if (doctoresRepository.existsById(doctor.getId())) {
            doctoresRepository.save(doctor);
            return "El doctor con el Id " + doctor.getId() + " fue actualizado con éxito";
        } else {
            return "Doctor no encontrado";
        }
    }

    @Override
    public void eliminarDoctor(String id) {
        doctoresRepository.deleteById(id);
    }

    @Override
    public Optional<doctoresModel> obtenerDoctorPorId(String id) {
        return doctoresRepository.findById(id);
    }

    @Override
    public List<doctoresModel> obtenerTodosLosDoctores() {
        return doctoresRepository.findAll();
    }

    @Override
    public List<doctoresModel> obtenerDoctoresPorEspecialidad(String especialidad) {
        return doctoresRepository.findByEspecialidad(especialidad);
    }
}
