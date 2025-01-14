package com.tarea6.dgmt06e03.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.tarea6.dgmt06e03.Domain.quizDTO;
import com.tarea6.dgmt06e03.Servicios.servicios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controlador {
    @Autowired
    private servicios servicio;

    @GetMapping({ "/", "/home" })
    public String getMain(Model model) {
        return "indexView";
    }

    @GetMapping("/newGame")
    public String getNewGame(Model model) {
        try {
            servicio.newGame();
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "errorView";
        }
        return "redirect:/game";
    }

    @GetMapping("/game")
    public String getGameGoing(Model model) {
        try {
            model.addAttribute("question", servicio.enviarPregunta());
            model.addAttribute("numero", servicio.getPaso());
            model.addAttribute("formQuestion", new quizDTO());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "errorView";
        }
        return "gameView";
    }

    @PostMapping("/game/answer")
    public String postAnswer(quizDTO quiz, Model model) {
        try {
            boolean procesado = servicio.procesarRespuesta(quiz.getRespuesta());
            if (procesado) {
                return "redirect:/gameOver";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "errorView";
        }
        return "redirect:/game";
    }

    @GetMapping("/gameOver")
    public String getToTheEndGame(Model model) {
        try {
            model.addAttribute("aciertos", servicio.aciertos());
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "errorView";
        }
        return "gameOverView"; // haha game overview
    }

}
