package controllers;

import models.Actividade;
import models.Categoria;
import play.mvc.Controller;

import java.time.LocalDate;
import java.util.List;

public class Actividades extends Controller {

    public static void index(){
        List<Actividade> actividades = Actividade.findAll();
render(actividades);
    }

    public static void create(long id){
        Actividade actividade = Actividade.findById(id);
        List<Categoria> categorias = Categoria.findAll();
render(actividade, categorias);
    }

    public static void store(long id, String titulo, String data, String estado, String descricao, Categoria categoria) {
        Actividade actividade = Actividade.findById(id);
        if (actividade == null){
             actividade = new Actividade(titulo, descricao, data, estado, categoria);
        }else{
            actividade.setTitulo(titulo);
            actividade.setDescricao(descricao);
            actividade.setCategoria(categoria);
            actividade.setData(data);
            actividade.setEstado(estado);
        }
        System.out.println(actividade);
        actividade.save();



        index();
    }
}
