package com.tarea6.dgmt06e04.Domain;

import com.tarea6.dgmt06e04.Configuracion.Tarifas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PacienteConsulta extends Paciente {
    private String motivo;

    public double facturar(Tarifas tarifas) {
        return tarifas.getTarifaConsulta();
    }
}
