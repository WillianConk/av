package com.mpagenda.model.repositories;

import com.mpagenda.model.entities.Evento;
import com.mpagenda.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Modifying
    @Query("update Evento e set e.nome_evento = :nome_evento, e.descricao = :descricao where e.id = :id")
    void updateEvento(@Param(value = "id") Long id, @Param(value = "nome_evento") String nome_evento, @Param(value = "descricao") String descricao);

    @Query("SELECT e FROM Evento e WHERE e.descricao LIKE %:pesquisa% ")
    List<Evento> findByDescricaoContaining(@Param(value = "pesquisa") String pesquisa);

    @Query("SELECT e FROM Evento e INNER JOIN Usuario u on e.usuario.idUsuario = u.idUsuario WHERE u.idUsuario = :id ")
    List<Evento> findByIdUsuario(@Param(value = "id") Long id);


}
