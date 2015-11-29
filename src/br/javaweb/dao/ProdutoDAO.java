package br.javaweb.dao;

import java.util.List;
import br.javaweb.beans.Produto;
import br.javaweb.util.GlobalcodeException;

public interface ProdutoDAO {

    public void save(Produto p) throws GlobalcodeException;

    public List<Produto> getCatalogoProdutos() throws GlobalcodeException;

    public Produto getProdutoById(int id) throws GlobalcodeException;

    public void createTable() throws GlobalcodeException;
}