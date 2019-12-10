package br.edu.ifpr.repository;

import br.edu.ifpr.connection.ConnectionFactory;
import br.edu.ifpr.models.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ContatoRepository {

    Contato contato;
    List<Contato> contatos;
    Connection connection;

    public ContatoRepository(){
        connection = ConnectionFactory.getConnection();
    }

    public void adicionarContato(Contato contato){

        //TODO
        //implemente o algoritmo

    }

    public void excluir(Integer param_id) {

        try {

            String sql = "DELETE FROM contatos where id = " + param_id;

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.execute();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarContato(){



    }
}
