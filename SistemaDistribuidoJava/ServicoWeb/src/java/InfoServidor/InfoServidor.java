/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InfoServidor;

import java.util.Random;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author luiz
 */
@WebService(serviceName = "InfoServidor")
public class InfoServidor {

    Cliente cliente = new Cliente();

    /**
     * Operação de Web service
     *
     * @param numCompra
     */
    @WebMethod(operationName = "setNumCompra")
    public String setNumCompra(@WebParam(name = "numCompra") String numCompra) {
        Random gerador = new Random();

        int num = -1;
        while (num < 0) {
            num = gerador.nextInt();
        }
        numCompra = Integer.toString(num);

        cliente.setNumeroCompra(numCompra);

        return numCompra;
    }

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "setEstadoFila")
    public String setEstadoFila(@WebParam(name = "numConsulta") String numConsulta) {
        String estadoFila = null;
        
            estadoFila = cliente.getEstatusFila(numConsulta);
       

        return estadoFila;
    }
}
