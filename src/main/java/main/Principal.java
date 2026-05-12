package main;

import java.time.LocalDate;

import dao.CategoriaDAO;
import dao.MovimentacaoDAO;
import dao.ProdutoDAO;

import model.Categoria;
import model.Movimentacao;
import model.Produto;
import model.TipoMovimentacao;

public class Principal {

    public static void main(String[] args) {

        // ==========================================
        // DAOS
        // ==========================================

        ProdutoDAO produtoDAO =
                new ProdutoDAO();

        CategoriaDAO categoriaDAO =
                new CategoriaDAO();

        MovimentacaoDAO movimentacaoDAO =
                new MovimentacaoDAO();

        // ==========================================
        // CATEGORIA
        // ==========================================

        Categoria categoria = new Categoria();

        categoria.setId(1);
        categoria.setNome("Mercado");
        categoria.setTamanho("Médio");
        categoria.setEmbalagem("Plástico");

        categoriaDAO.inserir(categoria);

        // ==========================================
        // PRODUTO 1
        // ==========================================

        Produto detergente = new Produto();

        detergente.setId(1);
        detergente.setNome("Detergente");
        detergente.setPreco(5.99);
        detergente.setUnidade("UN");
        detergente.setQuantidade(10);
        detergente.setQuantidadeMinima(5);
        detergente.setQuantidadeMaxima(50);
        detergente.setCategoria(categoria);

        produtoDAO.inserir(detergente);

        // ==========================================
        // PRODUTO 2
        // ==========================================

        Produto arroz = new Produto();

        arroz.setId(2);
        arroz.setNome("Arroz");
        arroz.setPreco(30.0);
        arroz.setUnidade("KG");
        arroz.setQuantidade(8);
        arroz.setQuantidadeMinima(10);
        arroz.setQuantidadeMaxima(100);
        arroz.setCategoria(categoria);

        produtoDAO.inserir(arroz);

        // ==========================================
        // PRODUTO 3
        // ==========================================

        Produto oleo = new Produto();

        oleo.setId(3);
        oleo.setNome("Oleo");
        oleo.setPreco(12.5);
        oleo.setUnidade("UN");
        oleo.setQuantidade(120);
        oleo.setQuantidadeMinima(10);
        oleo.setQuantidadeMaxima(100);
        oleo.setCategoria(categoria);

        produtoDAO.inserir(oleo);

        // ==========================================
        // PRODUTO 4
        // ==========================================

        Produto feijao = new Produto();

        feijao.setId(4);
        feijao.setNome("Feijao");
        feijao.setPreco(9.99);
        feijao.setUnidade("KG");
        feijao.setQuantidade(40);
        feijao.setQuantidadeMinima(5);
        feijao.setQuantidadeMaxima(50);
        feijao.setCategoria(categoria);

        produtoDAO.inserir(feijao);

        // ==========================================
        // MOVIMENTAÇÃO 1
        // ==========================================

        detergente.entradaEstoque(20);

        Movimentacao entrada1 =
                new Movimentacao();

        entrada1.setId(1);
        entrada1.setProduto(detergente);
        entrada1.setQuantidade(20);
        entrada1.setTipo(
                TipoMovimentacao.ENTRADA
        );
        entrada1.setData(LocalDate.now());

        movimentacaoDAO.inserir(entrada1);

        // ==========================================
        // MOVIMENTAÇÃO 2
        // ==========================================

        boolean sucesso1 =
                feijao.saidaEstoque(38);

        if (sucesso1) {

            Movimentacao saida1 =
                    new Movimentacao();

            saida1.setId(2);
            saida1.setProduto(feijao);
            saida1.setQuantidade(38);
            saida1.setTipo(
                    TipoMovimentacao.SAIDA
            );
            saida1.setData(LocalDate.now());

            movimentacaoDAO.inserir(saida1);

        }

        // ==========================================
        // MOVIMENTAÇÃO 3
        // ==========================================

        arroz.entradaEstoque(20);

        Movimentacao entrada2 =
                new Movimentacao();

        entrada2.setId(3);
        entrada2.setProduto(arroz);
        entrada2.setQuantidade(20);
        entrada2.setTipo(
                TipoMovimentacao.ENTRADA
        );
        entrada2.setData(LocalDate.now());

        movimentacaoDAO.inserir(entrada2);

        // ==========================================
        // TESTE ERRO ESTOQUE
        // ==========================================

        boolean sucesso2 =
                arroz.saidaEstoque(500);

        System.out.println(
                "\nTentativa de saida grande:"
        );

        System.out.println(sucesso2);

        // ==========================================
        // LISTAR PRODUTOS
        // ==========================================

        System.out.println(
                "\n===== PRODUTOS ====="
        );

        for (Produto p :
                produtoDAO.listar()) {

            System.out.println(p);

        }

        // ==========================================
        // LISTAR MOVIMENTAÇÕES
        // ==========================================

        System.out.println(
                "\n===== MOVIMENTACOES ====="
        );

        for (Movimentacao m :
                movimentacaoDAO.listar()) {

            System.out.println(m);

        }

        // ==========================================
        // ALERTAS
        // ==========================================

        System.out.println(
                "\n===== ALERTAS ====="
        );

        for (Produto p :
                produtoDAO.listar()) {

            if (p.abaixoMinimo()) {

                System.out.println(
                        p.getNome()
                        + " abaixo do minimo!"
                );

            }

            if (p.acimaMaximo()) {

                System.out.println(
                        p.getNome()
                        + " acima do maximo!"
                );

            }

        }

    }

}