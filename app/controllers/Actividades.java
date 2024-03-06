package controllers;

import models.Actividade;
import play.mvc.Controller;

import java.time.LocalDate;
import java.util.List;

public class Actividades extends Controller {

    public static void index(){
        List<Actividade> actividades = Actividade.findAll();
render(actividades);
    }

    public static void create(){
render();
    }

    public static void store(String titulo, String data, String estado, String descricao){
        Actividade actividade = new Actividade(titulo, descricao, data, estado);
        actividade.save();

        index();
    }
}
