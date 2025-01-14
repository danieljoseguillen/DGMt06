package com.tarea6.dgmt06e03.Servicios;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import org.springframework.stereotype.Service;

import com.tarea6.dgmt06e03.Domain.pregunta;

import jakarta.annotation.PostConstruct;
import lombok.Getter;

@Service
@Getter
public class servicios {
    private Path filePath = Paths.get("files\\preguntas.csv");
    private List<pregunta> preguntas = new ArrayList<>();
    private List<Integer> respuestas = new ArrayList<>();
    private int paso = 0;

    @PostConstruct
    public void cargarpreguntasDesdeFichero() {
        try {
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for (int i = 0; i < lines.size(); i++) {
                String[] linea = lines.get(i).split(";");
                preguntas.add(new pregunta(linea[0], Integer.parseInt(linea[1]), new String[]{linea[2],linea[3],linea[4],linea[5]}));
            }
            System.out.println("Preguntas cargadas correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo preguntas.csv: " + e.getMessage());
            e.printStackTrace();
        }
        // System.out.println(preguntas.toString());
        // System.out.println(preguntas.size());
    }

    public void newGame(){
        respuestas.clear();
        paso=0;
    }

    public boolean procesarRespuesta(int resp) {
        respuestas.add(resp);
        // System.out.println(resp);
        // System.out.println(respuestas);
        paso++;
        if (paso==preguntas.size()) {
            return true;
        }
        return false;
    }

    public pregunta enviarPregunta(){
        return preguntas.get(paso);
    }

    public int aciertos(){
        int aciertos=0;
        // System.out.println("Aciertos");
        for (int i=0;i<preguntas.size();i++) {
            pregunta question=preguntas.get(i);
            int respuesta=respuestas.get(i);
            // System.out.println(respuesta);
            if (question.responder(respuesta)==true) {
                aciertos++;
            }
        }
        return aciertos;
    }
}
