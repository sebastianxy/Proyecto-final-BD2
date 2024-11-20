package com.apirest.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "doctores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class doctoresModel {
    @Id
    private String id;
    
    private String nombre;
    private String apellido;
    
    private int edad;
    
    private String cedula;  // Cambiado a String para preservar formato de ID
    
    private String especialidad;
}
