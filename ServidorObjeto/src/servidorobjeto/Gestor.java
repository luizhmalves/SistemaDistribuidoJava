/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorobjeto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiz
 */
public class Gestor extends UnicastRemoteObject implements Mensageiro {

    private static final long serialVersionUID = 1L;
    private Broker broker = new Broker();
    private String nomeFila;
    
    
    public Gestor() throws RemoteException {
        super();
    }

    @Override
    public String getEstatusFila(String numCompra) throws RemoteException {
        System.out.println("Estou consultado o número: " + numCompra);
        GerenciadorConsulta consultor = new GerenciadorConsulta(numCompra);
        nomeFila = consultor.verificaFila();
        return nomeFila;
    }

    @Override
    public void setNumeroCompra(String numCompra) throws RemoteException {

        Runnable gerencia = new GerenciadorFilas(numCompra);
        Thread thread = new Thread(gerencia);
        thread.start();
        
    }

}
