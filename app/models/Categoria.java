package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Categoria extends Model {

    private String categoria;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Actividade> actividades;

    public Categoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Actividade> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividade> actividades) {
        this.actividades = actividades;
    }
}
