package com.apirest.backend.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.apirest.backend.Model.citasMedicasModel;

public interface ICitasMedicasRepository extends MongoRepository<citasMedicasModel, String> {
    
    // Encontrar citas por horario específico
    List<citasMedicasModel> findByHorario(String horario);

    // Encontrar citas por consultorio
    List<citasMedicasModel> findByConsultorio(int consultorio);

    // Encontrar citas por el nombre del médico tratante
    List<citasMedicasModel> findByMedicoTratante(String medicoTratante);

    // Encontrar citas por el paciente
    List<citasMedicasModel> findByPaciente(String paciente);

    // Encontrar citas pendientes por diagnostico
    List<citasMedicasModel> findByDiagnostico(String diagnostico);
    
    // Encontrar citas por el ID del doctor
    List<citasMedicasModel> findByIddoctor(String iddoctor);

    List<citasMedicasModel> findByIdpaciente(String idpaciente);
}


