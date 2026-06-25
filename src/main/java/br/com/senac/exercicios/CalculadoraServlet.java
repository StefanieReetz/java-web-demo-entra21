package br.com.senac.exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        double n1= Double.parseDouble(req.getParameter("n1"));
        double n2= Double.parseDouble(req.getParameter("n2"));
        String operacao = req.getParameter("operacao");
        double resultado;

        switch (operacao){
            case "soma":

                resultado = n1 + n2;

                break;

            case "subtracao":
                break;

            case "multiplicacao":
                break;

            case "divisao":
                break;

            default:
                break;
        }

        resp.getWriter().println();


    }
}
