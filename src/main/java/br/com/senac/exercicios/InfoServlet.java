package br.com.senac.exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        LocalDate now = LocalDate.now();
        String version= System.getProperty("java.version");

        resp.getWriter().println(
                "<h1> Desenvolvimento Web com Java </h1>" +
                "<p>Data de hoje: " + now + " </p>" +
                "<p>Versão do Java: " + version + " </p>");
    }
}
