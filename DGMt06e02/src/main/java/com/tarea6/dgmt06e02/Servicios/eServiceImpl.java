package com.tarea6.dgmt06e02.Servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

import com.tarea6.dgmt06e02.Domain.Empleado;
import com.tarea6.dgmt06e02.Modelos.Genero;

@Service
public class eServiceImpl implements eService {

    private List<Empleado> empRepository = new ArrayList<>();
    private long lastId = 1;

    public long getLastId() {
        return lastId;
    }

    public List<Empleado> listAll() {
        return empRepository;
    }

    public List<Empleado> listSorted(String val) {
        List<Empleado> empSorted = new ArrayList<>();
        for (Empleado empleado : empRepository) {
            if (empleado.getNombre().toLowerCase().contains(val.toLowerCase())) {
                empSorted.add(empleado);
            }
        }
        return empSorted;
    }

    public List<Empleado> listGender(Genero genero) {
        List<Empleado> empSorted = new ArrayList<>();
        for (Empleado empleado : empRepository) {
            if (empleado.getGenero()==genero) {
                empSorted.add(empleado);
            }
        }
        return empSorted;
    }

    public Empleado getById(long id) {
        for (Empleado emp : empRepository) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        throw new RuntimeException("No se encontraron empleados con la ID indicada.");
    }

    public boolean agregar(Empleado empleado) {
        // empleado.setId(lastId);
        boolean agr = empRepository.add(empleado);
        if (agr != true) {
            throw new RuntimeException("No se pudo agregar el empleado.");
        }
        lastId++;
        Collections.sort(empRepository, Comparator.comparing(Empleado::getNombre));
        return true;
    }

    public boolean modificar(Empleado empleado) {
        int pos = empRepository.indexOf(empleado);
        if (pos == -1) {
            throw new RuntimeException("No se encontró el empleado a editar.");
        }
        empRepository.set(pos, empleado);
        return true;
    }

    public boolean borrarPorId(long id) {
        for (Empleado emp : empRepository) {
            if (emp.getId() == id) {
                empRepository.remove(emp);
                return true;
            }
        }
        throw new RuntimeException("No se pudo borrar el empleado.");
    }

}
