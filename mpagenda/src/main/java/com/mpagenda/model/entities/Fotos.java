package com.mpagenda.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "fotos")
public class Fotos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

    @Column(nullable = false)
    private String link;

    public Fotos() {
    }

    public Fotos(Long id, Usuario usuario, String link) {
        this.id = id;
        this.usuario = usuario;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fotos)) return false;
        Fotos fotos = (Fotos) o;
        return getId().equals(fotos.getId()) && getUsuario().equals(fotos.getUsuario()) && getLink().equals(fotos.getLink());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsuario(), getLink());
    }

    @Override
    public String toString() {
        return "Fotos{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", link='" + link + '\'' +
                '}';
    }
}
