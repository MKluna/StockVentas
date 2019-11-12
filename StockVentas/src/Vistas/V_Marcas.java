package Vistas;

import Facades.Fac_Marcas;
import Templates.DialogoConsulta;
import Templates.QueryGral;
import entidades.Marcas;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author smuser
 */
public class V_Marcas extends javax.swing.JDialog {

    int opcion = 0;
    Marcas objMarca = new Marcas();
    Fac_Marcas FMarca = new Fac_Marcas();
    

    public V_Marcas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TMarca_id = new javax.swing.JTextField();
        TMarca = new javax.swing.JTextField();
        BBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableMarcas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        BNuevo = new javax.swing.JButton();
        BEditar = new javax.swing.JButton();
        BConsultar = new javax.swing.JButton();
        BAceptar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        BSalir = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Marcas");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Marca id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Marca");

        TMarca_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TMarca_id.setEnabled(false);
        TMarca_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TMarca_idKeyPressed(evt);
            }
        });

        TMarca.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TMarca.setEnabled(false);

        BBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/find.png"))); // NOI18N
        BBuscar.setEnabled(false);
        BBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscarActionPerformed(evt);
            }
        });

        TableMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Marcas"
            }
        ));
        jScrollPane2.setViewportView(TableMarcas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(TMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TMarca_id, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(TMarca_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BNuevo.setText("Nuevo");
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });

        BEditar.setText("Editar");
        BEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditarActionPerformed(evt);
            }
        });

        BConsultar.setText("Consultar");
        BConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConsultarActionPerformed(evt);
            }
        });

        BAceptar.setText("Aceptar");
        BAceptar.setEnabled(false);
        BAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAceptarActionPerformed(evt);
            }
        });

        BCancelar.setText("Cancelar");
        BCancelar.setEnabled(false);
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });

        BSalir.setText("Salir");
        BSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BConsultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(BAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        opcion = 1;
        BNuevo.setEnabled(false);
        BEditar.setEnabled(false);
        BConsultar.setEnabled(false);

        BAceptar.setEnabled(true);
        BCancelar.setEnabled(true);
        TMarca.setEnabled(true);
        TMarca.requestFocusInWindow();
    }//GEN-LAST:event_BNuevoActionPerformed

    private void BEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditarActionPerformed
        opcion = 2;
        BNuevo.setEnabled(false);
        BEditar.setEnabled(false);
        BConsultar.setEnabled(false);

        BAceptar.setEnabled(true);
        BCancelar.setEnabled(true);
        TMarca.setEnabled(true);
        TMarca_id.setEnabled(true);
        BBuscar.setEnabled(true);
        TMarca_id.requestFocusInWindow();
    }//GEN-LAST:event_BEditarActionPerformed

    private void BConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConsultarActionPerformed
        opcion = 3;
        BNuevo.setEnabled(false);
        BEditar.setEnabled(false);
        BConsultar.setEnabled(false);

        BAceptar.setEnabled(true);
        BCancelar.setEnabled(true);
    }//GEN-LAST:event_BConsultarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        opcion = 0;
        BNuevo.setEnabled(true);
        BEditar.setEnabled(true);
        BConsultar.setEnabled(true);

        BAceptar.setEnabled(false);
        BCancelar.setEnabled(false);
        TMarca.setEnabled(false);
        TMarca_id.setEnabled(false);
        BBuscar.setEnabled(false);
        TMarca_id.setText("");
        TMarca.setText("");
        BSalir.requestFocusInWindow();

    }//GEN-LAST:event_BCancelarActionPerformed

    private void BSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSalirActionPerformed
        dispose();
    }//GEN-LAST:event_BSalirActionPerformed

    private void TMarca_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TMarca_idKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TMarca_idKeyPressed

    private void LimpiarObjetos() {
        TMarca.setText("");
        TMarca_id.setText("");
    }

    private void DesactivarObjetos() {
        TMarca.setEnabled(false);
        TMarca_id.setEnabled(false);
        BBuscar.setEnabled(false);
        BAceptar.setEnabled(false);
        BCancelar.setEnabled(false);
        
        BNuevo.setEnabled(true);
        BEditar.setEnabled(true);
        BConsultar.setEnabled(true);
        BSalir.requestFocusInWindow();
    }

    private void BAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAceptarActionPerformed
        if (opcion == 1) { // para grabar
            if (JOptionPane.showConfirmDialog(this, "Esta Seguro de Registrar Nueva Marca", "Atención", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    if (TMarca.getText().length() <= 2) {
                        JOptionPane.showMessageDialog(this, "Nombre de Marca Incorrecto", " Información", JOptionPane.ERROR_MESSAGE);
                        TMarca.requestFocusInWindow();
                        return;
                    }

                    if (FMarca.ExisteMarca(TMarca.getText().toUpperCase())) {
                        JOptionPane.showMessageDialog(this, "Nombre de Marca Existente", " Información", JOptionPane.ERROR_MESSAGE);
                        TMarca.requestFocusInWindow();
                        return;
                    }
                    objMarca.setMarca(TMarca.getText().toUpperCase());
                    FMarca.NuevaMarca(objMarca);
                    JOptionPane.showMessageDialog(this, "Nueva Marca Registrada con exito", " Información", JOptionPane.INFORMATION_MESSAGE);
                    LimpiarObjetos();
                    DesactivarObjetos();
                } catch (SQLException ex) {
                    Logger.getLogger(V_Marcas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
            if (opcion == 2) {
                if (JOptionPane.showConfirmDialog(this, "Esta Seguro de Editar la Marca", "Atención", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    try {
                        if (TMarca_id.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "No Ingreso Marca id", " Información", JOptionPane.ERROR_MESSAGE);
                            TMarca_id.requestFocusInWindow();
                            return;
                        }                        
                        if (TMarca.getText().length() <= 2) {
                            JOptionPane.showMessageDialog(this, "No Ingreso Nombre de Marca", " Información", JOptionPane.ERROR_MESSAGE);
                            TMarca.requestFocusInWindow();
                            return;
                        }
                        if (FMarca.ExisteMarca(TMarca.getText().toUpperCase())) {
                            JOptionPane.showMessageDialog(this, "Nombre de Marca Existente", " Información", JOptionPane.ERROR_MESSAGE);
                            TMarca.requestFocusInWindow();
                            return;
                        }
                        objMarca.setMarca(TMarca.getText().toUpperCase().trim());
                        objMarca.setMarca_id(Integer.valueOf(TMarca_id.getText()));
                        FMarca.EditarMarca(objMarca);
                        JOptionPane.showMessageDialog(this, "Nombre de Marca Editada con exito", " Información", JOptionPane.INFORMATION_MESSAGE);
                        LimpiarObjetos();
                        DesactivarObjetos();

                    } catch (SQLException ex) {
                        Logger.getLogger(V_Marcas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } 
            if ( opcion == 3){ // consulta
               BBuscar.setEnabled(true);
               TMarca_id.setEnabled(true);
               TMarca_id.requestFocusInWindow();
            }
        
    }//GEN-LAST:event_BAceptarActionPerformed

    private void BBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarActionPerformed

    }//GEN-LAST:event_BBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(V_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(V_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(V_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(V_Marcas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                V_Marcas dialog = new V_Marcas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BAceptar;
    private javax.swing.JButton BBuscar;
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BConsultar;
    private javax.swing.JButton BEditar;
    private javax.swing.JButton BNuevo;
    private javax.swing.JButton BSalir;
    private javax.swing.JTextField TMarca;
    private javax.swing.JTextField TMarca_id;
    private javax.swing.JTable TableMarcas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
