/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorobjeto;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiz
 */
public class GerenciadorFilas implements Runnable {

    private static final String PENDENTE = "Pendente";
    private static final String PROCESSANDO = "Processando";
    private static final String COMPLETA = "Completa";
    private static String numCompra;
    private static String numCompra1;
    private static String numCompra2;
    private Broker broker = new Broker();

    public GerenciadorFilas(String numCp) {
        numCompra = numCp;
    }

    @Override
    public void run() {

        broker.criaBroker(new ProdutorFila(numCompra, PENDENTE), false);
        numCompra1 = numCompra;
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GerenciadorFilas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        broker.criaBroker(new ProdutorFila(numCompra1, PROCESSANDO), false);
        broker.criaBroker(new ConsumidorFila(PENDENTE), true);
        numCompra2 = numCompra1;
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GerenciadorFilas.class.getName()).log(Level.SEVERE, null, ex);
        }

        broker.criaBroker(new ProdutorFila(numCompra2, COMPLETA), false);
        broker.criaBroker(new ConsumidorFila(PROCESSANDO), false);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GerenciadorFilas.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
}
