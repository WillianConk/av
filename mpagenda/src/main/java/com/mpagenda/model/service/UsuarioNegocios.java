package com.mpagenda.model.service;

import com.mpagenda.model.entities.Usuario;
import com.mpagenda.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;


@Configuration
public class UsuarioNegocios {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void newUsuario(Usuario usuario){
        try {
            usuarioRepository.save(usuario);

            System.out.println("usuario salvo");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Transactional
    public void updateUsuario(Usuario usuario){
        try {
            Long idUsuario = usuario.getIdUsuario();
            String nomeUsuario = usuario.getNomeUsuario();
            usuarioRepository.updateUsuario(idUsuario, nomeUsuario);

            System.out.println("usuario atualizado");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteUsuario(Usuario usuario){
        try {
            usuarioRepository.deleteById(usuario.getIdUsuario());

            System.out.println("usuario excluido");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
