/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connect.ConnectSQLServer;
import constance.Constance;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.LoaiTB;
import model.ThietBi;

/**
 *
 * @author 84392
 */
public class FThongKeTheoLoaiTB extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ArrayList<ThietBi> listtb;

    /**
     * Creates new form FThongKeTheoLoaiTB
     */
    public FThongKeTheoLoaiTB() throws SQLException {
        initComponents();
        listtb = new ArrayList<>();
        conn = ConnectSQLServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        showComboMaLoai();
        tblThongKeTheoLoaiTB.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã TB", "Tên TB", "Ngày Sản Xuất", "Thời Gian Bảo Hành", "Giá Mua", "DVT", "Tên Loại"
                }
        ));
    }

    private void showData(String s) throws SQLException {

        tblThongKeTheoLoaiTB.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã TB", "Tên TB", "Ngày Sản Xuất", "Thời Gian Bảo Hành", "Giá Mua", "DVT", "Tên Loai",}
        ));
        listtb.clear();

        //=============
        if (conn != null) {
            try {

                String sql = "";

                // String sql = "select THIETBI.matb, THIETBI.tentb, THIETBI.ngaysx, THIETBI.thoigianbaohanh, THIETBI.giamua, LOAITB.tenloai, THIETBI.dvt, THIETBI.maloai\n"
                //       + "FROM THIETBI THIETBI, LOAITB LOAITB where LOAITB.maloai = THIETBI.maloai AND (matb like '%" + s + "%' or tentb like '%" + s + "%' )";
                if (s.equalsIgnoreCase("ALL")) {

                    sql = "SELECT THIETBI.matb, THIETBI.tentb, THIETBI.ngaysx, THIETBI.thoigianbaohanh, THIETBI.dvt, THIETBI.giamua, LOAITB.maloai AS Expr1, LOAITB.tenloai\n"
                            + "FROM   LOAITB LOAITB, THIETBI THIETBI\n"
                            + "WHERE LOAITB.maloai = THIETBI.maloai";

                } else {

                    sql = "SELECT THIETBI.matb, THIETBI.tentb, THIETBI.ngaysx, THIETBI.thoigianbaohanh, THIETBI.dvt, THIETBI.giamua, LOAITB.maloai AS Expr1, LOAITB.tenloai\n"
                            + "FROM   LOAITB LOAITB, THIETBI THIETBI\n"
                            + "WHERE LOAITB.maloai = THIETBI.maloai and LOAITB.maloai = '" + s + "' ";

                }

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String matb = rs.getString("matb");
                    String tentb = rs.getString("tentb");
                    Date date = rs.getDate("ngaysx");
                    String tgbh = rs.getString("thoigianbaohanh");
                    Float giamua = rs.getFloat("giamua");
                    String dvt = rs.getString("dvt");
                    String tenloai = rs.getString("tenloai");
                    String a[] = new String[]{
                        matb, tentb, date.toString(), tgbh, giamua.toString(), dvt, tenloai};
                    //System.out.println("" + a);
                    listtb.add(new ThietBi(matb, tentb, date, tgbh, giamua, dvt, tenloai));
                    ((DefaultTableModel) tblThongKeTheoLoaiTB.getModel()).addRow(a);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FThietBi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void showComboMaLoai() {
        if (conn != null) {
            try {
                String sql = "select maloai,tenloai from LOAITB";
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);
                jcbMaLoai.addItem(new LoaiTB("ALL", "Tất cả"));
                while (rs.next()) {
                    String maloai = rs.getString("maloai");
                    String tenloai = rs.getString("tenloai");
                    LoaiTB p = new LoaiTB(maloai, tenloai);
                    jcbMaLoai.addItem(p);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FThietBi.class.getName()).log(Level.SEVERE, null, ex);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKeTheoLoaiTB = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jcbMaLoai = new javax.swing.JComboBox<LoaiTB>();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblThongKeTheoLoaiTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblThongKeTheoLoaiTB.setRowHeight(25);
        jScrollPane1.setViewportView(tblThongKeTheoLoaiTB);

        jLabel1.setText("Chọn Loại TB");

        jcbMaLoai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbMaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMaLoaiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Thông Kê Thiết Bị Theo Loại");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jcbMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExit))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(jcbMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(jButton1))
                .addGap(69, 69, 69))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMaLoaiActionPerformed
        try {
            System.out.println("aa");
            LoaiTB item = (LoaiTB) jcbMaLoai.getSelectedItem();

            System.out.println(item.getMaloai());
            showData(item.getMaloai());
        } catch (SQLException ex) {
            Logger.getLogger(FThongKeTheoLoaiTB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbMaLoaiActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        try {
//            // TODO add your handling code here:
//            Maloai<String, Object> maloai = new HashMap<>();
//            LoaiTB item = (LoaiTB) jcbMaLoai.getSelectedItem();
//            String userDirectory = Paths.get("").toAbsolutePath().toString();
//            System.out.println(userDirectory);
//            maloai.put("para_1", item.getMaloai());
//            JasperDesign jd = JRXmlLoader.load(userDirectory + "\\src\\view\\report1.jrxml");
//            JasperReport jr = JasperCompileManager.compileReport(userDirectory + "\\src\\view\\report1.jrxml");
//            JasperPrint jp = JasperFillManager.fillReport(jr, maloai, conn);
//            JasperViewer.viewReport(jp);
//            JasperExportManager.exportReportToPdfFile(jp, "c:\\test\\test.pdf");
//
//        } catch (JRException ex) {
//            Logger.getLogger(FThongKeTheoLoaiTB.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FThongKeTheoLoaiTB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FThongKeTheoLoaiTB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FThongKeTheoLoaiTB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FThongKeTheoLoaiTB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FThongKeTheoLoaiTB().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FThongKeTheoLoaiTB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<LoaiTB> jcbMaLoai;
    private javax.swing.JTable tblThongKeTheoLoaiTB;
    // End of variables declaration//GEN-END:variables
}
