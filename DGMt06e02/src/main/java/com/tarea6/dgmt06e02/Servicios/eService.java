package com.tarea6.dgmt06e02.Servicios;

import java.util.List;

import com.tarea6.dgmt06e02.Domain.Empleado;
import com.tarea6.dgmt06e02.Modelos.Genero;

public interface eService {

    List<Empleado>listAll();
    List<Empleado>listSorted(String val);
    List<Empleado>listGender(Genero genero);
    Empleado getById(long id);
    boolean agregar(Empleado empleado);
    boolean modificar(Empleado empleado);
    boolean borrarPorId(long id);
    long getLastId();
}
