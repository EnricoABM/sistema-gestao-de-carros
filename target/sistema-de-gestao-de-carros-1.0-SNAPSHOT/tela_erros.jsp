
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/erros.css">
        <title>Erro</title>
    </head>
    <body>
         <header>
            <h1> Sistema de Gestão de Carros </h1>
        </header>
        <% String msg = (String) request.getAttribute("msgErro"); %>
        <div id="div-conteudo">
            <h2>Erro: <% out.print(msg);%></h2>
        </div>
    </body>
</html>
