package com.apirest.backend.Controller;

import com.apirest.backend.Model.pacientesModel;
import com.apirest.backend.Service.IPacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class pacientesController {

    @Autowired
    private IPacientesService pacientesService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearPaciente(@RequestBody pacientesModel paciente) {
        return ResponseEntity.ok(pacientesService.guardarPaciente(paciente));
    }

    // Actualizar un paciente existente
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarPaciente(@RequestBody pacientesModel paciente) {
        return ResponseEntity.ok(pacientesService.actualizarPaciente(paciente));
    }

    // Consultar pacientes por rango de edad y EPS
    @GetMapping("/rango-edad-eps")
    public ResponseEntity<List<pacientesModel>> obtenerPacientesPorRangoEdadYEps(
            @RequestParam int edadMin, @RequestParam int edadMax, @RequestParam String eps) {
        return ResponseEntity.ok(pacientesService.obtenerPacientesPorRangoEdadYEps(edadMin, edadMax, eps));
    }

    // Actualizar prioridad para condiciones especiales
    @PutMapping("/prioridad-especial")
    public ResponseEntity<String> actualizarPrioridadPacientesEspeciales() {
        pacientesService.actualizarPrioridadPacientesEspeciales();
        return ResponseEntity.ok("Prioridad actualizada para pacientes especiales mayores de 65 años");
    }

    // Consultar pacientes mayores de 65 años en una EPS específica
    @GetMapping("/eps-mayores")
    public ResponseEntity<List<pacientesModel>> obtenerPacientesPorEpsYEdad(
            @RequestParam String eps, @RequestParam int edad) {
        return ResponseEntity.ok(pacientesService.obtenerPacientesPorEpsYEdad(eps, edad));
    }
}
