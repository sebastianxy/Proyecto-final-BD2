package com.apirest.backend.Controller;

import com.apirest.backend.Model.citasMedicasModel;
import com.apirest.backend.Service.ICitasMedicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citasMedicas")
public class citasMedicasController {

    @Autowired
    private ICitasMedicasService citasMedicasService;

    // Crear una nueva cita médica
    @PostMapping("/crear")
    public ResponseEntity<String> crearCitaMedica(@RequestBody citasMedicasModel citaMedica) {
        return ResponseEntity.ok(citasMedicasService.guardarCitaMedica(citaMedica));
    }

    // Actualizar una cita médica
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarCitaMedica(@RequestBody citasMedicasModel citaMedica) {
        return ResponseEntity.ok(citasMedicasService.actualizarCitaMedica(citaMedica));
    }

    // Consultar todas las citas médicas
    @GetMapping("/todas")
    public ResponseEntity<List<citasMedicasModel>> obtenerTodasLasCitas() {
        return ResponseEntity.ok(citasMedicasService.obtenerTodasLasCitasMedicas());
    }

    // Consultar citas médicas por doctor
    @GetMapping("/por-doctor")
    public ResponseEntity<List<citasMedicasModel>> obtenerCitasPorDoctor(@RequestParam String idDoctor) {
        return ResponseEntity.ok(citasMedicasService.obtenerCitasPorIdDoctor(idDoctor));
    }

    // Consultar citas médicas por paciente
    @GetMapping("/por-paciente")
    public ResponseEntity<List<citasMedicasModel>> obtenerCitasPorPaciente(@RequestParam String idPaciente) {
        return ResponseEntity.ok(citasMedicasService.obtenerCitasPorIdPaciente(idPaciente));
    }
}
