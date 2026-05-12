package dao;

import java.util.ArrayList;
import java.util.List;

import model.Produto;

public class ProdutoDAO {

    private List<Produto> produtos = new ArrayList<>();

    public void inserir(Produto produto) {

        produtos.add(produto);

    }

    public List<Produto> listar() {

        return produtos;

    }

    public Produto buscarPorId(int id) {

        for (Produto produto : produtos) {

            if (produto.getId() == id) {
                return produto;
            }

        }

        return null;
    }

    public void remover(int id) {

        Produto produto = buscarPorId(id);

        if (produto != null) {

            produtos.remove(produto);

        }

    }

}