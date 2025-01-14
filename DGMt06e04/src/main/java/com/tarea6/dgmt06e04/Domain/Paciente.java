package com.tarea6.dgmt06e04.Domain;

import java.time.LocalDate;

import com.tarea6.dgmt06e04.Configuracion.Tarifas;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "dni")
public abstract class Paciente {
    @NotEmpty
    @NotNull
    private String dni, nombre;
    private LocalDate fechaNacimiento;

    public abstract double facturar(Tarifas tarifas);

}
