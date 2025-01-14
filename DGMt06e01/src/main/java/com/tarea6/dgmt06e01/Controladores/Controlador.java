package com.tarea6.dgmt06e01.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tarea6.dgmt06e01.Domain.Empleado;
import com.tarea6.dgmt06e01.Servicios.eService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Controlador {

    @Autowired
    private eService servicio;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("empleados", servicio.listAll());
        return "indexView";
    }

    @GetMapping("/info/{id}")
    public String getInfo(@PathVariable long id, Model model) {
        model.addAttribute("empleado", servicio.getById(id));
        return "infoView";
    }

    @GetMapping("/edit/{id}")
    public String getEdit(@PathVariable long id, Model model) {
        model.addAttribute("empForm", servicio.getById(id));
        return "editView";
    }

    @PostMapping("/edit/submit")
    public String postedit(Empleado empform) {
        servicio.modificar(empform);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String getAdd(Model model) {
        model.addAttribute("empForm", new Empleado());
        model.addAttribute("id1", servicio.getLastId());
        return "addView";
    }

    @PostMapping("/add/submit")
    public String postAdd(Empleado empform) {
        servicio.agregar(empform);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String getMethodName(@PathVariable long id) {
        servicio.borrarPorId(id);
        return "redirect:/";
    }
}
