package com.tarea6.dgmt06e04.Domain;

import java.util.ArrayList;

import com.tarea6.dgmt06e04.Configuracion.Tarifas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PacienteRecetas extends Paciente {
    private ArrayList<String> medicamentos;

    public double facturar(Tarifas tarifas) {
        return tarifas.getTarifaReceta()*medicamentos.size();
    }
}
