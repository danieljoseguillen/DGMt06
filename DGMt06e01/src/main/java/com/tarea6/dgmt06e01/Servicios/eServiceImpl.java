package com.tarea6.dgmt06e01.Servicios;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.tarea6.dgmt06e01.Domain.Empleado;

@Service
public class eServiceImpl implements eService{

    private List<Empleado> empRepository = new ArrayList<>();
    private long lastId=1;

    public long getLastId() {
        return lastId;
    }

    public List<Empleado> listAll() {
        return empRepository;
    }
    
    public List<Empleado> listSalarioMayor(double salario) {
        ArrayList<Empleado> listado = new ArrayList<>();
        for(Empleado emp: empRepository){
            if (emp.getSalario() >= salario) {
                listado.add(emp);
            }
        }
        return listado;
    }

    public Empleado getById(long id){
        for(Empleado emp: empRepository){
            if (emp.getId()==id) {
                return emp;
            }
        }
        return null;
    }
    public boolean agregar(Empleado empleado) {
        //empleado.setId(lastId);
        empRepository.add(empleado);
        lastId++;
        return true;
    }


    public boolean modificar(Empleado empleado) {
        int pos = empRepository.indexOf(empleado);
        if (pos==-1) {
            return false;
        }
        empRepository.set(pos, empleado);
        return true;
    }


    public boolean borrarPorId(long id) {
        for(Empleado emp: empRepository){
            if (emp.getId()==id) {
                empRepository.remove(emp);
                return true;
            }
        }
        return false;
    }
    
}
