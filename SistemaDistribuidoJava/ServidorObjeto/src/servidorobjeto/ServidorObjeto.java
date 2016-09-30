/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorobjeto;

import java.net.SocketException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiz
 */
public class ServidorObjeto {

    private static String ip;
    
    /**
     * @param args the command line arguments
     * @throws java.net.SocketException
     */
    public static void main(String[] args) throws SocketException {
        
        Registry reg;
        try {
            reg = LocateRegistry.createRegistry(1099);
            reg.rebind("servidor", new Gestor());
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorObjeto.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.setProperty("java.rmi.server.hostname", "localhost");
        
    }

}
