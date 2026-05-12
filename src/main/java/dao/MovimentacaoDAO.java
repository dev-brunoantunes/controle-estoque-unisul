package dao;

import java.util.ArrayList;
import java.util.List;

import model.Movimentacao;

public class MovimentacaoDAO {

    private List<Movimentacao> movimentacoes =
            new ArrayList<>();

    // Inserir
    public void inserir(Movimentacao movimentacao) {

        movimentacoes.add(movimentacao);

    }

    // Listar
    public List<Movimentacao> listar() {

        return movimentacoes;

    }

}