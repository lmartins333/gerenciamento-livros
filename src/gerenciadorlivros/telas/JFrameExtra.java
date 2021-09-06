/*
 * Classe com objetivo de implementar funcionalidades extras comuns à vários
 * JFrames utilizados nos projetos como verificação de se um ou mais campos estão
 * preenchidos, avanço de foco para outros componentes, identificação de campos
 * vazios, alerta de erro, etc.
 */
package gerenciadorlivros.telas;

import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Lucas Martins
 */
public class JFrameExtra extends JFrame {

    /**
     * Verifica se um ou mais campos estão preenchidos.
     * 
     * @param campos
     * @return 
     */
    public boolean campoPreenchido(JTextField ... campos) {
        for (JTextField campo: campos) {
            if (campo.getText().equals("")) {
                return false;
            }
        }

        return true;
    }

    /**
     * Verifica se um usuário pressionou enter e valida um campo verificando se 
     * o mesmo recebeu algum valor. 
     * Caso o campo tenha um valor, o foco é 
     * repassadopara o próximo componente.
     * Caso contrário, é emitido um alerta de erro.
     * @param evento
     * @param campo
     * @param proximoComponente 
     */
    public boolean validarCampoEAvancar(KeyEvent evento, JTextField campo, Component proximoComponente) {
        boolean enterPressionado = evento.getKeyCode() == KeyEvent.VK_ENTER;

        if (enterPressionado) {
            if (campoPreenchido(campo)) {
                if (!proximoComponente.equals(null)) {
                    proximoComponente.requestFocus();
                }

                return true;
            } else {
                campo.requestFocus();
                erroCampo();
            }
        }

        return false;
    }

    /**
     * Varre todos os componentes de um JFrame em busca dos componentes do tipo
     * jTextField e verifica se os mesmos possuem algum valor.
     * Em caso afirmativo, retorna verdadeiro.
     * Em caso negativo, emite uma mensagem de erro e retorna falso.
     * @return 
     */
    public boolean todosOsCamposEstaoPreenchidos() {
        Component componentes[] = this.getRootPane().getComponents();

        for (Component componente: componentes) {
            if (componente instanceof JTextField || componente instanceof JPasswordField) {
                JTextField campo = (JTextField) componente;

                if (campoPreenchido(campo)) {
                    erroCampo();
                    campo.requestFocus();
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Exibe um alerta de erro para qualquer campo vazio encontrado.
     */
    private void erroCampo() {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
    }

}