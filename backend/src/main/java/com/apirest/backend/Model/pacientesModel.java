package com.apirest.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "pacientes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class pacientesModel {
    @Id
    private String id;
    
    private String nombre;
    private String apellido;
    
    private int edad;
    
    private String cedula;  // Cambiado a String para preservar el formato completo
    
    private String condicion;
    private String eps;
    private String prioridad;
    
    @Field("iddoctor")
    private ObjectId iddoctor;  // Cambiado a ObjectId para coincidir con MongoDB
}
