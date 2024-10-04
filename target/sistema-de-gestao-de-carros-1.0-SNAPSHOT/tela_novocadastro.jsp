
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles/novocadastro.css">
        <title>Cadastro de Carro</title>
    </head>
    <body>
        <header>
            <h1> Sistema de Gestão de Carros </h1>
        </header>

        <div id="div-conteudo">
            <h2>Cadastre um novo carro</h2>
            <form action="CarroController" method="GET" id="form">
                <%-- Separação dos dados do carro e do dono --%>

                <%-- Dados do Carro --%>
                <p>Dados do Carro</p>
                <div class="conteudo-form">
                    <div class="linha-form"> 
                        Marca: <input type="text" name="txtmarca" maxlength="20" required>
                    </div>
                    <div class="linha-form"> 
                        Modelo: <input type="text" name="txtmodelo" maxlength="50" required> 
                    </div>
                    <div class="linha-form"> 
                        Ano: <input type="number" name="txtano" required>
                    </div>  
                    <div class="linha-form"> 
                        Motor: <input type="text" name="txtmotor" maxlength="20" required>
                    </div> 
                    <div class="linha-form"> 
                        Placa: <input type="text" name="txtplaca" maxlength="7" required>
                    </div> 
                </div>

                <%-- Dados do Dono --%>
                <p>Dados do Dono</p>
                <div class="conteudo-form">
                    <div class="linha-form"> 
                        Dono: <input type="text" name="txtdono" maxlength="50" required>
                    </div> 
                    <div class="linha-form"> 
                        CNH: <input type="text" name="txtcnh" maxlength="11" required>
                    </div>
                    <div class="linha-form"> 
                        Telefone: <input type="text" name="txttelefone" maxlength="12" required>
                    </div>  
                    <div class="linha-form"> 
                        Endereço: <input type="text" name="txtendereco" maxlength="100" required>
                    </div>
                </div>
                <br>
            </form>
            <div id="botoes-form">
                <form action="CarroController" method="GET">
                    <input type="submit" name="op" value="Voltar">
                </form>
                <input type="submit" name="op" value="Cadastrar" form="form">
            </div>
        </div>
    </body>
</html>
