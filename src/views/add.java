
package views;

import java.util.ArrayList;
import javax.swing.JPanel;
import SQL.connection;
import java.util.List;
import objects.*;
import SQL.*;
import static SQL.connection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class add extends javax.swing.JPanel {
    boolean newProduct = false;
    public add() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtCodeBar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtProductName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnNewProduct = new javax.swing.JRadioButton();
        btnAddInventary = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnFinish = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPriceProduct = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodeBar.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                txtCodeBarComponentAdded(evt);
            }
        });
        txtCodeBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeBarActionPerformed(evt);
            }
        });
        txtCodeBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeBarKeyTyped(evt);
            }
        });
        add(txtCodeBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 50, 200, -1));

        jLabel1.setText("Código de barra");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, -1));
        add(txtProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 100, 200, -1));

        jLabel2.setText("Nombre de producto");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        buttonGroup1.add(btnNewProduct);
        btnNewProduct.setText("Nuevo Producto");
        btnNewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProductActionPerformed(evt);
            }
        });
        add(btnNewProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        buttonGroup1.add(btnAddInventary);
        btnAddInventary.setText("Agregar producto al inventario");
        btnAddInventary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInventaryActionPerformed(evt);
            }
        });
        add(btnAddInventary, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel3.setText("Cantidad de Producto");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        txtQuantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantityKeyTyped(evt);
            }
        });
        add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 190, -1));

        btnFinish.setText("Terminar");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        add(btnFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        jLabel4.setText("Precio de Producto");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, -1, -1));

        txtPriceProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceProductActionPerformed(evt);
            }
        });
        txtPriceProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPriceProductKeyTyped(evt);
            }
        });
        add(txtPriceProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 220, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeBarComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_txtCodeBarComponentAdded

    }//GEN-LAST:event_txtCodeBarComponentAdded

    private void txtCodeBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeBarActionPerformed

    }//GEN-LAST:event_txtCodeBarActionPerformed

    private void txtCodeBarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeBarKeyTyped
        char aux = evt.getKeyChar();
        String aux2 = txtCodeBar.getText();
        char aux3 = ' ';
        if(aux >= '0' && aux <= '9' && aux2.length() < 13){
            txtCodeBar.setText(aux2);
        } else{
            txtCodeBar.setText(aux2.replace(aux2.charAt(aux2.length()), aux3));
        }
    }//GEN-LAST:event_txtCodeBarKeyTyped

    private void btnNewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProductActionPerformed
        txtProductName.setEditable(false);
        newProduct = true;
    }//GEN-LAST:event_btnNewProductActionPerformed

    private void btnAddInventaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInventaryActionPerformed
        txtProductName.setEditable(true);
        newProduct = false;
    }//GEN-LAST:event_btnAddInventaryActionPerformed

    private void txtQuantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantityKeyTyped
        char aux = evt.getKeyChar();
        String aux2 = txtCodeBar.getText();
        char aux3 = ' ';
        if(aux >= '0' && aux <= '9'){
            txtCodeBar.setText(aux2);
        } else{
            txtCodeBar.setText(aux2.replace(aux2.charAt(aux2.length()), aux3));
        }
    }//GEN-LAST:event_txtQuantityKeyTyped

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        connection c = new connection();
        List<product> barCode = c.getProducts();
        boolean repeated = false;
        int aux = 0, aux2=0;
        int bCode = Integer.parseInt(txtCodeBar.getText());
        while(!repeated && aux < barCode.size()-1){
            if(bCode == barCode.get(aux).getCode()){
                repeated = true;
                if(repeated && newProduct){
                    bCode++;
                }

                aux2 = aux;
            }
            repeated = false;
            aux++;
        }
        if(!txtProductName.getText().equals("") && !txtQuantity.equals("") && newProduct && txtCodeBar.getText().length() == 13){
            c.saveProduct(new product(bCode, txtProductName.getText(), Integer.parseInt(txtQuantity.getText()), Float.parseFloat(txtPriceProduct.getText())));
        }
        if(!txtQuantity.equals("") && !newProduct){
            c.updateProduct(new product(bCode, txtProductName.getText(), Integer.parseInt(txtQuantity.getText()) + barCode.get(aux2).getQuantity(), Float.parseFloat(txtPriceProduct.getText())));
        }
    }//GEN-LAST:event_btnFinishActionPerformed

    private void txtPriceProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceProductActionPerformed

    }//GEN-LAST:event_txtPriceProductActionPerformed

    private void txtPriceProductKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceProductKeyTyped
        char aux = evt.getKeyChar();
        String aux2 = txtCodeBar.getText();
        char aux3 = ' ';
        if(aux >= '0' && aux <= '9' || aux == '.' ){
            txtCodeBar.setText(aux2);
        } else{
            txtCodeBar.setText(aux2.replace(aux2.charAt(aux2.length()), aux3));
        }
    }//GEN-LAST:event_txtPriceProductKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnAddInventary;
    private javax.swing.JButton btnFinish;
    private javax.swing.JRadioButton btnNewProduct;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCodeBar;
    private javax.swing.JTextField txtPriceProduct;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
