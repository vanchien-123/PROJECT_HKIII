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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;
import model.PhanCong;
import model.PhongBan;
import model.ThietBi;

/**
 *
 * @author 84392
 */
public class FPhanCong extends javax.swing.JFrame {

    private NhanVien nhanvien;
    private PhongBan phongban;
    private ThietBi thietbi;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ArrayList<PhanCong> listPC;
    int flag = 0;

    /**
     * Creates new form FPhanCong
     */
    public FPhanCong() throws SQLException {
        conn = ConnectSQLServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        initComponents();
        jcbTrangThai.addItem("Đã sử dụng");
        jcbTrangThai.addItem("Chưa sử dụng");
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
        listPC = new ArrayList<>();
        conn = ConnectSQLServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        tblPhanCong.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã NV", "Mã PB", "Mã TB", "Số Lượng", "Ngày Trang Bị", "Trang Thái"
                }
        ));
        showData("");
        showComboMaNV();
        showComboMaP();
        showComboMaTB();
    }

    private void showData(String s) throws SQLException {
        listPC.clear();
        tblPhanCong.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã NV", "Mã PB", "Mã TB", "Số Lượng", "Ngày Trang Bị", "Trang Thái"}
        ));

        if (conn != null) {
            try {
                String sql = "select * from PHANCONG where matb like '%" + s + "%' or manv like '%" + s + "%' or map like '%" + s + "%' ";
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String manv = rs.getString("manv");
                    String map = rs.getString("map");
                    String matb = rs.getString("matb");
                    Float soluong = rs.getFloat("soluong");
                    Date date = rs.getDate("ngaytrangbi");
                    String trangthai = rs.getString("trangthai");

                    String a[] = new String[]{
                        manv, map, matb, soluong.toString(), date.toString(), trangthai};
                    //System.out.println("" + a);
                    listPC.add(new PhanCong(manv, map, matb, soluong, date, trangthai));
                    ((DefaultTableModel) tblPhanCong.getModel()).addRow(a);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FPhanCong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void showComboMaNV() {
        if (conn != null) {
            try {
                String sql = "select manv,tennv from NHANVIEN";
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String manv = rs.getString("manv");
                    String tennv = rs.getString("tennv");
                    NhanVien nv = new NhanVien(manv, tennv);
                    jcbMaNV.addItem(nv);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FPhanCong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void showComboMaP() {
        if (conn != null) {
            try {
                String sql = "select map,tenp from PHONGBAN";
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String map = rs.getString("map");
                    String tenp = rs.getString("tenp");
                    PhongBan pb = new PhongBan(map, tenp);
                    jcbMaPhong.addItem(pb);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FPhanCong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void showComboMaTB() {
        if (conn != null) {
            try {
                String sql = "select matb,tentb from THIETBI";
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String matb = rs.getString("matb");
                    String tentb = rs.getString("tentb");
                    ThietBi tb = new ThietBi(matb, tentb);
                    jcbMaTB.addItem(tb);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FPhanCong.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbMaNV = new javax.swing.JComboBox<NhanVien>();
        jcbMaTB = new javax.swing.JComboBox<ThietBi>();
        jcbMaPhong = new javax.swing.JComboBox<PhongBan>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jcbTrangThai = new javax.swing.JComboBox();
        tftQuantity = new javax.swing.JTextField();
        jdcNgayTrangBi = new com.toedter.calendar.JDateChooser();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPhanCong = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Mã Nhân Viên");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Phân Công Quản Lí Thiết Bị");

        jLabel3.setText("Mã Phòng");

        jLabel4.setText("Mã Thiết Bị");

        jLabel5.setText("Số Lượng");

        jLabel6.setText("Ngày Trang Bị");

        jLabel7.setText("Trạng Thái");

        jdcNgayTrangBi.setDateFormatString("yyyy - MMM - dd");

        btnAdd.setText("Add");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReload.setText("Reload");
        btnReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblPhanCong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPhanCong.setRowHeight(25);
        jScrollPane1.setViewportView(tblPhanCong);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(btnAdd)
                        .addGap(26, 26, 26)
                        .addComponent(btnEdit)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(27, 27, 27)
                        .addComponent(btnSave)
                        .addGap(26, 26, 26)
                        .addComponent(btnReload)
                        .addGap(18, 18, 18)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdcNgayTrangBi, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tftQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jcbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(jcbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(245, 245, 245))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tftQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcNgayTrangBi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnReload)
                    .addComponent(btnSave)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        flag = 1;
        jcbMaNV.requestFocus();
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        tftQuantity.setText("");
        ((JTextField) jdcNgayTrangBi.getDateEditor().getUiComponent()).setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        NhanVien manv = (NhanVien) jcbMaNV.getSelectedItem();
        ThietBi matb = (ThietBi) jcbMaTB.getSelectedItem();
        int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa dữ liệu " +  manv + " ?", "Thông báo",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        System.out.println("" + input);
        if (input == 0) { // nhấn vào ok
            try {

                String sql = "delete from PHANCONG where matb='" + matb + "'";
                Statement stmt = conn.createStatement();

                int kq = stmt.executeUpdate(sql);
                if (kq > 0) {
                    JOptionPane.showMessageDialog(null, "Delete susscessfully");
                    showData("");
                } else {
                    JOptionPane.showMessageDialog(null, "Delete not susscessfully");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        flag = 2;
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (flag == 1) {
            if (jcbMaNV.getSelectedItem().equals("") || jcbMaPhong.getSelectedItem().equals("") || jcbMaTB.getSelectedItem().equals("") || tftQuantity.getText().equals("") || jcbTrangThai.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter All Data!");
            } else {
                try {
                    NhanVien NV = (NhanVien) jcbMaNV.getSelectedItem();
                    PhongBan PB = (PhongBan) jcbMaPhong.getSelectedItem();
                    ThietBi TB = (ThietBi) jcbMaTB.getSelectedItem();
                    String soluong = tftQuantity.getText();
                    String date = ((JTextField) jdcNgayTrangBi.getDateEditor().getUiComponent()).getText();
                    String trangthai = (String) jcbTrangThai.getSelectedItem();

                    String sql = "insert into PHANCONG(manv,map, matb, soluong, ngaytrangbi, trangthai) values(N'" + NV.getManv() + "',N'" + PB.getMap() + "',N'" + TB.getMatb() + "',N'" + soluong + "',N'" + date + "',N'" + trangthai + "')";
                    Statement stmt = conn.createStatement();
                    int kq = stmt.executeUpdate(sql);
                    if (kq > 0) {
                        JOptionPane.showMessageDialog(null, "Insert successfully");
                        showData("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Insert not successfully");
                    }
                } catch (SQLException ex) {
                    //                    JOptionPane.showMessageDialog(null, ex);
                    System.out.println(ex);
                }
            }
        } else if (flag == 2) {

            try {
                // TODO add your handling code here:
                NhanVien NV = (NhanVien) jcbMaNV.getSelectedItem();
                PhongBan PB = (PhongBan) jcbMaPhong.getSelectedItem();
                ThietBi TB = (ThietBi) jcbMaTB.getSelectedItem();
                String soluong = tftQuantity.getText();
                String date = ((JTextField) jdcNgayTrangBi.getDateEditor().getUiComponent()).getText();
                String trangthai = (String) jcbTrangThai.getSelectedItem();

                String sql = "UPDATE THIETBI set  map=N'" + PB.getMap() + "', matb=N'" + TB.getMatb() + "', soluong=N'" + soluong + "', ngaytrangbi=N'" + date.toString() + "', trangthai=N'" + trangthai + "' where manv='" + NV.getManv() + "'";
                Statement stmt = conn.createStatement();
                int kq = stmt.executeUpdate(sql);
                if (kq > 0) {
                    JOptionPane.showMessageDialog(null, "Update susscessfully");
                    showData("");
                    System.out.println("Được");
                } else {
                    System.out.println("Ko Được");
                    JOptionPane.showMessageDialog(null, "Update not susscessfully");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        try {
            showData("");
        } catch (SQLException ex) {
            Logger.getLogger(FPhongban.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btnAdd.setEnabled(true); //Sáng
        btnEdit.setEnabled(false); //mo
        btnSave.setEnabled(false);
        tftQuantity.setText("");
        ((JTextField) jdcNgayTrangBi.getDateEditor().getUiComponent()).setText("");
    }//GEN-LAST:event_btnReloadActionPerformed

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
            java.util.logging.Logger.getLogger(FPhanCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPhanCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPhanCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPhanCong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FPhanCong().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FPhanCong.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReload;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<NhanVien> jcbMaNV;
    private javax.swing.JComboBox<PhongBan> jcbMaPhong;
    private javax.swing.JComboBox<ThietBi> jcbMaTB;
    private javax.swing.JComboBox jcbTrangThai;
    private com.toedter.calendar.JDateChooser jdcNgayTrangBi;
    private javax.swing.JTable tblPhanCong;
    private javax.swing.JTextField tftQuantity;
    // End of variables declaration//GEN-END:variables
}
