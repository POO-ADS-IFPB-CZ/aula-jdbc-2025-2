package service;

import database.ConnectionFactory;
import model.Produto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    private ConnectionFactory connectionFactory;

    public ProdutoService(){
        connectionFactory = new ConnectionFactory();
    }

    public List<Produto> listar() throws SQLException, IOException,
            ClassNotFoundException {
        try(Connection connection = connectionFactory.getConnection()){
            PreparedStatement pstm = connection.prepareStatement(
                    "SELECT * FROM produto");
            ResultSet rs = pstm.executeQuery();
            List<Produto> produtos = new ArrayList<>();
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String descricao = rs.getString("descricao");
                double preco = rs.getDouble("preco");
                produtos.add(new Produto(codigo, descricao, preco));
            }
            return produtos;
        }
    }

}
