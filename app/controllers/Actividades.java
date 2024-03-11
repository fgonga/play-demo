package controllers;

import models.Actividade;
import models.Categoria;
import play.data.validation.Required;
import play.mvc.Controller;

import java.util.List;

public class Actividades extends Controller {

    public static void index(long id) {
        List<Categoria> categorias = Categoria.findAll();
        Categoria categoria = Categoria.findById(id);
        List<Actividade> actividades = Actividade.findAll();
        long countActividades = actividades.size();
        if (categoria != null) {
            actividades = Actividade.find("categoria.id = ?1", id).fetch();
        }

        render(actividades, categorias, countActividades);

    }

    public static void create() {
        List<Categoria> categorias = Categoria.findAll();
        render(categorias);
    }

    public static void store(@Required String titulo,
                             @Required String data,
                             @Required String estado,
                             @Required String descricao,
                             @Required Long categoria) {

        //validacao de formulario
        if (validation.hasErrors()) {
            params.flash();
            validation.keep();
            create();
        }

        Categoria categoriaModel = Categoria.findById(categoria);

        Actividade actividade = new Actividade(titulo, descricao, data, estado, categoriaModel);

        if (actividade.validateAndSave()) {
            flash.put("success", "Feito com sucesso");
        } else {
            flash.put("error", "Não salvou a actividade");
        }
        index(0);

    }

    public static void edit(long id) {
        Actividade actividade = Actividade.findById(id);
        List<Categoria> categorias = Categoria.findAll();
        render(actividade, categorias);
    }

    public static void update(long id) {

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
