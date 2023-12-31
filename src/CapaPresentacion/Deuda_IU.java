/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Deuda;
import CapaNegocio.DeudaBD;
import static CapaPresentacion.Menu_IU.escritorio;
import java.awt.Dimension;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WALTER
 */
public class Deuda_IU extends javax.swing.JInternalFrame {

    /**
     * Creates new form Deuda_IU
     */
    public Deuda_IU() {
        initComponents();
        sacarFecha();
    }

    private void sacarFecha() {

        Calendar calendario = Calendar.getInstance();

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);
        String fecha = anio + "-" + mes + "-" + dia;
        txtFechaCierre.setText(fecha);

    }

    public void limpiar() {
        txtDni.setText("");
        txtCliente.setText("");
        txtIdDeuda.setText("");
        txtACuenta.setText("0");
        txtSaldo.setText("");
        txtDni.requestFocus();
        txtTotalDeuda.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAperturaCuenta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtTotalDeuda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtACuenta = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaCierre = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnNuevaBusqueda = new javax.swing.JButton();
        txtIdDeuda = new javax.swing.JTextField();

        setTitle("DEUDA");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("DNI");

        txtDni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("CLIENTE");

        txtCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCliente.setEnabled(false);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/lupa.gif"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnAperturaCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAperturaCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/application_view_list.png"))); // NOI18N
        btnAperturaCuenta.setText("APERTURA DE CUENTA");
        btnAperturaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAperturaCuentaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de la Deuda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("TOTAL DE DEUDA");

        txtTotalDeuda.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtTotalDeuda.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("A CUENTA");

        txtACuenta.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtACuenta.setText("0");
        txtACuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtACuentaKeyReleased(evt);
            }
        });

        txtSaldo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtSaldo.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("SALDO");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("ESTADO");

        txtEstado.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtEstado.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("FECHA CIERRE");

        txtFechaCierre.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtFechaCierre.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtTotalDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtACuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(txtFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtFechaCierre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtTotalDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtACuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );

        btnActualizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/application_edit.png"))); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/cancel.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnNuevaBusqueda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevaBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/find.png"))); // NOI18N
        btnNuevaBusqueda.setText("NUEVA BUSQUEDA");
        btnNuevaBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaBusquedaActionPerformed(evt);
            }
        });

        txtIdDeuda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdDeuda.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscar)
                                        .addGap(39, 39, 39)
                                        .addComponent(txtIdDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAperturaCuenta))
                                    .addComponent(txtCliente)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnActualizar)
                                .addGap(234, 234, 234)
                                .addComponent(btnNuevaBusqueda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCerrar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnAperturaCuenta)
                    .addComponent(txtIdDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnCerrar)
                    .addComponent(btnNuevaBusqueda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtEstado.getText().equals("ABIERTO")) {

            Deuda oDeuda = new Deuda();
            DeudaBD oDeudaBD = new DeudaBD();

            double total_deuda = Double.parseDouble(txtTotalDeuda.getText());
            double acuenta = Double.parseDouble(txtACuenta.getText());
            double saldo = Double.parseDouble(txtSaldo.getText());
            String fecha_cierre = txtFechaCierre.getText();
            int iddeuda = Integer.parseInt(txtIdDeuda.getText());

            String estado;
            if (saldo == 0.00) {
                estado = "CERRADO";
            } else {
                estado = "ABIERTO";
            }
            oDeuda.setTotalDeuda(saldo);
            oDeuda.setAcuenta(acuenta);
            oDeuda.setSaldo(saldo);
            oDeuda.setFechacierre(fecha_cierre);
            oDeuda.setEstado(estado);
            oDeuda.setIddeuda(iddeuda);

            boolean rpta = oDeudaBD.actualizarDeuda(oDeuda);
            if (rpta) {
                JOptionPane.showMessageDialog(this, "Se actualizo su deuda...");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Tiene problemas para actualizar su deuda...");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Se necesita datos para actualizar la deuda...Revise bien.");
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtDni.getText().length() > 0) {

            DeudaBD oDeudaBD = new DeudaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = oDeudaBD.buscarDeuda(txtDni.getText(), "ABIERTO");
            int cant = tabla_temporal.getRowCount();

            if (cant > 0) {
                int idcuenta = Integer.parseInt(tabla_temporal.getValueAt(0, 0).toString());
                String cliente = tabla_temporal.getValueAt(0, 1).toString();
                double total_deuda = Double.parseDouble(tabla_temporal.getValueAt(0, 2).toString());
                double saldo = Double.parseDouble(tabla_temporal.getValueAt(0, 4).toString());
                String estado = tabla_temporal.getValueAt(0, 7).toString();

                txtIdDeuda.setText("" + idcuenta);
                txtCliente.setText(cliente);
                txtTotalDeuda.setText("" + total_deuda);
                txtSaldo.setText("" + saldo);
                txtEstado.setText(estado);

                if (total_deuda <= 0) {

                    JOptionPane.showMessageDialog(this, "Por el momento la cuenta esta abierta pero no gasta nada...");
                    btnActualizar.setEnabled(false);
                    txtACuenta.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Esta persona no tiene deuda con ud...");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese el dni de la persona...");
            txtDni.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAperturaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAperturaCuentaActionPerformed

        AperturaCuenta_IU frame = new AperturaCuenta_IU();
        escritorio.add(frame);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        frame.show();

    }//GEN-LAST:event_btnAperturaCuentaActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void txtACuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtACuentaKeyReleased
        // TODO add your handling code here:
        try {

            double total_pagar = Double.parseDouble(txtTotalDeuda.getText());
            double acuenta = Double.parseDouble(txtACuenta.getText());

            double saldo = total_pagar - acuenta;

            txtSaldo.setText("" + saldo);

        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtACuentaKeyReleased

    private void btnNuevaBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaBusquedaActionPerformed
        // TODO add your handling code here:

        txtACuenta.setText("");
        txtACuenta.setEnabled(true);
        txtCliente.setText("");
        txtTotalDeuda.setText("");
        txtSaldo.setText("");
        txtEstado.setText("");
        btnActualizar.setEnabled(true);
        txtDni.setText("");
        txtDni.requestFocus();

        txtIdDeuda.setText("");

    }//GEN-LAST:event_btnNuevaBusquedaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAperturaCuenta;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnNuevaBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtACuenta;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaCierre;
    private javax.swing.JTextField txtIdDeuda;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTotalDeuda;
    // End of variables declaration//GEN-END:variables
}
