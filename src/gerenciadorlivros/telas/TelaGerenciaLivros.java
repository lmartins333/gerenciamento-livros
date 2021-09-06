/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorlivros.telas;

import utilitarios.InterfaceBanco;
import gerenciadorlivros.models.Livro;
import gerenciadorlivros.models.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas Martins
 */
public class TelaGerenciaLivros extends javax.swing.JFrame {
    private final String ADICIONAR_LIVRO = "1";
    private final String EDITAR_QUALQUER_LIVRO = "2";
    private final String REMOVER_QUALQUER_LIVRO = "3";
    private final String EDITAR_PROPRIO_LIVRO = "4";
    private final String REMOVER_PROPRIO_LIVRO = "5";
    
    
    private InterfaceBanco ib;
    private Usuario usuario;
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaGerenciaLivros(Usuario usuario) {
        initComponents();

        if (usuario == null) {
            System.exit(1);
        }

        ib = new InterfaceBanco();
        
        setLocationRelativeTo(null);
        
        this.usuario = usuario;

        importarLivros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Titulo", "Autor", "Editora", "Ano", "Edição", "Volume", "Data de Cadastro", "CPF", "UsuarioCadastro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Atuailzar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        alterarLivro();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        removerLivro();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new TelaCadastroLivro(usuario, this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        importarLivros();
    }//GEN-LAST:event_jButton5ActionPerformed
    
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
            java.util.logging.Logger.getLogger(TelaGerenciaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciaLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciaLivros(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    
    public void importarLivros() {
        ArrayList<Livro> listaLivros = ib.getListaLivros();

        limparLista();
        
        int numeroColunas = 10;

        for (Livro livro: listaLivros) {
            Object[] linha = new Object[numeroColunas];

            linha[0] = livro.getCodigo_barras();
            linha[1] = livro.getTitulo();
            linha[2] = livro.getAutor();
            linha[3] = livro.getEditora();
            linha[4] = livro.getAno();
            linha[5] = livro.getEdicao();
            linha[6] = livro.getVolume();
            linha[7] = livro.getData_cadastro();
            linha[8] = livro.getUsuario().getCpf();
            linha[9] = livro.getUsuario().getNome();

            adicionarLinhasTabela(linha);
        }
    }

    public void adicionarLinhasTabela(Object[] linhas) {
	if (linhas.length > 0) {
	    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

	    model.addRow(linhas);
            model.moveRow(model.getRowCount()-1, model.getRowCount()-1, 0);
            
            jTable1.setModel(model);
	}
    }

    private void alterarLivro() {
        if (livroSelecionado()) {
            if (validarPermissaoUsuario(EDITAR_PROPRIO_LIVRO)) {
                atualizarLivro();
            } else {
                JOptionPane.showMessageDialog(this, "USUARIO SEM PERMISSÃO!");
            }
        }
    }

    private void removerLivro() {
        if (livroSelecionado()) {
            if (validarPermissaoUsuario(REMOVER_PROPRIO_LIVRO)) {
                excluirLivro();
            } else {
                JOptionPane.showMessageDialog(this, "USUARIO SEM PERMISSÃO!");
            }
        }
    }
    
    private void excluirLivro() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o livro?", "Confirmação", JOptionPane.YES_NO_OPTION);
        
        if (opcao == JOptionPane.YES_OPTION) {
            String codigo_barras = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

            if(ib.excluirLivro(codigo_barras)) {
                JOptionPane.showMessageDialog(this, "Livro excluído com sucesso!");
                importarLivros();
            } else {
                JOptionPane.showMessageDialog(this, "Não foi possível atender sua solicitação!!");
            }
        }
    }

    private void atualizarLivro() {
        String codigo_barras = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

        if (livroSelecionado()) {
            Livro livro = ib.getLivro(codigo_barras);
            
            new TelaAlteracaoLivro(usuario, livro, this).setVisible(rootPaneCheckingEnabled);
        }
    }

    private boolean livroSelecionado() {
        if (jTable1.getSelectedRow() >= 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um livro!");
            return false;
        }
    }

    private boolean validarPermissaoUsuario(String acao) {
        String cpfUsuarioLivroSelecionado = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 8);
        String codigoLivro = (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0);

        return ib.perfilComPermissao(usuario, acao, cpfUsuarioLivroSelecionado, codigoLivro);
    }

    public void limparLista() {
        if (jTable1.getRowCount() > 0) {
            for (int i = jTable1.getRowCount()-1; i >= 0; i--) {
                removerLinha(jTable1, i);
            }
        }
    }

    public void removerLinha(JTable tabela, int linha) {
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();

        model.removeRow(linha);
    }

}