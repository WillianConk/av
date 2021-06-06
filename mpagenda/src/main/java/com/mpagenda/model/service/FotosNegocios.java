package com.mpagenda.model.service;

import com.mpagenda.model.entities.Fotos;
import com.mpagenda.model.repositories.FotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;


@Configuration
public class FotosNegocios {

    @Autowired
    private FotosRepository fotosRepository;

    //dados do fotos devem ser substituidos pelo fotos da sessão


    public void newFotos(Fotos fotos){
        try {
            fotosRepository.save(fotos);
            System.out.println("Foto salva");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Transactional
    public void updateFotos(Fotos fotos){
        try {
            Long id = fotos.getId();
            String link = fotos.getLink();
            fotosRepository.updateFotos(id, link);

            System.out.println("fotos atualizado");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteFotos(Fotos fotos){
        try {
            fotosRepository.deleteById(fotos.getId());

            System.out.println("Foto excluida");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
