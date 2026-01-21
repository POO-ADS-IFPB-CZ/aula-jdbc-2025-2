package view;

import model.Produto;
import service.ProdutoService;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        ProdutoService produtoService = new ProdutoService();

        try{
            System.out.println(produtoService.salvar(
                    new Produto(3,"Macarrão", 3.45)
            ));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
