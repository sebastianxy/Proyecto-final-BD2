package com.apirest.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.bson.types.ObjectId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "citasMedicas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class citasMedicasModel {
    @Id
    private String id;
    
    private String horario;
    
    private int consultorio;
    
    private String medicoTratante;
    
    @Field("iddoctor")
    private ObjectId iddoctor;  // Cambiado a ObjectId para coincidir con MongoDB
    
    private String paciente;
    
    @Field("idpaciente")
    private ObjectId idpaciente;  // Cambiado a ObjectId para coincidir con MongoDB
    
    private String diagnostico;
}