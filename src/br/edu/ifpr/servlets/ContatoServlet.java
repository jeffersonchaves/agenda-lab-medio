package br.edu.ifpr.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/contato")
public class ContatoServlet extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("chegou na servlet");

        String acao = request.getParameter("acao");
        Integer id = Integer.valueOf(request.getParameter("id"));

        if (acao.equals("editar") ){

        }else if (acao.equals("excluir")){

            excluir(id);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        }else if(acao.equals("cadastrar") ){

        }else {
            /*pagina nao encontrada;*/
        }
    }

    private void excluir(Integer param_id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "root");

            String sql = "DELETE FROM contatos where id = " + param_id;

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
