/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test1;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Lucky
 */
public class testSoal extends javax.swing.JFrame {

    /**
     * Creates new form testSoal
     */
    Connection con = Test1.getConnection();
    Statement st;
    ResultSet rs;
    int no_soal = 0;
    int check_jawaban = -1;
    
    public testSoal() {
        initComponents();
        showSoal(1);
    }
    
    public void checkJawaban(){
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM soal WHERE `id_soal`='"+no_soal+"'");
            if (rs.next()) {
                jTextArea1.setText(rs.getString("jawaban_benar"));
            }else{
                no_soal = 0;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        no_soal++;
    }
    
    public char getAnswer(){
        char value = 0;
        if (jRadioButton1.isSelected()) {
            value = 'a';
        }
        else if (jRadioButton2.isSelected()) {
            value = 'b';
        }
        else if (jRadioButton3.isSelected()) {
            value = 'c';
        }
        else if (jRadioButton4.isSelected()) {
            value = 'd';
        }
        return value;
    }
    
    public String checkAnswer(){
        String jawaban_benar, keterangan = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM soal WHERE `id_soal`='"+ (no_soal-1) +"'");
            if (rs.next()) {
                jawaban_benar = rs.getString("jawaban_benar");
                System.out.println("jawaban benar no " + (no_soal-1) + " : " + jawaban_benar);
                if (jawaban_benar.charAt(0) == getAnswer()) {
                    keterangan = "Benar";
                }else{
                    keterangan = "Salah";
                }
//                JOptionPane.showMessageDialog(null, "Jawaban " + getAnswer() + " yang benar " + checkAnswer());
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return keterangan;
    }
    
    public void showSoal(int i){
        if (i == 1) {
            no_soal++;
        }else{
            if (no_soal == 1) {
               JOptionPane.showMessageDialog(null, "Sudah nomor terakhir!");
            }else{
                no_soal--;
            }
        }
        System.out.println(no_soal);
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM soal WHERE `id_soal`='"+no_soal+"'");
            if (rs.next()) {
                jTextArea1.setText(no_soal + ". " + rs.getString("soal"));
                jRadioButton1.setText("a. " + rs.getString("jawaban_a"));
                jRadioButton2.setText("b. " + rs.getString("jawaban_b"));
                jRadioButton3.setText("c. " + rs.getString("jawaban_c"));
                jRadioButton4.setText("d. " + rs.getString("jawaban_d"));
                System.out.println("Jawaban soal nomor " + (no_soal-1) + " adalah: " + getAnswer() + " jawabannya " + checkAnswer());
            }else{
                no_soal = 0;
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        buttonGroup1.clearSelection();
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Selanjutnya");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("radio1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("radio2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("radio3");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("radio4");

        jButton2.setText("Kembali");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        showSoal(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        showSoal(0);
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
            java.util.logging.Logger.getLogger(testSoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(testSoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(testSoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(testSoal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new testSoal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
