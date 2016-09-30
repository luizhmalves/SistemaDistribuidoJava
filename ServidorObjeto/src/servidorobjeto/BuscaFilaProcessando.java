/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorobjeto;

import java.util.Enumeration;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author luiz
 */
public class BuscaFilaProcessando implements Callable<String>, ExceptionListener {

    private static String numCompra;
    private String resposta;
    private QueueConnectionFactory connectionFactory;
    private Queue queue;
    private QueueBrowser browser;
    private QueueSession session;
    private QueueConnection conexao;

    public BuscaFilaProcessando(String numC) {
        numCompra = numC;
    }

    @Override
    public String call() throws Exception {
        InitialContext initialContext;
        resposta = "false";
        try {
            initialContext = new InitialContext();

            connectionFactory = (QueueConnectionFactory) initialContext.lookup("QueueCF");

            conexao = (QueueConnection) connectionFactory.createConnection();
            conexao.start();
            conexao.setExceptionListener((ExceptionListener) this);
            session = (QueueSession) conexao.createSession(false, Session.AUTO_ACKNOWLEDGE);
            queue = (Queue) initialContext.lookup("Processando");
            browser = session.createBrowser(queue);
            Enumeration e = browser.getEnumeration();
            String text = numCompra;

            TextMessage mensagem = session.createTextMessage(text);

            while (e.hasMoreElements()) {

                TextMessage message = (TextMessage) e.nextElement();

                if (message.getText().equals(text)) {
                    resposta = "true";
                    
                } else {
                    resposta = "false";
                }
            }
            

        } catch (JMSException ex) {
            Logger.getLogger(BuscaFilaPendente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(BuscaFilaPendente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resposta;
    }

    @Override
    public void onException(JMSException exception) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
