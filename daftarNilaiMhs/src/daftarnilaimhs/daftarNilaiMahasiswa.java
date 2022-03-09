/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package daftarnilaimhs;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
/**
 *
 * @author Lucky
 */

public class daftarNilaiMahasiswa extends javax.swing.JFrame {

    /**
     * Creates new form daftarNilaiMahasiswa
     */
    public daftarNilaiMahasiswa() {
        initComponents();
        ShowData();
    }

    
    public void ShowData(){
        int a = 0, temp = 0;
        Date tanggal = new Date();
        Scanner inUser = new Scanner(System.in);
        System.out.print("Masukan jumlah data: ");
        String[] ket = {"Nim : ", "Nama : ", "Teori : ", "Praktek : "};
        a = inUser.nextInt();
        String[][] data = new String[a][4];
        DefaultTableModel model = (DefaultTableModel) show_data.getModel();
        
        
        Label1.setText("Jumlah Mahasiswa : " + a );
        
        System.out.println(tanggal);
        for (int i = 0; i < data.length; i++) {
            String[] row = new String[data[i].length];
            System.out.printf("===== DATA MAHASISWA KE-%d =====\n", i+1);            
            for (int j = 0; j < data[i].length; j++) {
                if (j == 0) {
                    temp += 1;
                    String tempS = Integer.toString(temp);
                    row[j] = tempS;
                }else{
                    System.out.print(ket[j]);
                    row[j] = inUser.next();                    
                }
            }
            model.addRow(row);
            System.out.println("===============================\n");
        }
        
        int x = model.getColumnCount();
        int y = model.getRowCount();
        
        System.out.println("x = " + x);
        System.out.println("y = " + y);
//        for (int i = 0; i < banyak_data; i++) {
//            String[] row = new String[data[i].length];
//            
//            for (int j = 0; j < banyak_data; j++) {
//                row[j] = data[i][j];
//            }
//            model.addRow(row);
//        }
        
        ArrayList<String> temp_data = new ArrayList<String>();
        String[][] data_baru = new String[y][x];
        
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
//                (row, coloumn)
//                System.out.println(j);
                temp_data.add(model.getValueAt(i, j).toString());
                data_baru[i][j] = temp_data.toString();
            }
        }
        
        for (int i = 0; i < data_baru.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < data_baru[i].length; j++) {
                System.out.print(data_baru[i][j] + " ");
            }
            System.out.print("]\n");
        }
        
        System.out.println(data_baru[2][0]);
//        
//        for (int i = 0; i < new_data.size(); i++) {
//            System.out.println(new_data.get(i));
//        }
//        ArrayList<String> numdata = new ArrayList<String>();
//        for (int i = 0; i < model.getRowCount(); i++) {
////            arrayBaru.add(model.getValueAt(perhitungan, data_keberapa)
//            numdata.add(model.getValueAt(i, 1).toString());
//        }
//        for (String x : numdata){
//            System.out.println(x);
//            if (x.equals("lucky")) {
//                Label2.setText("Selamat Data Admin");
//            }
//        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        show_data = new javax.swing.JTable();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        show_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nim", "Nama", "Teori", "Praktek"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(show_data);

        Label1.setText("Total Mahasiswa");

        Label2.setText("Total Mahasiswa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(daftarNilaiMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(daftarNilaiMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(daftarNilaiMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(daftarNilaiMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new daftarNilaiMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable show_data;
    // End of variables declaration//GEN-END:variables
}