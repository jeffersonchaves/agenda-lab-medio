<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="br.edu.ifpr.models.Contato" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Agenda de Contatos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  </head>
  <body>

  <div class="container mt-5">

      <h1>Cadastrar contato</h1>

      <form action="contato?acao=cadastrar" method="post">

          <div class="form-group">
              <label for="">Nome</label>
              <input type="text" name="nome" id="" class="form-control" placeholder="" aria-describedby="helpId">
              <small id="helpId" class="text-muted">Help text</small>
          </div>

          <div class="form-group">
              <label for="">E-mail</label>
              <input type="text" name="email" id="" class="form-control" placeholder="" aria-describedby="helpId">
              <small id="helpId" class="text-muted">Help text</small>
          </div>

          <div class="form-group">
              <label for="">Endereço</label>
              <input type="text" name="endereco" id="" class="form-control" placeholder="" aria-describedby="helpId">
              <small id="helpId" class="text-muted">Help text</small>
          </div>

          <div class="form-group">
              <label for="">Data Nascimento</label>
              <input type="date" name="dataNascimento" id="" class="form-control" placeholder="" aria-describedby="helpId">
              <small id="helpId" class="text-muted">Help text</small>
          </div>

          <button type="submit" class="btn btn-primary">Enviar</button>

      </form>

  </div>

  </body>
</html>
