
<%@page import="java.util.List"%>
<%@page import="com.da.projetocrud.model.Carro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/index.css" type="text/css">
        <link rel="icon" type="image/x-icon" href="/imgs/">
        <title>Sistema de Gestão de Carros</title>
    </head>
    <body>
        <header>
            <h1> Sistema de Gestão de Carros </h1>
        </header>
        <% String msg = (String) request.getAttribute("msgSucesso"); %>
        <div id="div-conteudo">
            <p>
                Mensagem: 
                <% if (msg != null) { %>
                <% out.print(msg); %>
                <% } %>
            </p>

            <div id="div-form">
                <form action="CarroController" method="GET">
                    <input type="number" name="txtid" required placeholder="Digite um ID"> 
                    <input type="submit" name="op" value="Filtrar"> 
                </form>

                <form action="CarroController" method="GET">
                    <input type="submit" name="op" value="Novo Carro">
                    <input type="submit" name="op" value="Consultar Todos">
                </form>
            </div>
            <br>
            <% List<Carro> lcarro = (List<Carro>) request.getAttribute("lcarro"); %>
            <% if (lcarro != null) { %>
            <table>
                <tr>
                    <th>Id</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Ano</th>
                    <th>Motor</th>
                    <th>Placa</th>
                    <th>Dono</th>
                    <th>CNH</th>
                    <th>Telefone</th>
                    <th>Endereço</th>
                    <th>Editar</th>
                    <th>Remover</th>
                </tr>
                <% for (Carro carro : lcarro) { %>
                <tr>
                    <td><% out.print(carro.getId()); %></td>
                    <td><% out.print(carro.getMarca()); %></td>
                    <td><% out.print(carro.getModelo()); %></td>
                    <td><% out.print(carro.getAno()); %></td>
                    <td><% out.print(carro.getMotor()); %></td>
                    <td><% out.print(carro.getPlaca()); %></td>
                    <td><% out.print(carro.getDono()); %></td>
                    <td><% out.print(carro.getCnh()); %></td>
                    <td><% out.print(carro.getTelefone()); %></td>
                    <td><% out.print(carro.getEndereco()); %></td>
                    <td>
                        <a href="CarroController?op=Editar&txtid=<% out.print(carro.getId()); %>">
                            <img width="20px" src="imgs/edit01.jpg" alt="Editar"/>
                        </a>
                    </td>
                    <td>
                        <a onclick="return confirmarDeletar()" href="CarroController?op=Deletar&txtid=<% out.print(carro.getId()); %>"">
                            <img width="20px" src="imgs/trash01.jpg" alt="Deletar"/>
                        </a>
                    </td>
                </tr>
                <% } %> <%-- for (Carro carro : lcarro) --%>
            </table>
            <% }%> <%-- if (lcarro != null) --%>
            <script src="javascript/script.js"></script>
        </div>
    </body>
</html>
