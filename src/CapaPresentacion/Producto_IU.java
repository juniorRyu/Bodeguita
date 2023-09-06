package CapaPresentacion;

import CapaDatos.Categoria;
import CapaDatos.Marca;
import CapaDatos.Medida;
import CapaDatos.Producto;
import CapaNegocio.CategoriaBD;
import CapaNegocio.ClienteBD;
import CapaNegocio.MarcaBD;
import CapaNegocio.MedidaBD;
import CapaNegocio.ProductoBD;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Producto_IU extends javax.swing.JInternalFrame {

    List<Marca> lista_marca;
    List<Categoria> lista_Categoria;
    List<Medida> lista_medida;

    /**
     * Creates new form Producto_IU
     */
    public Producto_IU() {
        initComponents();
        reportar();

        cargarCategoria();
        cargarMedida();
        cargarMarca();
    }

    private void reportar() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

            DefaultTableModel tabla_temporal;
            ProductoBD objeto_productoBD = new ProductoBD();
            tabla_temporal = objeto_productoBD.reportarProducto();

            tabla_reporte_producto.setModel(tabla_temporal);

            int cantLista = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cantLista);

            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        } catch (Exception ex) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            ex.printStackTrace();
        }
    }

    private void habilitar() {
        btnBuscar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnRegistrar.setEnabled(true);

    }

    private void deshabilitar() {
        btnBuscar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnRegistrar.setEnabled(false);

    }

    private void limpiar() {
        txtSerie.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtCodigoCategoria.setText("");
        txtCodigoMarca.setText("");

    }

    private void cargarMedida() {
        try {
            cmbMarca.removeAllItems();

            MedidaBD objeto_medidaBD = new MedidaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = objeto_medidaBD.reportarMedida();

            lista_medida = new ArrayList<>();

            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {

                int codigo = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String presentacion = String.valueOf(tabla_temporal.getValueAt(i, 1));
                String equivalencia = String.valueOf(tabla_temporal.getValueAt(i, 2));

                lista_medida.add(new Medida(codigo, presentacion, equivalencia));
                cmbMedida.addItem(presentacion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al cargar medida", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarMarca() {
        try {
            cmbMarca.removeAllItems();

            MarcaBD objeto_marcaBD = new MarcaBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = objeto_marcaBD.reportarMarca();

            lista_marca = new ArrayList<>();

            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {

                int codigo = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String nombre = String.valueOf(tabla_temporal.getValueAt(i, 1));

                lista_marca.add(new Marca(codigo, nombre));
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
            lista_Categoria = new ArrayList<>();
            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {

                int codigo = Integer.valueOf(tabla_temporal.getValueAt(i, 0).toString());
                String nombre = String.valueOf(tabla_temporal.getValueAt(i, 1));

                lista_Categoria.add(new Categoria(codigo, nombre));
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        cmbMedida = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbMarca = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_producto = new javax.swing.JTable();
        txtCodigoMarca = new javax.swing.JTextField();
        txtCodigoCategoria = new javax.swing.JTextField();
        dcFechaNac = new com.toedter.calendar.JDateChooser();
        txtCodigoMedida = new javax.swing.JTextField();

        setClosable(true);
        setTitle("MANTENIMIENTO DE PRODUCTOS");

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("SERIE");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("DESCRIPCION");

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("MEDIDA");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("PRECIO");

        txtCantidad.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtCantidad.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("STOCK");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("CANTIDAD");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("FECHA VCTO");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("CATEGORIA");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("MARCA");

        txtSerie.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txtSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerieKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerieKeyReleased(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        cmbMedida.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cmbMedida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMedidaItemStateChanged(evt);
            }
        });

        txtPrecio.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        txtStock.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMarcaItemStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNuevo.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/application.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/report_magnify.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setEnabled(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/report_edit.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setEnabled(false);
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/bin_empty.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setEnabled(false);
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/cross.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnRegistrar.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/CapaPresentacion/Imagenes/disk.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setEnabled(false);
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(96, 96, 96)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabla_reporte_producto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tabla_reporte_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_producto);

        dcFechaNac.setDateFormatString("yyyy-MMM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(643, 643, 643))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(35, 35, 35)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodigoMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dcFechaNac, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cmbMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(dcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))))
                .addGap(11, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            int i = cmbCategoria.getSelectedIndex();

            txtCodigoCategoria.setText("" + lista_Categoria.get(i).getIdcategoria());

        }

    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void cmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarcaItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            int i = cmbMarca.getSelectedIndex();

            txtCodigoMarca.setText("" + lista_marca.get(i).getIdmarca());

        }
    }//GEN-LAST:event_cmbMarcaItemStateChanged

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed

        habilitar();

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtSerie.getText().length() > 0) {
            String serie = txtSerie.getText();
            ProductoBD objeto_productoBD = new ProductoBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = objeto_productoBD.buscarProducto(serie);

            if (tabla_temporal.getRowCount() > 0) {

                tabla_reporte_producto.setModel(tabla_temporal);
                txtDescripcion.setText(tabla_temporal.getValueAt(0, 1).toString());
                cmbMedida.setSelectedItem(tabla_temporal.getValueAt(0, 2).toString());
                txtPrecio.setText(tabla_temporal.getValueAt(0, 3).toString());
                txtStock.setText(tabla_temporal.getValueAt(0, 4).toString());

                String fecha_bd = String.valueOf(tabla_temporal.getValueAt(0, 5).toString());
                SimpleDateFormat fecha_formatear = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha;
                try {
                    fecha = (java.util.Date) fecha_formatear.parse(fecha_bd);
                    dcFechaNac.setDate(fecha);
                } catch (ParseException e) {
                }
                cmbMarca.setSelectedItem(tabla_temporal.getValueAt(0, 6));
                cmbCategoria.setSelectedItem(tabla_temporal.getValueAt(0, 7));

            } else {
                JOptionPane.showMessageDialog(null, "no se encontro datos...");
                txtSerie.requestFocus();
                txtSerie.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese serie...");
            txtSerie.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if (txtSerie.getText().length() > 0) {
            if (txtDescripcion.getText().length() > 0) {
                if (txtPrecio.getText().length() > 0) {
                    if (txtStock.getText().length() > 0) {
                        if (txtCodigoCategoria.getText().length() > 0) {
                            if (txtCodigoMarca.getText().length() > 0) {
                                if (dcFechaNac.getDate() != null) {

                                    Producto objeto_producto = new Producto();
                                    ProductoBD objeto_productoBD = new ProductoBD();

                                    int dia = dcFechaNac.getCalendar().get(Calendar.DAY_OF_MONTH);
                                    int año = dcFechaNac.getCalendar().get(Calendar.YEAR);
                                    int mes = dcFechaNac.getCalendar().get(Calendar.MONTH) + 1;
                                    String fecha = año + "-" + mes + "-" + dia;

                                    objeto_producto.setpSerie(txtSerie.getText());
                                    objeto_producto.setpDescripcion(txtDescripcion.getText().toUpperCase());
                                    objeto_producto.setIdmedida(Integer.parseInt(txtCodigoMedida.getText()));
                                    objeto_producto.setpPrecio(Double.parseDouble(txtPrecio.getText()));
                                    objeto_producto.setpStock(Integer.parseInt(txtStock.getText()));
                                    objeto_producto.setpFechaVcto(fecha);

                                    objeto_producto.setIdcategoria(Integer.parseInt(txtCodigoCategoria.getText()));
                                    objeto_producto.setIdmarca(Integer.parseInt(txtCodigoMarca.getText()));

                                    objeto_productoBD.modificarProducto(objeto_producto);
                                    JOptionPane.showMessageDialog(null, "Todo OK...");
                                    reportar();
                                    limpiar();
                                    deshabilitar();

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ingrese la fecha...");
                                    txtSerie.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Seleccione una marca...");
                                txtSerie.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione una categoria...");
                            txtSerie.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese el stock...");
                        txtSerie.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese el precio...");
                    txtSerie.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la descripción...");
                txtSerie.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la serie...");
            txtSerie.requestFocus();
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            if (txtSerie.getText().length() > 0) {

                String serie = txtSerie.getText();
                //Con esta linea averiguo donde se dio clic en ACEPTAR O CANCELAR
                int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar");
                if (aviso == 0) {
                    ProductoBD objeto_productoBD = new ProductoBD();

                    objeto_productoBD.eliminarProducto(serie);

                    reportar();
                    limpiar();
                    deshabilitar();
                    txtSerie.requestFocus();

                }
            } else {
                JOptionPane.showMessageDialog(null, "Falta codigo", "Error", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtSerie.getText().length() > 0) {
            if (txtDescripcion.getText().length() > 0) {
                if (txtPrecio.getText().length() > 0) {
                    if (txtStock.getText().length() > 0) {
                        if (txtCodigoCategoria.getText().length() > 0) {
                            if (txtCodigoMarca.getText().length() > 0) {
                                if (dcFechaNac.getDate() != null) {

                                    Producto objeto_producto = new Producto();
                                    ProductoBD objeto_productoBD = new ProductoBD();

                                    int dia = dcFechaNac.getCalendar().get(Calendar.DAY_OF_MONTH);
                                    int año = dcFechaNac.getCalendar().get(Calendar.YEAR);
                                    int mes = dcFechaNac.getCalendar().get(Calendar.MONTH) + 1;
                                    String fecha = año + "-" + mes + "-" + dia;

                                    objeto_producto.setpSerie(txtSerie.getText());
                                    objeto_producto.setpDescripcion(txtDescripcion.getText().toUpperCase());
                                    objeto_producto.setIdmedida(Integer.parseInt(txtCodigoMedida.getText()));
                                    objeto_producto.setpPrecio(Double.parseDouble(txtPrecio.getText()));
                                    objeto_producto.setpStock(Integer.parseInt(txtStock.getText()));
                                    objeto_producto.setpFechaVcto(fecha);

                                    objeto_producto.setIdcategoria(Integer.parseInt(txtCodigoCategoria.getText()));
                                    objeto_producto.setIdmarca(Integer.parseInt(txtCodigoMarca.getText()));

                                    objeto_productoBD.registrarProducto(objeto_producto);
                                    JOptionPane.showMessageDialog(null, "Todo OK...");
                                    reportar();
                                    limpiar();
                                    deshabilitar();

                                } else {
                                    JOptionPane.showMessageDialog(null, "Ingrese la fecha...");
                                    txtSerie.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Seleccione una marca...");
                                txtSerie.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Seleccione una categoria...");
                            txtSerie.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese el stock...");
                        txtSerie.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese el precio...");
                    txtSerie.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la descripción...");
                txtSerie.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la serie...");
            txtSerie.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtSerieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyPressed


    }//GEN-LAST:event_txtSerieKeyPressed

    private void txtSerieKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerieKeyReleased

        if (txtSerie.getText().length() == 13) {

            String serie = txtSerie.getText();
            ProductoBD objeto_productoBD = new ProductoBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = objeto_productoBD.buscarProducto(serie);

            if (tabla_temporal.getRowCount() > 0) {

                tabla_reporte_producto.setModel(tabla_temporal);
                txtDescripcion.setText(tabla_temporal.getValueAt(0, 1).toString());
                cmbMedida.setSelectedItem(tabla_temporal.getValueAt(0, 2).toString());
                txtPrecio.setText(tabla_temporal.getValueAt(0, 3).toString());
                txtStock.setText(tabla_temporal.getValueAt(0, 4).toString());

                String fecha_bd = String.valueOf(tabla_temporal.getValueAt(0, 5).toString());
                SimpleDateFormat fecha_formatear = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fecha;
                try {
                    fecha = (java.util.Date) fecha_formatear.parse(fecha_bd);
                    dcFechaNac.setDate(fecha);
                } catch (ParseException e) {
                }
                cmbMarca.setSelectedItem(tabla_temporal.getValueAt(0, 6));
                cmbCategoria.setSelectedItem(tabla_temporal.getValueAt(0, 7));

            } else {
                JOptionPane.showMessageDialog(null, "no se encontro datos...");

            }

        }

    }//GEN-LAST:event_txtSerieKeyReleased

    private void cmbMedidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMedidaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            int i = cmbMedida.getSelectedIndex();

            txtCodigoMedida.setText("" + lista_medida.get(i).getIdmedida());

        }
    }//GEN-LAST:event_cmbMedidaItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbMedida;
    private com.toedter.calendar.JDateChooser dcFechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_producto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoCategoria;
    private javax.swing.JTextField txtCodigoMarca;
    private javax.swing.JTextField txtCodigoMedida;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
