/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InfoServidor;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorobjeto.Mensageiro;

/**
 *
 * @author luiz
 */
public class Cliente implements Mensageiro {

    @Override
    public String getEstatusFila(String numCompra) {
        Mensageiro gerente;
        String estatus = null;

        Registry reg;
        try {
            reg = LocateRegistry.getRegistry("localhost", 1099);
            //reg = LocateRegistry.getRegistry("192.168.1.64", 1099);
            gerente = (Mensageiro) reg.lookup("servidor");
            
                estatus = gerente.getEstatusFila(numCompra);
            
        } catch (RemoteException ex) {
            Logger.getLogger(InfoServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estatus;
    }

    @Override
    public void setNumeroCompra(String numCompra) {
        Mensageiro gerente;

        Registry reg;
        try {
            reg = LocateRegistry.getRegistry("localhost", 1099);
            //reg = LocateRegistry.getRegistry("192.168.2.157", 1099);
            gerente = (Mensageiro) reg.lookup("servidor");
            gerente.setNumeroCompra(numCompra);
        } catch (RemoteException ex) {
            Logger.getLogger(InfoServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(InfoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
