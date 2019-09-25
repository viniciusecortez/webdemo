package webdemo.controllers;

import webdemo.entidades.Produtos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
    public void create() {
        
    }

}
