package com.tarea6.dgmt06e04.Domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.tarea6.dgmt06e04.Configuracion.Tarifas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PacienteRevision extends Paciente {
    private LocalDate ultimaRevision;

    public double facturar(Tarifas tarifas) {
        long edad = ChronoUnit.YEARS.between(this.getFechaNacimiento(), LocalDate.now());
        if (edad > 65) {
            return tarifas.getTarifaRevisionJubilado();
        } else {
            return tarifas.getTarifaRevisionAdulto();
        }
    }
}
