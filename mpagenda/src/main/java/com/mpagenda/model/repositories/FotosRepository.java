package com.mpagenda.model.repositories;

import com.mpagenda.model.entities.Fotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FotosRepository extends JpaRepository<Fotos, Long> {


    @Modifying
    @Query("update Fotos f set f.link = :link where f.id = :id")
    void updateFotos(@Param(value = "id") Long id, @Param(value = "link") String link);

}
