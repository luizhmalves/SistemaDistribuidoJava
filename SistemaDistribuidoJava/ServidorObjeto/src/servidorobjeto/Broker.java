/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorobjeto;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 *
 * @author luiz
 */
public class Broker {

    /**
     *
     * @param runnable
     * @param daemon
     */
    public synchronized void criaBroker(Runnable runnable, boolean daemon) {
        Thread brokerThread = new Thread(runnable);
        brokerThread.setDaemon(daemon);
        brokerThread.start();
        
    }
}
