/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connect.ConnectSQLServer;
import constance.Constance;
import java.awt.print.PrinterException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.PhongBan;
import model.ThietBi;

/**
 *
 * @author 84392
 */
public class FThongKeTheoPhong extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ArrayList<ThietBi> listtb;

    /**
     * Creates new form FThongKeTheoPhong
     */
    public FThongKeTheoPhong() throws SQLException {
        initComponents();
        listtb = new ArrayList<>();
        conn = ConnectSQLServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        showComboMaPhong();
        tblThongKeTheoPhong.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã PB", "Tên PB", "Mã TB", "Tên TB", "Ngày Sản Xuất", "Thời Gian Bảo Hành", "Giá Mua", "DVT", "Tên Nhân Viên", "Số Lượng", "Ngày Trang Bị", "Trạng Thái"
                }
        ));
    }

    private void showData(String s) throws SQLException {

        tblThongKeTheoPhong.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã PB", "Tên PB", "Mã TB", "Tên TB", "Ngày Sản Xuất", "Thời Gian Bảo Hành", "Giá Mua", "DVT", "Tên Nhân Viên", "Số Lượng", "Ngày Trang Bị", "Trạng Thái"
                }
        ));
        listtb.clear();

        //=============
        if (conn != null) {
            try {

                String sql = "";

                // String sql = "select THIETBI.matb, THIETBI.tentb, THIETBI.ngaysx, THIETBI.thoigianbaohanh, THIETBI.giamua, LOAITB.tenloai, THIETBI.dvt, THIETBI.maloai\n"
                //       + "FROM THIETBI THIETBI, LOAITB LOAITB where LOAITB.maloai = THIETBI.maloai AND (matb like '%" + s + "%' or tentb like '%" + s + "%' )";
                if (s.equalsIgnoreCase("ALL")) {

                    sql = "SELECT PHONGBAN.map, PHONGBAN.tenp, THIETBI.matb, THIETBI.tentb, THIETBI.ngaysx, THIETBI.thoigianbaohanh, THIETBI.giamua, THIETBI.dvt, NHANVIEN.tennv, PHANCONG.soluong, PHANCONG.ngaytrangbi, PHANCONG.trangthai\n"
                            + "FROM   PHANCONG INNER JOIN NHANVIEN \n"
                            + "ON PHANCONG.manv = NHANVIEN.manv INNER JOIN\n"
                            + "PHONGBAN ON PHANCONG.map = PHONGBAN.map INNER JOIN\n"
                            + "THIETBI ON PHANCONG.matb = THIETBI.matb INNER JOIN\n"
                            + "LOAITB ON THIETBI.maloai = LOAITB.maloai";

                } else {

                    sql = "SELECT PHONGBAN.map, PHONGBAN.tenp, THIETBI.matb, THIETBI.tentb, THIETBI.ngaysx, THIETBI.thoigianbaohanh, THIETBI.giamua, THIETBI.dvt, NHANVIEN.tennv, PHANCONG.soluong, PHANCONG.ngaytrangbi, PHANCONG.trangthai\n"
                            + "FROM   PHANCONG INNER JOIN NHANVIEN \n"
                            + "ON PHANCONG.manv = NHANVIEN.manv INNER JOIN\n"
                            + "PHONGBAN ON PHANCONG.map = PHONGBAN.map INNER JOIN\n"
                            + "THIETBI ON PHANCONG.matb = THIETBI.matb INNER JOIN\n"
                            + "LOAITB ON THIETBI.maloai = LOAITB.maloai\n"
                            + "WHERE  PHONGBAN.map = '" + s + "' ";

                }

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String map = rs.getString("map");
                    String tenp = rs.getString("tenp");
                    String matb = rs.getString("matb");
                    String tentb = rs.getString("tentb");
                    Date date = rs.getDate("ngaysx");
                    String tgbh = rs.getString("thoigianbaohanh");
                    Float giamua = rs.getFloat("giamua");
                    String dvt = rs.getString("dvt");
                    String tennv = rs.getString("tennv");
                    Float soluong = rs.getFloat("soluong");
                    Date ngaytrangbi = rs.getDate("ngaytrangbi");
                    String trangthai = rs.getString("trangthai");
                    String a[] = new String[]{
                        map, tenp, matb, tentb, date.toString(), tgbh, giamua.toString(), dvt, tennv, soluong.toString(), ngaytrangbi.toString(), trangthai};
                    //System.out.println("" + a);
                    listtb.add(new ThietBi(map, tenp, matb, tentb, date, tgbh, giamua, dvt, tennv, soluong, ngaytrangbi, trangthai));
                    ((DefaultTableModel) tblThongKeTheoPhong.getModel()).addRow(a);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FThietBi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void showComboMaPhong() {
        if (conn != null) {
            try {
                String sql = "select map,tenp from PHONGBAN";
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);
                jcbMaPhong.addItem(new PhongBan("ALL", "Tất cả"));
                while (rs.next()) {
                    String map = rs.getString("map");
                    String tenp = rs.getString("tenp");
                    PhongBan p = new PhongBan(map, tenp);
                    jcbMaPhong.addItem(p);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FThongKeTheoPhong.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        jcbMaPhong = new javax.swing.JComboBox<PhongBan>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKeTheoPhong = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Thống Kê Thiết Bị Theo Phòng");

        jcbMaPhong.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMaPhongActionPerformed(evt);
            }
        });

        jLabel1.setText("Chọn Mã Phòng");

        tblThongKeTheoPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblThongKeTheoPhong.setRowHeight(25);
        jScrollPane1.setViewportView(tblThongKeTheoPhong);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(227, 227, 227)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel1)
                                .addGap(29, 29, 29)
                                .addComponent(jcbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(588, 588, 588)
                                .addComponent(btnExit))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit)
                            .addComponent(jButton1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 569, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMaPhongActionPerformed
        try {
            PhongBan item = (PhongBan) jcbMaPhong.getSelectedItem();

            System.out.println(item.getMap());
            showData(item.getMap());
        } catch (SQLException ex) {
            Logger.getLogger(FThongKeTheoLoaiTB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbMaPhongActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        try {
//            // TODO add your handling code here:
//            Map<String, Object> map = new HashMap<>();
//            PhongBan item = (PhongBan) jcbMaPhong.getSelectedItem();
//            String userDirectory = Paths.get("")
//                    .toAbsolutePath()
//                    .toString();
//            System.out.println(userDirectory);
//            map.put("para_1", item.getMap());
//            JasperDesign jd = JRXmlLoader.load(userDirectory + "\\src\\report1.jrxml");
//            JasperReport jr = JasperCompileManager.compileReport(userDirectory + "\\src\\report1.jrxml");
//            JasperPrint jp = JasperFillManager.fillReport(jr, map, conn);
//            JasperViewer.viewReport(jp);
//            JasperExportManager.exportReportToPdfFile(jp, "c:\\test\\test.pdf");
//
//        } catch (JRException ex) {
//            Logger.getLogger(FThongKeTheoPhong.class.getName()).log(Level.SEVERE, null, ex);
//        }
        try {
            tblThongKeTheoPhong.print();
        } catch (PrinterException ex) {
            Logger.getLogger(FThongKeTheoLoaiTB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(FThongKeTheoPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FThongKeTheoPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FThongKeTheoPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FThongKeTheoPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FThongKeTheoPhong().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FThongKeTheoPhong.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<PhongBan> jcbMaPhong;
    private javax.swing.JTable tblThongKeTheoPhong;
    // End of variables declaration//GEN-END:variables
}
