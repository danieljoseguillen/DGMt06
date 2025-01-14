package com.tarea6.dgmt06e03.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pregunta {
    private String pregunta;
    private int respuesta;
    private String[] opciones;

    public boolean responder(int resp){
        if (respuesta==resp) {
            return true;
        }
        return false;
    }

}
