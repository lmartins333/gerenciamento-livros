/*
 * Thread utilizada para avançar a Barra de Progresso da tela de abertura do sistema.
 */
package threads;

import gerenciadorlivros.telas.TelaLogin;
import gerenciadorlivros.telas.TelaSplash;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;

/**
 *
 * @author Lucas Martins
 */
public class ThreadSplash implements Runnable {
    private final int TAMANHO_MAXIMO = 100;

    private JProgressBar barraProgresso;
    private TelaSplash telaSplash;
    private TelaLogin telaLogin;
    private int tempoSegundos;

    public ThreadSplash(JProgressBar barraProgresso, TelaSplash telaSplash, TelaLogin telaLogin, int tempoSegundos) {
        this.barraProgresso = barraProgresso;
        this.telaSplash = telaSplash;
        this.telaLogin = telaLogin;
        this.tempoSegundos = tempoSegundos * 1000;
    }

    @Override
    public void run() {
        int intervaloAtualizacaoBarraStatus = tempoSegundos / TAMANHO_MAXIMO;
        barraProgresso.setMaximum(TAMANHO_MAXIMO);

        for (int i = 1; i <= TAMANHO_MAXIMO; i++) {
            barraProgresso.setValue(i);

            try {
                Thread.sleep(intervaloAtualizacaoBarraStatus);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadSplash.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        telaSplash.ocultarTelaEAbrirLogin();
    }

}