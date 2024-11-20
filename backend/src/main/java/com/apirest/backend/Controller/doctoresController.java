package com.apirest.backend.Controller;

import com.apirest.backend.Model.doctoresModel;
import com.apirest.backend.Service.IDoctoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctores")
public class doctoresController {

    @Autowired
    private IDoctoresService doctoresService;

    // Crear un nuevo doctor
    @PostMapping("/crear")
    public ResponseEntity<String> crearDoctor(@RequestBody doctoresModel doctor) {
        return ResponseEntity.ok(doctoresService.guardarDoctor(doctor));
    }

    // Actualizar un doctor existente
    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarDoctor(@RequestBody doctoresModel doctor) {
        return ResponseEntity.ok(doctoresService.actualizarDoctor(doctor));
    }

    // Consultar todos los doctores
    @GetMapping("/todos")
    public ResponseEntity<List<doctoresModel>> obtenerTodosLosDoctores() {
        return ResponseEntity.ok(doctoresService.obtenerTodosLosDoctores());
    }

    // Consultar doctores por especialidad
    @GetMapping("/especialidad")
    public ResponseEntity<List<doctoresModel>> obtenerDoctoresPorEspecialidad(@RequestParam String especialidad) {
        return ResponseEntity.ok(doctoresService.obtenerDoctoresPorEspecialidad(especialidad));
    }
}
