/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyecto.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static proyecto.java.VistaAlquilados.cliente;

/**
 *
 * @author Kanyu
 */
public class VistaProducto extends javax.swing.JDialog {

    /**
     * Creates new form VistaProducto
     */
    public static Titulo titulo;
   private String [] cabecera;
    public VistaProducto(java.awt.Frame parent, boolean modal, Titulo titulo) {
        super(parent, modal);
        this.titulo=titulo;
        initComponents();
        lbCabecera.setText("Gestión de "+titulo.getTitulo());
        cabecera = new String[]{
                "ID Producto", "Título", "Categoría", "Fecha Alta", "Estado"
            };
         this.tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            
        public void valueChanged(ListSelectionEvent event) {
           
            jButton3.setEnabled(tabla.getSelectedRow()>-1);
            
        }
    
    });
        refresh();
    }
    private void refresh(){
    try {
            Vector cab=new Vector(Arrays.asList(cabecera));
            Vector data=new Vector();
            String consulta="SELECT * FROM titulo WHERE idtit="+titulo.getIdTit();
            ResultSet rs = SQLHelper.ejecutarConsulta(consulta);
            rs.next();
            consulta="select idal, titulo, categoria.nombre, alquilables.fechaalta, alquilables.alquilado from alquilables "
                    + "inner join titulo using(idtit) inner join categoria using (idcat) where idtit="+rs.getInt("idtit");
            rs= SQLHelper.ejecutarConsulta(consulta);
            while(rs.next()){
                Vector tupla=new Vector();
                for(int i=1;i<=cab.size();i++){
                    tupla.add(rs.getObject(i));
                }
                data.add(tupla);
            }
            tabla.setModel(new DefaultTableModel(data, cab){

            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        });
        } catch (SQLException ex) {
            Logger.getLogger(VistaAlquilados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon volver = new ImageIcon(getClass().getResource("/images/flechavolver.gif"));
        jButton1 = new javax.swing.JButton(volver);
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbCabecera = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Producto", "Título", "Categoría", "Fecha Alta", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabla);

        jButton3.setText("Eliminar producto");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Agregar producto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbCabecera.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbCabecera.setText("Cabecera");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(lbCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(7, 7, 7))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 841, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCabecera)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(257, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int id = (int)tabla.getModel().getValueAt(tabla.getSelectedRow(), 0);
        String titulo= (String)tabla.getModel().getValueAt(tabla.getSelectedRow(), 1);
        String categoria= (String)tabla.getModel().getValueAt(tabla.getSelectedRow(), 2);
        String alquilado= (String)tabla.getModel().getValueAt(tabla.getSelectedRow(), 4);
        if(alquilado.equalsIgnoreCase("alquilado")){
            JOptionPane.showMessageDialog(rootPane, "No puedes borrar un producto que está alquilado.");
        }
        else{
        int opcion = JOptionPane.showConfirmDialog(rootPane, "Estás a punto de eliminar \""+titulo+" - "+categoria+"\", ¿Es correcto?");
        if(opcion==JOptionPane.YES_OPTION){
            String update= "DELETE FROM alquilables WHERE idal="+id;
            SQLHelper.ejecutarUpdate(update);
            JOptionPane.showMessageDialog(rootPane, "\""+titulo+" - "+categoria+"\", eliminado.");
            refresh();
        }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VistaAñadirProducto producto= new VistaAñadirProducto(null, true, titulo);
        producto.setVisible(true);
        refresh();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaProducto dialog = new VistaProducto(new javax.swing.JFrame(), true, titulo);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCabecera;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
