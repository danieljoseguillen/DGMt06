package com.tarea6.dgmt06e01.Servicios;

import java.util.List;

import com.tarea6.dgmt06e01.Domain.Empleado;

public interface eService {

    List<Empleado>listAll();
    List<Empleado>listSalarioMayor(double salario);
    Empleado getById(long id);
    boolean agregar(Empleado empleado);
    boolean modificar(Empleado empleado);
    boolean borrarPorId(long id);
    long getLastId();
}
