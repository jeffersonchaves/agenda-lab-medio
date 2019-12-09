<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="br.edu.ifpr.models.Contato" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.ArrayList" %>

<%
  List<Contato> lista = new ArrayList<Contato>();

  Class.forName("com.mysql.jdbc.Driver");
  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
  Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/agenda", "root", "root");

  String sql = "SELECT * FROM contatos";

  PreparedStatement statement = connection.prepareStatement(sql);

  ResultSet resultSet = statement.executeQuery();

  while(resultSet.next()) {

      Contato contato = new Contato();
      contato.setId(resultSet.getInt("id"));
      contato.setNome(resultSet.getString("nome"));
      contato.setEmail(resultSet.getString("email"));
      contato.setEndereco(resultSet.getString("endereco"));
      contato.setDataNascimento(resultSet.getDate("dataNascimento"));

      lista.add(contato);
  }

%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Agenda de Contatos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  </head>
  <body>

  <div class="container">

      <h1>Contatos</h1>

      <a name="" id="" class="btn btn-primary" href="cadastro.jsp" role="button">cadastrar</a>

      <table class="table mt-4">
          <thead>
          <td>id</td>
          <td>nome</td>
          <td>email</td>
          <td>endereco</td>
          <td>data nascimento</td>
          <td>#</td>
          </thead>
          <% for (Contato contato: lista) { %>
          <tr>

              <td><%= contato.getId() %></td>
              <td><%= contato.getNome() %></td>
              <td><%= contato.getEmail() %></td>
              <td><%= contato.getEndereco() %></td>
              <td><%= contato.getDataNascimento() %></td>
              <td>
                  <a href="contato?acao=editar&id=<%= contato.getId() %>">editar</a> |
                  <a href="contato?acao=excluir&id=<%= contato.getId() %>">excluir</a>
              </td>
          </tr>
          <%}%>
      </table>
  </div>

  </body>
</html>
