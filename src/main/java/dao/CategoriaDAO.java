package dao;

import java.util.ArrayList;
import java.util.List;

import model.Categoria;

public class CategoriaDAO {

    private List<Categoria> categorias = new ArrayList<>();

    public void inserir(Categoria categoria) {

        categorias.add(categoria);

    }

    public List<Categoria> listar() {

        return categorias;

    }

    public Categoria buscarPorId(int id) {

        for (Categoria categoria : categorias) {

            if (categoria.getId() == id) {

                return categoria;

            }

        }

        return null;
    }

    public void remover(int id) {

        Categoria categoria = buscarPorId(id);

        if (categoria != null) {

            categorias.remove(categoria);

        }

    }

}