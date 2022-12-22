/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connect.ConnectSQLServer;
import constance.Constance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84392
 */
public class FNhanVien extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    int flag = 0;

    /**
     * Creates new form FNhanVien
     */
    public FNhanVien() throws SQLException {

        conn = ConnectSQLServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        initComponents();
        showData("");
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
    }

    private void showData(String s) throws SQLException {

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã Nhân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Địa Chỉ", "Giới Tính",}
        ));

        if (conn != null) {
            try {
                String sql = "select manv,tennv, sdtnv, diachi, gioitinh from NHANVIEN where manv like '%" + s + "%' or tennv like '%" + s + "%' ";
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String manv = rs.getString("manv");
                    String tennv = rs.getString("tennv");
                    String sdtnv = rs.getString("sdtnv");
                    String diachi = rs.getString("diachi");
                    boolean gt = rs.getBoolean("gioitinh");
                    String gioitinh = "";
                    if (gt == true) {
                        gioitinh = "Nam";
                    } else {
                        gioitinh = "Nữ";
                    }
                    String a[] = new String[]{
                        manv, tennv, sdtnv, diachi, gioitinh
                    };
                    System.out.println("" + a);
                    ((DefaultTableModel) tblNhanVien.getModel()).addRow(a);

                }
            } catch (SQLException ex) {
                Logger.getLogger(FNhanVien.class.getName()).log(Level.SEVERE, null, ex);
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

        grbtnSex = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tftMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tftTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jrdMale = new javax.swing.JRadioButton();
        jrdFemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        tftDiaChi = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tftSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        tftSdtnv = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Thông tin nhân viên");

        jLabel2.setText("Mã NV");

        jLabel3.setText("Tên");

        jLabel4.setText("Giới tính");

        grbtnSex.add(jrdMale);
        jrdMale.setSelected(true);
        jrdMale.setText("Nam");
        jrdMale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        grbtnSex.add(jrdFemale);
        jrdFemale.setText("Nữ");
        jrdFemale.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel6.setText("Địa chỉ");

        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Xoá");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnEdit.setText("Sửa");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setText("Lưu");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReload.setText("Làm mới");
        btnReload.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 102, 255));
        jLabel8.setText("Danh sách nhân viên");

        btnSearch.setText("Tìm");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNhanVien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblNhanVien.setRowHeight(25);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jLabel9.setText("Số điện thoại");

        tftSdtnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftSdtnvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tftDiaChi)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tftMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jrdMale)
                                                .addGap(18, 18, 18)
                                                .addComponent(jrdFemale)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(3, 3, 3)
                                                .addComponent(tftSdtnv))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(tftTen))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnAdd)
                                .addGap(39, 39, 39)
                                .addComponent(btnDelete)
                                .addGap(36, 36, 36)
                                .addComponent(btnEdit)
                                .addGap(40, 40, 40)
                                .addComponent(btnSave)
                                .addGap(42, 42, 42)
                                .addComponent(btnReload)
                                .addGap(33, 33, 33)
                                .addComponent(btnExit)
                                .addGap(0, 116, Short.MAX_VALUE)))
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(tftSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1)))
                .addGap(250, 250, 250))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tftMaNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tftTen, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrdFemale)
                    .addComponent(jrdMale)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tftSdtnv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tftDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd)
                        .addComponent(btnReload)
                        .addComponent(btnExit)
                        .addComponent(btnSave)))
                .addGap(27, 27, 27)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tftSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String s = tftSearch.getText();
        try {
            showData(s);
        } catch (SQLException ex) {
            Logger.getLogger(FPhongban.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        flag = 1;
        tftMaNV.requestFocus();
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        tftMaNV.setText("");
        tftTen.setText("");
        tftDiaChi.setText("");
        tftSdtnv.setText("");
        grbtnSex.clearSelection();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tftSdtnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftSdtnvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tftSdtnvActionPerformed

    private void btnReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadActionPerformed
        try {
            showData("");
        } catch (SQLException ex) {
            Logger.getLogger(FPhongban.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnAdd.setEnabled(true); //Sáng
        btnEdit.setEnabled(false); //mo
        btnSave.setEnabled(false);
        tftMaNV.setText("");
        tftTen.setText("");
        tftDiaChi.setText("");
        tftSdtnv.setText("");
        grbtnSex.clearSelection();
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int luaChon = JOptionPane.showConfirmDialog(
                this,
                "Bạn có muốn thoải khỏi chương trình?",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        String manv = tftMaNV.getText();
        String tennv = tftTen.getText();
        //String gioitinh = (String)grbtnSex.getSelectedItem()
        int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa dữ liệu " + tennv + " ?", "Thông báo",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        System.out.println("" + input);
        if (input == 0) { // nhấn vào ok
            try {

                String sql = "delete from NHANVIEN where manv='" + manv + "'";
                Statement stmt = conn.createStatement();

                int kq = stmt.executeUpdate(sql);
                if (kq > 0) {
                    JOptionPane.showMessageDialog(null, "<html><b style=\"color:red\">Waitting</b></html>", "Messege", JOptionPane.INFORMATION_MESSAGE);
                    System.out.print("dang load");
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

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked

        int row = tblNhanVien.getSelectedRow();
        System.out.println("" + row);
        String manv = tblNhanVien.getModel().getValueAt(row, 0).toString();
        String tennv = tblNhanVien.getModel().getValueAt(row, 1).toString();
        String sdtnv = tblNhanVien.getModel().getValueAt(row, 2).toString();
        String diachi = tblNhanVien.getModel().getValueAt(row, 3).toString();
        String gt = tblNhanVien.getModel().getValueAt(row, 4).toString();
        if (gt.equalsIgnoreCase("nam")) {
            jrdMale.setSelected(true);
        } else {
            jrdFemale.setSelected(true);
        }

        tftMaNV.setText(manv);
        tftTen.setText(tennv);
        tftSdtnv.setText(sdtnv);
        tftDiaChi.setText(diachi);

        btnEdit.setEnabled(true);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (flag == 1) {
            if (tftMaNV.getText().equals("") || tftTen.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter All Data!");
            } else {
                try {
                    // TODO add your handling code here
                    String manv = tftMaNV.getText();
                    String tennv = tftTen.getText();
                    String sdtnv = tftSdtnv.getText();
                    String diachi = tftDiaChi.getText();
                    boolean gioitinh = false;
                    if (jrdMale.isSelected()) {
                        System.out.println("Nam");
                        gioitinh = true;
                    } else if (jrdFemale.isSelected()) {
                        System.out.println("Nữ");
                        gioitinh = false;
                    }
                    String sql = "insert into NHANVIEN(manv,tennv, sdtnv, diachi, gioitinh) values(N'" + manv + "',N'" + tennv + "',N'" + sdtnv + "',N'" + diachi + "',N'" + gioitinh + "')";
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
                String manv = tftMaNV.getText();
                String tennv = tftTen.getText();
                String sdtnv = tftSdtnv.getText();
                String diachi = tftDiaChi.getText();
                ButtonModel gioitinh = grbtnSex.getSelection();
                String sql = "UPDATE NHANVIEN set tennv=N'" + tennv + "', sdtnv=N'" + sdtnv + "', diachi=N'" + diachi + "', gioitinh=N'" + gioitinh + "' where manv='" + manv + "'";
                Statement stmt = conn.createStatement();
                int kq = stmt.executeUpdate(sql);
                if (kq > 0) {
                    JOptionPane.showMessageDialog(null, "Update susscessfully");
                    showData("");
                    System.out.println("Được");
                    System.out.println(stmt);
                    System.out.println(sql);
                    System.out.println(kq);
                } else {
                    System.out.println("Ko Được");
                    System.out.println(stmt);
                    System.out.println(sql);
                    System.out.println(kq);
                    JOptionPane.showMessageDialog(null, "Update not susscessfully");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(FNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FNhanVien().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FNhanVien.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnSearch;
    private javax.swing.ButtonGroup grbtnSex;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jrdFemale;
    private javax.swing.JRadioButton jrdMale;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField tftDiaChi;
    private javax.swing.JTextField tftMaNV;
    private javax.swing.JTextField tftSdtnv;
    private javax.swing.JTextField tftSearch;
    private javax.swing.JTextField tftTen;
    // End of variables declaration//GEN-END:variables
}
