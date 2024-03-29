package br.edu.ifpr.servlets;

import br.edu.ifpr.models.Contato;
import br.edu.ifpr.repository.ContatoRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Date;

@WebServlet("/contato")
public class ContatoServlet extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("chegou na servlet");

        ContatoRepository contatoRepository = new ContatoRepository();

        String acao = request.getParameter("acao");

        if (acao.equals("editar") ){

        }else if (acao.equals("excluir")){
            Integer id = Integer.valueOf(request.getParameter("id"));

            contatoRepository.excluir(id);

            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);

        }else if(acao.equals("cadastrar") ){

        }else {
            /*pagina nao encontrada;*/
        }
    }



}
