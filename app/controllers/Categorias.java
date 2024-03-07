package controllers;

import models.Categoria;
import play.mvc.Controller;

import java.util.List;

public class Categorias extends Controller {

    public static void index() {
        List<Categoria> categorias = Categoria.findAll();
        render(categorias);
    }

    public static void create(long id) {
        Categoria categoria = Categoria.findById(id);
        render(categoria);
    }

    public static void store(long id, String categoria) {
        Categoria categoriaModel = Categoria.findById(id);
        if (categoriaModel == null) {
            categoriaModel = new Categoria(categoria);
        } else {
            categoriaModel.setCategoria(categoria);
        }

        categoriaModel.save();

        index();
    }

}
