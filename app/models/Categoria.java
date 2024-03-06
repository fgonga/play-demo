package models;

import play.db.jpa.Model;

import javax.persistence.Entity;

@Entity
public class Categoria extends Model {
    private String categoria;

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
