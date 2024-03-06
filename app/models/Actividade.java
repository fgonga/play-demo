package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Actividade extends Model {

    private String titulo;
    private String descricao;
    private String data;
    private String estado;

    public Actividade(String titulo, String descricao, String data, String estado) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.data = data;
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
