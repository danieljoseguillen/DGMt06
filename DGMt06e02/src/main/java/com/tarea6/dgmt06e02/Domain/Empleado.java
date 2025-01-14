package com.tarea6.dgmt06e02.Domain;

import com.tarea6.dgmt06e02.Modelos.Estado;
import com.tarea6.dgmt06e02.Modelos.Genero;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Empleado {

    private long id;

    @Size(min = 3)
    @NotEmpty
    @NotNull
    private String nombre;

    @Email
    @NotEmpty
    @NotNull
    private String correo;

    @Min(18000)
    @NotNull
    private double salario;
    
    @NotNull
    private Estado estado;

    private Genero genero;
}
