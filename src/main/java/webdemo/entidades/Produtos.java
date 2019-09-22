package webdemo.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Produtos {
    private String nome;
    private String descricao;
    private String id;
    private static long quantidade = 0;
    private static HashMap<String, Produtos> todos;

    // Active Records

    public static List<Produtos> Todos(){
        return new ArrayList<Produtos>(Produtos.todos.values());
    }


    public Produtos() {
        quantidade++;
        id = (new Long(quantidade)).toString();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
