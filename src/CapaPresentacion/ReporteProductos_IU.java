/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Categoria;
import CapaDatos.Marca;
import CapaNegocio.CategoriaBD;
import CapaNegocio.MarcaBD;
import CapaNegocio.ProductoBD;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WALTER
 */
public class ReporteProductos_IU extends javax.swing.JInternalFrame {

    public ReporteProductos_IU() {
        initComponents();
        cargarMarca();
        cargarCategoria();
    }

    private void cargarMarca() {
        try {
            cmbMarca.removeAllItems();
            MarcaBD objeto_marcaBD = new MarcaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = objeto_marcaBD.reportarMarca();
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                String nombre = String.valueOf(tabla_temporal.getValueAt(i, 1));
                cmbMarca.addItem(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al cargar marca", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarCategoria() {
        try {
            cmbCategoria.removeAllItems();
            CategoriaBD objeto_categoriaBD = new CategoriaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = objeto_categoriaBD.reportarCategoria();
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                String nombre = String.valueOf(tabla_temporal.getValueAt(i, 1));
                cmbCategoria.addItem(nombre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al cargar categoria", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        cmbMarca = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbPresentacion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reportar_productos = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("REPORTE DE PRODUCTOS");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("PRODUCTO");

        txtProducto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtProductoKeyPressed(evt);
            }
        });

        cmbMarca.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMarcaItemStateChanged(evt);
            }
        });
        cmbMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarcaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("PRESENTACION");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("CATEGORIA");

        cmbCategoria.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("MARCA");

        cmbPresentacion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cmbPresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UNIDADES", "CAJA", "BOLSA" }));
        cmbPresentacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPresentacionItemStateChanged(evt);
            }
        });

        tabla_reportar_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla_reportar_productos);

        txtCantidad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtCantidad.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("CANTIDAD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1312, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProducto)
                            .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPresentacion, 0, 187, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarcaItemStateChanged
        try {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

                DefaultTableModel tabla_temporal;
                String descripcion = cmbMarca.getSelectedItem().toString();
                String marca = cmbMarca.getSelectedItem().toString();
                String categoria = "";
                String presentacion = "";

                ProductoBD objeto_productoBD = new ProductoBD();
                tabla_temporal = objeto_productoBD.reporteProductosMultiple(descripcion, marca, categoria, presentacion);
                tabla_reportar_productos.setModel(tabla_temporal);

                int cantidad_productos = tabla_temporal.getRowCount();
                txtCantidad.setText("" + cantidad_productos);

                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }

        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }

    }//GEN-LAST:event_cmbMarcaItemStateChanged

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged

        try {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

                DefaultTableModel tabla_temporal;
                String descripcion = cmbCategoria.getSelectedItem().toString();
                String marca = "";
                String categoria = cmbCategoria.getSelectedItem().toString();
                String presentacion = "";

                ProductoBD objeto_productoBD = new ProductoBD();
                tabla_temporal = objeto_productoBD.reporteProductosMultiple(descripcion, marca, categoria, presentacion);
                tabla_reportar_productos.setModel(tabla_temporal);

                int cantidad_productos = tabla_temporal.getRowCount();
                txtCantidad.setText("" + cantidad_productos);

                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }

        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }

    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void txtProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyPressed

        try {

            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

            DefaultTableModel tabla_temporal;
            String descripcion = txtProducto.getText().toString();
            String marca = "";
            String categoria = "";
            String presentacion = "";

            ProductoBD objeto_productoBD = new ProductoBD();
            tabla_temporal = objeto_productoBD.reporteProductosMultiple(descripcion, marca, categoria, presentacion);
            tabla_reportar_productos.setModel(tabla_temporal);

            int cantidad_productos = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cantidad_productos);

            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }

    }//GEN-LAST:event_txtProductoKeyPressed

    private void cmbMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarcaActionPerformed


    }//GEN-LAST:event_cmbMarcaActionPerformed

    private void cmbPresentacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPresentacionItemStateChanged
        
        try {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

                DefaultTableModel tabla_temporal;
                String descripcion = cmbPresentacion.getSelectedItem().toString();
                String marca = "";
                String categoria = "";
                String presentacion = cmbPresentacion.getSelectedItem().toString();

                ProductoBD objeto_productoBD = new ProductoBD();
                tabla_temporal = objeto_productoBD.reporteProductosMultiple(descripcion, marca, categoria, presentacion);
                tabla_reportar_productos.setModel(tabla_temporal);

                int cantidad_productos = tabla_temporal.getRowCount();
                txtCantidad.setText("" + cantidad_productos);

                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }

        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_cmbPresentacionItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbPresentacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reportar_productos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables

}
