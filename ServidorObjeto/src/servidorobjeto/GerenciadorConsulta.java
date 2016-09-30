/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorobjeto;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiz
 */
public class GerenciadorConsulta {

    private String numCompra;
    private String resposta;
    private String resultadoPendente;
    private String resultadoProcessando;
    private String resultadoCompleta;
    public GerenciadorConsulta(String numCp) {
        numCompra = numCp;
    }

    public synchronized String verificaFila() {
        ExecutorService pendente = Executors.newFixedThreadPool(100);
        ExecutorService processando = Executors.newFixedThreadPool(100);
        ExecutorService completa = Executors.newFixedThreadPool(10000);
        
        Callable<String> pendente1 = new BuscaFilaPendente(numCompra);
        Callable<String> pendente2 = new BuscaFilaProcessando(numCompra);
        Callable<String> pendente3 = new BuscaFilaCompleta(numCompra);
        Future<String> filaPendente = pendente.submit(pendente1);
        Future<String> filaProcessando = processando.submit(pendente2);
        Future<String> filaCompleta = completa.submit(pendente3);
        try {
            resultadoPendente = filaPendente.get();
            resultadoProcessando = filaProcessando.get();
            resultadoCompleta = filaCompleta.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(GerenciadorConsulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(GerenciadorConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (resultadoPendente.equals("true")){
            resposta = "Pendente.";
        }else if(resultadoProcessando.equals("true")){
            resposta = "Processando.";
        }else if(resultadoCompleta.equals("true")){
            resposta = "Completa.";            
        }else{
            resposta = "Inexistente.";
        }
        
        return resposta;
    }
}
