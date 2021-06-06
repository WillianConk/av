package com.mpagenda.model.repositories;

import com.mpagenda.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Modifying
    @Query("update Usuario u set u.nomeUsuario = :nomeUsuario where u.idUsuario = :idUsuario")
    void updateUsuario(@Param(value = "idUsuario") long id, @Param(value = "nomeUsuario") String nomeUsuario);

}
