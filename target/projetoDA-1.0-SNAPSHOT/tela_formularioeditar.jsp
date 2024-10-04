<%-- 
    Document   : tela_formularioeditar
    Created on : 16 de set. de 2024, 10:19:43
    Author     : alunocmc
--%>

<%@page import="com.da.projetocrud.model.Carro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/formularioeditar.css">
        <title>Tela Principal</title>
    </head>
    <body>
        <header>
            <h1> Sistema de Gestão de Carros </h1>
        </header>
        <div id="div-conteudo">
            <h2>Atualize os dados cadastrados</h2>
            <% Carro carro = (Carro) request.getAttribute("carro"); %>
            <form action="CarroController" method="GET" id="form">
                <%-- Separação dos dados do carro e do dono --%>

                <%-- Dados do Carro --%>
                <p>Dados do Carro</p>
                <div class="conteudo-form">
                    <div class="linha-form"> 
                        Id: <input type="number" name="txtid" readonly required value="<% out.print(carro.getId()); %>">
                    </div>
                    <div class="linha-form"> 
                        Marca: <input type="text" name="txtmarca" maxlength="20" required value="<% out.print(carro.getMarca()); %>">
                    </div>
                    <div class="linha-form"> 
                        Modelo: <input type="text" name="txtmodelo" maxlength="50" required value="<% out.print(carro.getModelo()); %>"> 
                    </div>
                    <div class="linha-form"> 
                        Ano: <input type="number" name="txtano" required value="<% out.print(carro.getAno()); %>">
                    </div>  
                    <div class="linha-form"> 
                        Motor: <input type="text" name="txtmotor" maxlength="20" required value="<% out.print(carro.getMotor()); %>">
                    </div> 
                    <div class="linha-form"> 
                        Placa: <input type="text" name="txtplaca" maxlength="7" required value="<% out.print(carro.getPlaca()); %>">
                    </div> 
                </div>

                <%-- Dados do Dono --%>
                <p>Dados do Dono</p>
                <div class="conteudo-form">
                    <div class="linha-form"> 
                        Dono: <input type="text" name="txtdono" maxlength="50" required value="<% out.print(carro.getDono()); %>">
                    </div> 
                    <div class="linha-form"> 
                        CNH: <input type="text" name="txtcnh" maxlength="11" required value="<% out.print(carro.getCnh()); %>">
                    </div>
                    <div class="linha-form">
                        Telefone: <input type="text" name="txttelefone" required maxlength="12" value="<% out.print(carro.getTelefone()); %>">
                    </div>  
                    <div class="linha-form">
                        Endereço: <input type="text" name="txtendereco" required maxlength="100" value="<% out.print(carro.getEndereco());%>">
                    </div>
                </div>
                <br>
            </form>

            <div id="botoes-form">
                <form action="CarroController" method="GET">
                    <input type="submit" name="op" value="Voltar">
                </form>
                <input type="submit" name="op" value="Atualizar" form="form">
            </div>


        </div>
    </body>
</html>
