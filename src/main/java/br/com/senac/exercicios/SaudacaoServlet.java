package br.com.senac.exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/saudacao/*")
public class SaudacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String pathInfo = req.getPathInfo();
        String mensagem;
        String nome;

        if (pathInfo == null || pathInfo.length() <= 1) {
            mensagem = "<h1>olá visitante</h1>";

        } else if (pathInfo.substring(1).length() <= 2) {
            mensagem = "<h1>Erro: nome deve ter ao menos 2 caracteres.</h1>";

        }else {
            nome = pathInfo.substring(1);
            mensagem = "<h1>Olá, " + nome + "</h1>";
        }

        resp.getWriter().println(mensagem);
    }
}
