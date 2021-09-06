/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorlivros.telas;

import utilitarios.InterfaceBanco;
import gerenciadorlivros.models.Livro;
import gerenciadorlivros.models.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Martins
 */
public class TelaCadastroLivro extends JFrameExtra {
    private InterfaceBanco ib;
    private Usuario usuario;
    private TelaGerenciaLivros telaPrincipal;

    /**
     * Creates new form TelaCadastroUsuario
     */
    public TelaCadastroLivro(Usuario usuario, TelaGerenciaLivros telaPrincipal) {
        initComponents();
        setLocationRelativeTo(null);

        ib = new InterfaceBanco();

        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        this.usuario = usuario;
        this.telaPrincipal = telaPrincipal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        editora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ano = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        codigo_barras = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edicao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        volume = new javax.swing.JTextField();
        autor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cadastro de Usuário");

        jLabel1.setText("Título");

        titulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tituloKeyPressed(evt);
            }
        });

        jLabel2.setText("Autor");

        editora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editoraKeyPressed(evt);
            }
        });

        jLabel3.setText("Editora");

        jLabel5.setText("Ano");

        ano.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                anoKeyPressed(evt);
            }
        });

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Código de Barras");

        codigo_barras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigo_barrasKeyPressed(evt);
            }
        });

        jLabel8.setText("Edição");

        edicao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edicaoKeyPressed(evt);
            }
        });

        jLabel7.setText("Volume");

        volume.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                volumeKeyPressed(evt);
            }
        });

        autor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                autorKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(ano)
                    .addComponent(editora)
                    .addComponent(titulo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(codigo_barras)
                    .addComponent(edicao)
                    .addComponent(volume)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(autor))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigo_barras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(autor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cadastrar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tituloKeyPressed
        validarCampoEAvancar(evt, titulo, autor);
    }//GEN-LAST:event_tituloKeyPressed

    private void editoraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editoraKeyPressed
        validarCampoEAvancar(evt, editora, ano);
    }//GEN-LAST:event_editoraKeyPressed

    private void anoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anoKeyPressed
        validarCampoEAvancar(evt, ano, edicao);
    }//GEN-LAST:event_anoKeyPressed

    private void edicaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edicaoKeyPressed
        validarCampoEAvancar(evt, edicao, volume);
    }//GEN-LAST:event_edicaoKeyPressed

    private void volumeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_volumeKeyPressed
        validarCampoEAvancar(evt, volume, jButton1);
    }//GEN-LAST:event_volumeKeyPressed

    private void autorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_autorKeyPressed
        validarCampoEAvancar(evt, autor, editora);
    }//GEN-LAST:event_autorKeyPressed

    private void codigo_barrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigo_barrasKeyPressed
        validarCampoEAvancar(evt, codigo_barras, titulo);
    }//GEN-LAST:event_codigo_barrasKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroLivro(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ano;
    private javax.swing.JTextField autor;
    private javax.swing.JTextField codigo_barras;
    private javax.swing.JTextField edicao;
    private javax.swing.JTextField editora;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField titulo;
    private javax.swing.JTextField volume;
    // End of variables declaration//GEN-END:variables

    private void cadastrar() {
        if (codigoNaoCadastrado()) {
            if (todosOsCamposEstaoPreenchidos()) {
                cadastrarLivro();
            }
        } else {
            JOptionPane.showMessageDialog(this, "O livro já possui cadastro no sistema!");
        }

        telaPrincipal.importarLivros();
        this.dispose();
    }
    
    private void cadastrarLivro() {
        Livro livro = new Livro();

        livro.setCodigo_barras(codigo_barras.getText());
        livro.setTitulo(titulo.getText());
        livro.setAutor(autor.getText());
        livro.setEditora(editora.getText());
        livro.setAno(ano.getText());
        livro.setEdicao(edicao.getText());
        livro.setVolume(volume.getText());
        livro.setAutor(autor.getText());
        livro.setUsuario(usuario);
        
        ib.adicionarLivro(livro);
        
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
    }

    private boolean codigoNaoCadastrado() {
        Livro livro = new Livro();

        livro.setCodigo_barras(codigo_barras.getText());

        if (ib.isCodigoCadastrado(livro)) {
            return true;
        } else {
            return false;
        }
    }

}