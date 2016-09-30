<%-- 
    Document   : index
    Created on : 24/09/2016, 18:37:26
    Author     : luiz
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mustapha Modas</title>
    </head>
    <body>
    <center><h1>Bem Vindo a lojinha online do Tio Mustapha</h1></center> 
        <form ACTION="CompraValida">
        <center> <input type="submit" value="Comprar"></center>
        </form>
        <hr/>
        <%
            String numCompra = (String) request.getAttribute("numCompra");
            if(numCompra != null){
                out.println("Parabéns compra realizada com sucesso, número da sua compra é: " + numCompra + ".<br/>");
                out.println("Por favor anote ou memorize para futuras consultas.<br/>");
                out.println("Obrigado pelo Compra, volte sempre.<br/>");
            }
            
        %>
        <hr/>
    <form ACTION="Consulta">
            <center><input type="text" name="consulta" size="30">
                <input type="submit" value="Consulta Compra"></center>
        </form>
    <%-- start web service invocation --%><hr/>
    <%
        String numConsulta = (String) request.getAttribute("consulta");
        if ( numConsulta != null){
            out.println("Situação da compra: " + numConsulta);
        }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
