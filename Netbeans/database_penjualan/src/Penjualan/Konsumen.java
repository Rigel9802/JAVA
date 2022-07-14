/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Penjualan;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lucky
 */
public class Konsumen extends javax.swing.JFrame {

    /**
     * Creates new form Konsumen
     */
    
    private Object[][] dataTable = null;
    private String[] header = {"Kode", "Nama Konsumen", "Alamat", "Kota", "Kode Pos", "Telpon", "Email"};
    
    Connection Con;
    ResultSet RsBrg;
    Statement stm;
    PreparedStatement ps;
    
    Boolean ada = false;
    String sSatuan;
    Boolean edit = false;
    public Konsumen() {
        initComponents();
        open_db();
        aktif(false);
        setTombol(true);
        baca_data();
    }
    
    private void setField()
    {
        int row=tblKonsumen.getSelectedRow();
        txtKode.setText((String)tblKonsumen.getValueAt(row,0));
        txtNama.setText((String)tblKonsumen.getValueAt(row,1));
        txtAlamat.setText((String)tblKonsumen.getValueAt(row,2));
        txtKota.setText((String)tblKonsumen.getValueAt(row,3));
        txtKodePos.setText((String)tblKonsumen.getValueAt(row,4));
        txtTlp.setText((String)tblKonsumen.getValueAt(row,5));
        txtEmail.setText((String)tblKonsumen.getValueAt(row,6));
    }
    
    private void open_db()
    { 
        try{
            KoneksiMysql kon = new KoneksiMysql("localhost","root","","penjualan");
            Con = kon.getConnection();
            System.out.println("Berhasil ");
        }catch (Exception e) {
            System.out.println("Error : "+e);
        }
    }
    
        //method baca data dari Mysql dimasukkan ke table pada form
    private void baca_data()
    {
        DefaultTableModel model = (DefaultTableModel) tblKonsumen.getModel();
        model.setRowCount(0);
        
        try{
            stm = Con.createStatement();
            java.sql.ResultSet rs = stm.executeQuery("SELECT * FROM konsumen");
            while (rs.next()){                
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7)});
            }
            tblKonsumen.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
        // men-set aktif tidak isian data
    private void aktif(boolean x)
    {
        txtKode.setEditable(x);
        txtNama.setEditable(x);
        txtAlamat.setEditable(x);
        txtEmail.setEditable(x);
        txtKodePos.setEditable(x);
        txtTlp.setEditable(x);
        txtKota.setEditable(x);
    }
    
    // men-set tombol on/off
    private void setTombol(boolean t)
    {
        btn_tambah.setEnabled(t);
        btn_koreksi.setEnabled(t);
        btn_hapus.setEnabled(!t);
        btn_batal.setEnabled(!t);
        btn_keluar.setEnabled(t);
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
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        txtKota = new javax.swing.JTextField();
        txtKodePos = new javax.swing.JTextField();
        txtTlp = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKonsumen = new javax.swing.JTable();
        btn_tambah = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        btn_koreksi = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        jLabel1.setText("Data Konsumen");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Kode Konsumen");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nama Konsumen");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Alamat");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Kota");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Kode Pos");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Telpon");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Email");

        tblKonsumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama Konsumen", "Alamat", "Kota", "Kode Pos", "Phone", "Email"
            }
        ));
        tblKonsumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKonsumenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKonsumen);

        btn_tambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(0, 0, 0));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_simpan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_simpan.setForeground(new java.awt.Color(0, 0, 0));
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_koreksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_koreksi.setForeground(new java.awt.Color(0, 0, 0));
        btn_koreksi.setText("Koreksi");
        btn_koreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_koreksiActionPerformed(evt);
            }
        });

        btn_hapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(0, 0, 0));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_batal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_batal.setForeground(new java.awt.Color(0, 0, 0));
        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_keluar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_keluar.setForeground(new java.awt.Color(0, 0, 0));
        btn_keluar.setText("Keluar");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtKodePos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_koreksi, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtKodePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_simpan)
                    .addComponent(btn_koreksi)
                    .addComponent(btn_hapus)
                    .addComponent(btn_batal)
                    .addComponent(btn_keluar))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        aktif(true);
        setTombol(false);
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        // TODO add your handling code here:
        String tKode = txtKode.getText();
        String tNama = txtNama.getText();
        String tAlamat = txtAlamat.getText();
        String tKota = txtKota.getText();
        String tKodePos = txtKodePos.getText();
        String tTelpon = txtTlp.getText();
        String tEmail = txtEmail.getText();

        try{
            if (edit == true) {
                stm.executeUpdate("UPDATE `konsumen` SET `nm_kons` = '"+tNama+"', `alm_kons` = '"+tAlamat+"', `kota_kons` = '"+tKota+"', `kd_pos` = '"+tKodePos+"', `phone` = '"+tTelpon+"', `email` = '"+tEmail+"' WHERE `konsumen`.`kd_kons` = '"+tKode+"';");
            }else{
                stm.executeUpdate("INSERT INTO `konsumen` (`kd_kons`, `nm_kons`, `alm_kons`, `kota_kons`, `kd_pos`, `phone`, `email`) VALUES ('"+ tKode +"', '"+ tNama +"', '"+ tAlamat +"', '"+ tKota +"', '"+ tKodePos +"', '"+ tTelpon +"', '"+ tEmail +"');");
            }
            tblKonsumen.setModel(new DefaultTableModel (dataTable, header));
            baca_data();
            aktif(false);
            setTombol(true);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_koreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_koreksiActionPerformed
        // TODO add your handling code here:
        edit = true;
        aktif(true);
        setTombol(false);
        txtKode.setEditable(false);
    }//GEN-LAST:event_btn_koreksiActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        try{
            String sql="delete from konsumen where kd_kons='" + txtKode.getText() + "'";
            stm.executeUpdate(sql);
            baca_data();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        aktif(false);
        setTombol(true);
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void tblKonsumenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKonsumenMouseClicked
        // TODO add your handling code here:
        setField();
    }//GEN-LAST:event_tblKonsumenMouseClicked

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
            java.util.logging.Logger.getLogger(Konsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Konsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Konsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Konsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Konsumen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_koreksi;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblKonsumen;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtKodePos;
    private javax.swing.JTextField txtKota;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTlp;
    // End of variables declaration//GEN-END:variables
}
