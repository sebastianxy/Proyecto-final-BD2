package com.apirest.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BackendApplication.class);
        app.setBanner((environment, sourceClass, out) -> 
            out.println("\n=== ¡Bienvenido a la API de Clínica UAO! ===\n"));
        app.run(args);
    }

    // Configuración de transacciones para MongoDB
    @Bean
    public MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    // Inicialización de datos al iniciar la aplicación
    @Bean
    public CommandLineRunner initData() {
        return args -> {
            System.out.println("Inicializando datos...");
            // Aquí puedes insertar datos iniciales si es necesario
        };
    }
}
