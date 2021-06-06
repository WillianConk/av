package com.mpagenda.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome_evento;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;

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

    public String getNome_evento() {
        return nome_evento;
    }

    public void setNome_evento(String nome_evento) {
        this.nome_evento = nome_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evento)) return false;
        Evento evento = (Evento) o;
        return getId().equals(evento.getId()) && getUsuario().equals(evento.getUsuario()) && getNome_evento().equals(evento.getNome_evento()) && getDescricao().equals(evento.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsuario(), getNome_evento(), getDescricao());
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", nome_evento='" + nome_evento + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
