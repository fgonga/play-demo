package controllers;

import org.junit.*;
import play.mvc.*;
import play.test.*;
import play.libs.F.*;

public class ActividadeControllerTest extends UnitTest {
    @Test
    public void testStoreWithValidData() {
        // Defina os dados de entrada válidos
        Long id = 1L;
        String titulo = "Título da Atividade";
        String data = "2024-03-10";
        String estado = "Estado da Atividade";
        String descricao = "Descrição da Atividade";
        Long categoria = 1L;

        // Chame o método store do controlador com os dados de entrada válidos
        Response response = POST("/atividades/store?id=" + id +
                "&titulo=" + titulo +
                "&data=" + data +
                "&estado=" + estado +
                "&descricao=" + descricao +
                "&categoria=" + categoria);

        // Verifique se a resposta HTTP é 200 OK
        assertStatus(200, response);

        // Verifique se a mensagem de sucesso está presente na resposta
        assertContentMatch("Feito com sucesso", response);
    }

}
