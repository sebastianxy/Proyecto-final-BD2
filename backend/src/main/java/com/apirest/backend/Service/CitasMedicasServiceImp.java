package com.apirest.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Model.citasMedicasModel;
import com.apirest.backend.Repository.ICitasMedicasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CitasMedicasServiceImp implements ICitasMedicasService {

    @Autowired
    ICitasMedicasRepository citasMedicasRepository;

    @Override
    public String guardarCitaMedica(citasMedicasModel citasMedicas) {
        citasMedicasRepository.save(citasMedicas);
        return "La cita médica con el Id " + citasMedicas.getId() + " fue creada con éxito";
    }

    @Override
    public String actualizarCitaMedica(citasMedicasModel citaMedica) {
        if (citasMedicasRepository.existsById(citaMedica.getId())) {
            citasMedicasRepository.save(citaMedica);
            return "La cita médica con el Id " + citaMedica.getId() + " fue actualizada con éxito";
        } else {
            return "Cita médica no encontrada";
        }
    }

    @Override
    public void eliminarCitaMedica(String id) {
        citasMedicasRepository.deleteById(id);
    }

    @Override
    public Optional<citasMedicasModel> obtenerCitaMedicaPorId(String id) {
        return citasMedicasRepository.findById(id);
    }

    @Override
    public List<citasMedicasModel> obtenerTodasLasCitasMedicas() {
        return citasMedicasRepository.findAll();
    }

    @Override
    public List<citasMedicasModel> obtenerCitasPorIdDoctor(String idDoctor) {
        return citasMedicasRepository.findByIddoctor(idDoctor);
    }

    @Override
    public List<citasMedicasModel> obtenerCitasPorIdPaciente(String idPaciente) {
        return citasMedicasRepository.findByIdpaciente(idPaciente);
    }
}
