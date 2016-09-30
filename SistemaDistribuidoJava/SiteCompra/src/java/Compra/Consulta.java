/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compra;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luiz
 */
public class Consulta extends HttpServlet {
private static final long serialVersionUID = 1L;

    public Consulta() {
        super();

    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       infoservidor.InfoServidor_Service service = new infoservidor.InfoServidor_Service();
	infoservidor.InfoServidor port = service.getInfoServidorPort();
	 
	java.lang.String numConsulta = (String) request.getParameter("consulta");
	
	java.lang.String result = port.setEstadoFila(numConsulta);
	

        if (result != null){
            // Define parametros para a sessão
        request.setAttribute("consulta", result);
        
        // Chama pagina de resposta
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        
        }
        

    }

    private static String setNumCompra(java.lang.String numCompra) {
        infoservidor.InfoServidor_Service service = new infoservidor.InfoServidor_Service();
        infoservidor.InfoServidor port = service.getInfoServidorPort();
        return port.setNumCompra(numCompra);
    }

}