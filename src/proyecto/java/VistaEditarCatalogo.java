/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.java;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Kanyu
 */
public class VistaEditarCatalogo extends javax.swing.JDialog {

    /**
     * Creates new form VistaEditarCatalogo
     */
    private static Titulo titulo;
    public VistaEditarCatalogo(java.awt.Frame parent, boolean modal, Titulo titulo) {
        super(parent, modal);
        this.titulo=titulo;
        initComponents();
        tfTitulo.setText(titulo.getTitulo());
        taSinopsis.setText(titulo.getSinopsis());
        this.btLimpiar.setEnabled(false);
    }
    public VistaEditarCatalogo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfTitulo = new javax.swing.JTextField();
        btLimpiar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btAceptar = new javax.swing.JButton();
        lbEditar = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        lbSinopsis = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSinopsis = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btLimpiar.setText("Limpiar todo");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btAceptar.setText("Aceptar");
        btAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptarActionPerformed(evt);
            }
        });

        lbEditar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbEditar.setText("Editar Título");

        lbTitulo.setText("Titulo: ");

        lbSinopsis.setText("Sinopsis: ");

        taSinopsis.setColumns(20);
        taSinopsis.setLineWrap(true);
        taSinopsis.setRows(5);
        taSinopsis.setWrapStyleWord(true);
        taSinopsis.setDoubleBuffered(true);
        jScrollPane1.setViewportView(taSinopsis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(lbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbSinopsis)
                            .addComponent(lbTitulo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCancelar))
                            .addComponent(tfTitulo)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpiar))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitulo)
                    .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSinopsis)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAceptar)
                    .addComponent(btCancelar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptarActionPerformed
//<<<<<<< HEAD
        String titulox, sinopsis;
        titulox= tfTitulo.getText();
        sinopsis=taSinopsis.getText();
        if(titulox.isEmpty() || sinopsis.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "¡Hay campos obligatorios que están vacíos! Complétalos, por favor.");
            if(titulox.isEmpty()){
                lbTitulo.setText("*Título: ");
                lbTitulo.setForeground(Color.red);
            }
            if(sinopsis.isEmpty()){
                lbSinopsis.setText("*Sinopsis: ");
                lbSinopsis.setForeground(Color.red);
            }
            return;
        }
        else{
        String update="UPDATE titulo SET titulo='"+titulox
        +"', sinopsis='"+sinopsis+"' WHERE idtit="+titulo.getIdTit();
//=======
//        String update="";
//        if(this.btLimpiar.isEnabled()){
//        update="INSERT INTO titulo(titulo,sinopsis,fechaalta) VALUES('"+tfTitulo.getText()
//        +"', '"+taSinopsis.getText()+"',CURRENT_TIMESTAMP)";
//       
//        }else{
//        update="UPDATE titulo SET titulo='"+tfTitulo.getText()
//        +"', sinopsis='"+taSinopsis.getText()+"' WHERE idtit="+titulo.getIdTit();
//        }
//        
//>>>>>>> origin/master
        SQLHelper.ejecutarUpdate(update);
        dispose();
        }
    }//GEN-LAST:event_btAceptarActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        tfTitulo.setText("");
        taSinopsis.setText("");
    }//GEN-LAST:event_btLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaEditarCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEditarCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEditarCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEditarCatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaEditarCatalogo dialog = new VistaEditarCatalogo(new javax.swing.JFrame(), true, titulo);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAceptar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbEditar;
    private javax.swing.JLabel lbSinopsis;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextArea taSinopsis;
    private javax.swing.JTextField tfTitulo;
    // End of variables declaration//GEN-END:variables
}
