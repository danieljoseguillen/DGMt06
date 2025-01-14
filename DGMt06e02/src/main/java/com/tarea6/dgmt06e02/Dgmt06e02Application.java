package com.tarea6.dgmt06e02;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tarea6.dgmt06e02.Domain.Empleado;
import com.tarea6.dgmt06e02.Modelos.Estado;
import com.tarea6.dgmt06e02.Modelos.Genero;
import com.tarea6.dgmt06e02.Servicios.eService;

@SpringBootApplication
public class Dgmt06e02Application {

	public static void main(String[] args) {
		SpringApplication.run(Dgmt06e02Application.class, args);
	}

	@Bean
	CommandLineRunner initData(eService servicio){
		return args -> {
			servicio.agregar(new Empleado(1l,"Jose","Jose@gmail.com",30000d,Estado.ACTIVO,Genero.MASCULINO));
			servicio.agregar(new Empleado(2l,"Pedro","pedrog@gmail.com",32000d,Estado.ACTIVO,Genero.MASCULINO));
			servicio.agregar(new Empleado(3l,"Maria","mcarolina@gmail.com",35000d,Estado.INACTIVO,Genero.FEMENINO));
		};
	}
}
