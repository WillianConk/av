package com.mpagenda.controller;

import com.mpagenda.model.dto.Pesquisa;
import com.mpagenda.model.entities.Evento;
import com.mpagenda.model.entities.Fotos;
import com.mpagenda.model.entities.Usuario;
import com.mpagenda.model.service.EventoNegocios;
import com.mpagenda.model.service.FotosNegocios;
import com.mpagenda.model.service.UsuarioNegocios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller
{
    @Autowired
    private UsuarioNegocios usuarioNegocios;

    @Autowired
    private EventoNegocios eventoNegocios;

    @Autowired
    private FotosNegocios fotosNegocios;

    @GetMapping("")
    public String viewHomePage(){

        return "index";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Usuario());

        return "signup_form";
    }

//  Controller Usuario

    @PostMapping("/newUsuario")
    public String newUsuario(Usuario usuario) {
        usuarioNegocios.newUsuario(usuario);
        return "sucesso";
    }
    @PostMapping("/updateUsuario")
    @ResponseBody
    public String updateUsuario(@RequestBody Usuario usuario) {
        System.out.println("cheguei aqui");
        usuarioNegocios.updateUsuario(usuario);
        return "sucesso";
    }
    @PostMapping("/deleteUsuario")
    @ResponseBody
    public String deleteUsuario(@RequestBody Usuario usuario) {
        System.out.println("cheguei aqui");
        usuarioNegocios.deleteUsuario(usuario);
        return "sucesso";
    }

    //  Controller eventos

    @PostMapping("/selectEventosUsuario")
    @ResponseBody
    public List<Evento> selectEventos(@RequestBody Pesquisa pesquisa){

        return eventoNegocios.getAll(pesquisa.getId());
    }

    @PostMapping("/selectEventosSemelhantes")
    @ResponseBody
    public List<Evento> selectEventosSemelhantes(@RequestBody Pesquisa pesquisa){

        return eventoNegocios.selecionarSemelhantes(pesquisa.getPesquisa());
    }

    @PostMapping("/newEvento")
    @ResponseBody
    public String newEvento(@RequestBody Evento evento) {

        Usuario usuarioEvento = new Usuario();
        usuarioEvento.setIdUsuario(1L);
        usuarioEvento.setEmail("emailpostman@postman");
        usuarioEvento.setNomeUsuario("nomeusuarioevento");
        usuarioEvento.setSenha("senha");

        usuarioNegocios.updateUsuario(usuarioEvento);
        evento.setUsuario(usuarioEvento);
        eventoNegocios.newEvento(evento);
        return "sucesso";
    }

    @PostMapping("/updateEvento")
    @ResponseBody
    public String updateEvento(@RequestBody Evento evento) {
        Usuario usuarioEvento = new Usuario();
        usuarioEvento.setIdUsuario(1L);
        usuarioEvento.setEmail("emailpostman@postman");
        usuarioEvento.setNomeUsuario("nomeusuarioevento");
        usuarioEvento.setSenha("senha");
        usuarioNegocios.updateUsuario(usuarioEvento);
        eventoNegocios.updateEvento(evento);
        return "sucesso";
    }

    @PostMapping("/deleteEvento")
    @ResponseBody
    public String deleteEvento(@RequestBody Evento evento) {
        eventoNegocios.deleteEvento(evento);
        return "sucesso";
    }


  //Controller Fotos

    @PostMapping("/newFotos")
    @ResponseBody
    public String newFotos(@RequestBody Fotos fotos) {
        Usuario usuarioFotos = new Usuario();
        usuarioFotos.setIdUsuario(1L);
        usuarioFotos.setEmail("emailpostman@postman");
        usuarioFotos.setNomeUsuario("nomeusuarioevento");
        usuarioFotos.setSenha("senha");

        usuarioNegocios.updateUsuario(usuarioFotos);
        fotos.setUsuario(usuarioFotos);
        fotosNegocios.newFotos(fotos);
        return "sucesso";

    }

    @PostMapping("/updateFotos")
    @ResponseBody
    public String updateFotos (@RequestBody Fotos fotos) {
        Usuario usuarioFotos = new Usuario();
        usuarioFotos.setIdUsuario(1L);
        usuarioFotos.setEmail("emailpostman@postman");
        usuarioFotos.setNomeUsuario("nomeusuarioevento");
        usuarioFotos.setSenha("senha");
        usuarioNegocios.updateUsuario(usuarioFotos);
        fotosNegocios.updateFotos(fotos);
        return "sucesso";
    }

    @PostMapping("/deleteFotos")
    @ResponseBody
    public String deleteFotos(@RequestBody Fotos fotos) {
        fotosNegocios.deleteFotos(fotos);
        return "sucesso";
    }



}
