package controllers;

import models.Actividade;
import models.Categoria;
import play.mvc.Controller;

import java.time.LocalDate;
import java.util.List;

public class Actividades extends Controller {

    public static void index(long id) {
        List<Actividade> actividades;

        Categoria categoria = Categoria.findById(id);
        if (categoria == null) {
            actividades = Actividade.findAll();
        } else {
            actividades = Actividade.find("categoria.id = ?1", id).fetch();
        }

        List<Categoria> categorias = Categoria.findAll();
        render(actividades, categorias);

    }

    public static void create(long id) {
        Actividade actividade = Actividade.findById(id);
        List<Categoria> categorias = Categoria.findAll();
        render(actividade, categorias);
    }

    public static void store(long id, String titulo, String data, String estado, String descricao, Long categoria) {
        Actividade actividade = Actividade.findById(id);
        Categoria categoriaModel = Categoria.findById(categoria);
        if (categoriaModel == null) {

        } else {
            if (actividade == null) {
                actividade = new Actividade(titulo, descricao, data, estado, categoriaModel);
            } else {
                actividade.setTitulo(titulo);
                actividade.setDescricao(descricao);
                actividade.setCategoria(categoriaModel);
                actividade.setData(data);
                actividade.setEstado(estado);
            }

            if (actividade.validateAndSave()) {
                flash.put("success", "Feito com sucesso");
            } else {
                flash.put("error", "Não salvou a actividade");
            }
            index(0);
        }


    }

    public static void delete(long id) {
        Actividade actividade = Actividade.findById(id);

        if (actividade != null) {
            actividade.delete();
            flash.put("success", "Actividade eliminada com sucesso");
        }

        index(0);
    }
}
