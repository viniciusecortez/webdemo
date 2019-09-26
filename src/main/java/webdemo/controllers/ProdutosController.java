package webdemo.controllers;

import webdemo.entidades.Produtos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class ProdutosController extends Controller{
    public ProdutosController(HttpServletRequest req, HttpServletResponse resp){
        super(req, resp);
    }
    @Override
    public void list() throws ServletException, IOException {
        try{
        List<Produtos> produtos = Produtos.Todos();
        getRequest().setAttribute("Produtos", produtos);

        }catch (NullPointerException ex){

        }
        getRequest().getRequestDispatcher("/WEB-INF/templates/produtos/list.jsp").forward(getRequest(), getResponse());
    }
    @Override
    public void create() throws ServletException, IOException {
        getRequest().getRequestDispatcher("/WEB-INF/templates/produtos/criar.jsp")
                .forward(getRequest(), getResponse());
    }

    @Override
    public void create(Map<String, String> formData) throws IOException, ServletException {
        if(isValid(formData)) {
            String nome = formData.get("nome");
            String descricao = formData.get("descricao");

            Produtos produtos = new Produtos();
            produtos.setNome(nome);
            produtos.setDescricao(descricao);


            getResponse().sendRedirect("/produtos?success=true");
        }else {
            getRequest()
                    .getRequestDispatcher("/WEB-INF/templates/produtos/criar.jsp?success=false")
                    .forward(getRequest(), getResponse());
        }
    }


    private boolean isValid(Map<String, String> formData) throws UnsupportedEncodingException {
        boolean isValid = true;

        if(!formData.containsKey("nome") || formData.get("nome").isEmpty()) {
            getRequest().setAttribute("NomeInvalido", "O nome é obrigatório!");
            isValid = false;
        }

        if(!formData.containsKey("descricao") || formData.get("descriacao").isEmpty()) {
            getRequest().setAttribute("descricaoInvalido", "A descriçao é obrigatório!");
            isValid = false;
        }

        return isValid;
    }

}
