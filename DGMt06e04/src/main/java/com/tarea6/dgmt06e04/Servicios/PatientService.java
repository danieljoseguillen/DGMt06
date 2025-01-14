package com.tarea6.dgmt06e04.Servicios;

import java.util.List;

import com.tarea6.dgmt06e04.Domain.Paciente;
import com.tarea6.dgmt06e04.Domain.PacienteDTO;

public interface PatientService {
    void agregarPaciente(Paciente paciente);
    void deleteFirst();
    Paciente getFirst();
    List<Paciente> listAll();
    Paciente buildFromDTO(PacienteDTO pacienteDTO);
    Double facturar (Paciente paciente);
}
