package main;

import dao.ProdutoDAO;
import model.Categoria;
import model.Produto;

public class Principal {

    public static void main(String[] args) {

        Categoria categoria = new Categoria();

        categoria.setId(1);
        categoria.setNome("Limpeza");

        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("Detergente");
        produto.setPreco(5.99);
        produto.setQuantidade(10);
        produto.setCategoria(categoria);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        produtoDAO.inserir(produto);

        for (Produto p : produtoDAO.listar()) {

            System.out.println(p);

        }

    }

}