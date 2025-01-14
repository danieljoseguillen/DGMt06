package com.tarea6.dgmt06e04.Servicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarea6.dgmt06e04.Configuracion.Tarifas;
import com.tarea6.dgmt06e04.Domain.Paciente;
import com.tarea6.dgmt06e04.Domain.PacienteConsulta;
import com.tarea6.dgmt06e04.Domain.PacienteDTO;
import com.tarea6.dgmt06e04.Domain.PacienteRecetas;
import com.tarea6.dgmt06e04.Domain.PacienteRevision;

@Service
public class PatientServiceImpl implements PatientService {

   @Autowired
   private Tarifas tarifas;

   LinkedList<Paciente> repositorio = new LinkedList<>();
   public void agregarPaciente(Paciente paciente) {
      repositorio.add(paciente);
   }

   public void deleteFirst() {
      if (repositorio.size() ==0) {
         throw new RuntimeException("La lista está vacía.");
      }
      repositorio.removeFirst();
   }

   public Double facturar (Paciente paciente){
      if (paciente != null) {
         return paciente.facturar(tarifas);
      }
      throw new RuntimeException("Ha ocurrido un error al procesar la factura.");
      }

   public Paciente getFirst() {
      if (repositorio.size() ==0) {
         throw new RuntimeException("La lista está vacía.");
      }
      return repositorio.getFirst();
   }

   public LinkedList<Paciente> listAll() {
      System.out.println(repositorio.size());
      return repositorio;
   }

   public Paciente buildFromDTO(PacienteDTO pacienteDTO) {
      Paciente paciente;
      switch (pacienteDTO.getTipoPaciente()) {
         case 1 -> {
            paciente = new PacienteConsulta();
            ((PacienteConsulta) paciente).setMotivo(pacienteDTO.getMotivo());
         }
         case 2 -> {
            paciente = new PacienteRecetas();
            String med1 = pacienteDTO.getMedicamentos();
            ArrayList<String> meds = new ArrayList<>(Arrays.asList(med1.split(",")));
            ((PacienteRecetas) paciente).setMedicamentos(meds);
            System.out.println(((PacienteRecetas) paciente).getMedicamentos());
         }
         case 3 -> {
            paciente = new PacienteRevision();
            ((PacienteRevision) paciente).setUltimaRevision(pacienteDTO.getUltimaRevision());
         }
         default -> {
            throw new RuntimeException("Ocurrió un error al crear el paciente.");
         }
      }
      paciente.setDni(pacienteDTO.getDni());
      paciente.setNombre(pacienteDTO.getNombre());
      paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
      System.out.println(paciente.getClass());
      return paciente;
   }

}
