package br.com.senac.exercicios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
// http://localhost:8080/java-web-demo/calculadora?n1=1&n2=2&operacao=soma
@WebServlet("/calculadora")
public class CalculadoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");

        double n1= Double.parseDouble(req.getParameter("n1"));
        double n2= Double.parseDouble(req.getParameter("n2"));
        String operacao = req.getParameter("operacao");
        double resultado = 0;

        switch (operacao){
            case "soma":

                resultado = n1 + n2;

                break;

            case "subtracao":
                resultado = n1 - n2;
                break;

            case "multiplicacao":
                resultado = n1 * n2;
                break;

            case "divisao":
                if (n2 == 0){
                    resp.getWriter().println("<h1>nao da pra dividir por zero </h1>");
                } else {
                    resultado = n1 / n2;
                }

                break;

            default:
                resp.getWriter().println("<h1> Operação desconhecida </h1>");
                break;
        }

        resp.getWriter().println("<h1> " + resultado + " </h1>");


    }
}
