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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("name");
        String mensagem;

        if (name == null || name.length() <= 1) {
            mensagem = "<h1>olá visitante</h1>";

        } else if (name.substring(1).length() <= 2) {
            mensagem = "<h1>Erro: nome deve ter ao menos 2 caracteres.</h1>";

        }else {
            mensagem = "<h1>Olá, " + name + "</h1>";
        }

        resp.getWriter().println(mensagem);
    }
}
