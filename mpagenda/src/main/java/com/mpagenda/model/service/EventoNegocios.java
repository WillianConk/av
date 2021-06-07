package com.mpagenda.model.service;

import com.mpagenda.model.entities.Evento;
import com.mpagenda.model.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Configuration
public class EventoNegocios {

    @Autowired
    private EventoRepository eventoRepository;

    public void newEvento(Evento evento) {
        try {
            eventoRepository.save(evento);

            System.out.println("Evento salvo");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Transactional
    public void updateEvento(Evento evento){
        try {
            Long idEvento = evento.getId();
            String nome_evento = evento.getNome_evento();
            String descricao = evento.getDescricao();
            eventoRepository.updateEvento(idEvento, nome_evento, descricao);

            System.out.println("Evento atualizado");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteEvento(Evento evento){
        try {
            eventoRepository.deleteById(evento.getId());

            System.out.println("Evento excluido");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public List<Evento> getAll(Long id){

        List<Evento> lista = eventoRepository.findByIdUsuario(id);
        return lista;


    }

    public List<Evento> selecionarSemelhantes(String pesquisa){

        List<Evento> lista = eventoRepository.findByDescricaoContaining(pesquisa);
        return lista;


    }
}
