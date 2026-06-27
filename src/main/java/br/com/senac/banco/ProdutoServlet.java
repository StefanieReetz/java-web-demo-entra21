package br.com.senac.banco;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {

    // constant
    private static final String URL = "jdbc:mysql://localhost:3306/aula-java";
    private static final String USER = "root"; // nao é uma pratica seguraaa, tem que usar
    // variavel de ambiente se eu nn me engano
    private static final String PASS = "root";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> produtos = new ArrayList<>();
        String query = "SELECT * FROM produto;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){

        }


        // a conexao do banco nn depende so do nosso java, talvez da rede tambem, um limite de dados dentro do banco etc
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()){ // enquanto tiver linhas
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getBigDecimal("preco") );
                produtos.add(produto);
            }

        } catch (SQLException e){

        }
        // se nao tiver erros

        Gson gson = new Gson();
        String json = gson.toJson(produtos);

        resp.setContentType("application/json");
        resp.getWriter().println(json);
    }
}
