package controllers;

import models.Categoria;
import play.mvc.Controller;

import java.util.List;

public class Categorias extends Controller {

    public static void index(){
        List<Categoria> categorias = Categoria.findAll();
render(categorias);
    }

}
