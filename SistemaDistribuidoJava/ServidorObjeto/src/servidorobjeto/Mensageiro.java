/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorobjeto;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author luiz
 */
public interface Mensageiro extends Remote {

    public String getEstatusFila(String numCompra) throws RemoteException;

    public void setNumeroCompra(String numCompra) throws RemoteException;
}

