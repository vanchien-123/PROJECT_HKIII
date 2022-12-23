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
import model.LoaiTB;
import model.ThietBi;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author 84392
 */
public class FThietBi extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ArrayList<ThietBi> listtb;
    int flag = 0;

    /**
     * Creates new form FThietBi1
     */
    public FThietBi() throws SQLException {
        conn = ConnectSQLServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        initComponents();
        jcbDVT.addItem("VNĐ");
        jcbDVT.addItem("USD");
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(false);
        listtb = new ArrayList<>();
        conn = ConnectSQLServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        tblThietBi.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã TB", "Tên TB", "Ngày Sản Xuất", "Thời Gian Bảo Hành", "Giá Mua", "DVT", "Mã Loại", "Tên Loại"
                }
        ));
        showData("");
        showComboMaLoai();

    }

    private void showData(String s) throws SQLException {
        listtb.clear();
        tblThietBi.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Mã TB", "Tên TB", "Ngày Sản Xuất", "Thời Gian Bảo Hành", "Giá Mua", "Đơn Vị Tính", "Mã Loại", "Tên Loai",}
        ));

        if (conn != null) {
            try {
                String sql = "select THIETBI.matb, THIETBI.tentb, THIETBI.ngaysx, THIETBI.thoigianbaohanh, THIETBI.giamua, LOAITB.tenloai, THIETBI.dvt, THIETBI.maloai\n"
                        + "FROM THIETBI THIETBI, LOAITB LOAITB where LOAITB.maloai = THIETBI.maloai AND (matb like '%" + s + "%' or tentb like '%" + s + "%' )";
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String matb = rs.getString("matb");
                    String tentb = rs.getString("tentb");
                    Date date = rs.getDate("ngaysx");
                    String tgbh = rs.getString("thoigianbaohanh");
                    Float giamua = rs.getFloat("giamua");
                    String dvt = rs.getString("dvt");
                    String maloai = rs.getString("maloai");
                    String tenloai = rs.getString("tenloai");
                    String a[] = new String[]{
                        matb, tentb, date.toString(), tgbh, giamua.toString(), dvt, maloai, tenloai};
                    //System.out.println("" + a);
                    listtb.add(new ThietBi(matb, tentb, date, tgbh, giamua, dvt, maloai, tenloai));
                    ((DefaultTableModel) tblThietBi.getModel()).addRow(a);

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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnReload = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        tftMaTB = new javax.swing.JTextField();
        tftTenTB = new javax.swing.JTextField();
        jdcDate = new com.toedter.calendar.JDateChooser();
        tftDateTime = new javax.swing.JTextField();
        tftGiaMua = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        tftSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThietBi = new javax.swing.JTable();
        jcbMaLoai = new javax.swing.JComboBox<LoaiTB>();
        jcbDVT = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Thông Tin Thiết Bị");

        jLabel2.setText("Mã Thiết Bị");

        jLabel3.setText("Tên Thiết Bị");

        jLabel4.setText("Ngày Sản Xuất");

        jLabel5.setText("Thời Hạn Bảo Hành");

        jLabel6.setText("Giá Mua");

        jLabel7.setText("Đơn vị Giá");

        jLabel8.setText("Mã Loại");

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

        jdcDate.setDateFormatString("yyyy - MMM - dd");
        jdcDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnSearch.setText("Search");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tftSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tftSearchMouseClicked(evt);
            }
        });
        tftSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tftSearchKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Danh Sách Thiết Bị");

        tblThietBi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblThietBi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblThietBi.setRowHeight(25);
        tblThietBi.setRowMargin(5);
        tblThietBi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThietBiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblThietBi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(tftMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel3)
                .addGap(119, 119, 119)
                .addComponent(tftTenTB, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel4)
                .addGap(102, 102, 102)
                .addComponent(jdcDate, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel5)
                .addGap(67, 67, 67)
                .addComponent(tftDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel6)
                .addGap(148, 148, 148)
                .addComponent(tftGiaMua, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel7)
                .addGap(131, 131, 131)
                .addComponent(jcbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel8)
                .addGap(151, 151, 151)
                .addComponent(jcbMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(btnAdd)
                .addGap(28, 28, 28)
                .addComponent(btnDelete)
                .addGap(34, 34, 34)
                .addComponent(btnEdit)
                .addGap(30, 30, 30)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnReload)
                .addGap(40, 40, 40)
                .addComponent(btnExit))
            .addGroup(layout.createSequentialGroup()
                .addGap(511, 511, 511)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(tftSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnSearch))
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tftMaTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tftTenTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(jdcDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5))
                    .addComponent(tftDateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(tftGiaMua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel7))
                    .addComponent(jcbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel8))
                    .addComponent(jcbMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnSave)
                    .addComponent(btnReload)
                    .addComponent(btnExit))
                .addGap(84, 84, 84)
                .addComponent(jLabel10)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tftSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        flag = 1;
        tftMaTB.requestFocus();
        btnAdd.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        tftMaTB.setText("");
        tftTenTB.setText("");
        tftGiaMua.setText("");
        tftDateTime.setText("");
        jcbMaLoai.setSelectedItem(-1);
        ((JTextField) jdcDate.getDateEditor().getUiComponent()).setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String matb = tftMaTB.getText();
        String tentb = tftTenTB.getText();
        int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc xóa dữ liệu " + tentb + " ?", "Thông báo",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        System.out.println("" + input);
        if (input == 0) { // nhấn vào ok
            try {

                String sql = "delete from THIETBI where matb='" + matb + "'";
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
            if (tftMaTB.getText().equals("") || tftTenTB.getText().equals("") || jcbDVT.getSelectedItem().equals("") || tftDateTime.getText().equals("") || tftGiaMua.getText().equals("") || jcbMaLoai.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Please Enter All Data!");
            } else {
                try {
                    String matb = tftMaTB.getText();
                    String tentb = tftTenTB.getText();
                    String date = ((JTextField) jdcDate.getDateEditor().getUiComponent()).getText();
                    String tgbh = tftDateTime.getText();
                    String giamua = tftGiaMua.getText();
                    String dvt = (String) jcbDVT.getSelectedItem();
                    LoaiTB TB = (LoaiTB) jcbMaLoai.getSelectedItem();

                    String sql = "insert into THIETBI(matb,tentb, ngaysx, thoigianbaohanh, giamua, dvt, maloai) values(N'" + matb + "',N'" + tentb + "',N'" + date + "',N'" + tgbh + "',N'" + giamua + "',N'" + dvt + "',N'" + TB.getMaloai() + "')";
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
                String matb = tftMaTB.getText();
                String tentb = tftTenTB.getText();
                String date = ((JTextField) jdcDate.getDateEditor().getUiComponent()).getText();
                String tgbh = tftDateTime.getText();
                String giamua = (String) tftGiaMua.getText();
                String dvt = (String) jcbDVT.getSelectedItem();
                LoaiTB TB = (LoaiTB) jcbMaLoai.getSelectedItem();

                String sql = "UPDATE THIETBI set  tentb=N'" + tentb + "', ngaysx=N'" + date + "', thoigianbaohanh=N'" + tgbh + "', giamua=N'" + giamua + "', dvt=N'" + dvt + "', maloai=N'" + TB.getMaloai() + "' where matb='" + matb + "'";
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
        btnAdd.setEnabled(true); 
        btnEdit.setEnabled(false); 
        btnSave.setEnabled(false);
        tftMaTB.requestFocus();
        

        tftMaTB.setText("");
        tftTenTB.setText("");
        tftDateTime.setText("");
        tftGiaMua.setText("");
        ((JTextField) jdcDate.getDateEditor().getUiComponent()).setText("");
    }//GEN-LAST:event_btnReloadActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void tblThietBiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThietBiMouseClicked
        btnEdit.setEnabled(true);

//        String a = tftGiaMua.getText();
//        float f = Float.parseFloat(a);
//        f.setText(listtb.get(row).getGiamua());
        int row = tblThietBi.getSelectedRow();
        System.out.println("" + listtb.get(row).getMatb());
        tftMaTB.setText(listtb.get(row).getMatb());
        tftTenTB.setText(listtb.get(row).getTentb());
        jdcDate.setDate(listtb.get(row).getNgaysx());
        tftDateTime.setText(listtb.get(row).getThoigianbaohanh());
        //jcbDVT.setSelectedItem(listtb.get(row).getDvt());
        jcbDVT.getModel().setSelectedItem(listtb.get(row).getDvt());
        jcbMaLoai.getModel().setSelectedItem(new LoaiTB(listtb.get(row).getMaloai(), listtb.get(row).getTenloai()));
        tftGiaMua.setText((listtb.get(row).getGiamua()).toString());


    }//GEN-LAST:event_tblThietBiMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String s = tftSearch.getText();
        try {
            showData(s);
        } catch (SQLException ex) {
            Logger.getLogger(FPhongban.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tftSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tftSearchMouseClicked
        //tftSearch.setText("");
    }//GEN-LAST:event_tftSearchMouseClicked

    private void tftSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftSearchKeyReleased
        String key = tftSearch.getText();

        try {

            String query = "SELECT * FROM THIETBI where tentb LIKE '%" + key + "%' or matb LIKE '%" + key + "%'";
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            tblThietBi.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                if (pst != null) {
                    rs.close();
                    pst.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_tftSearchKeyReleased

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
            java.util.logging.Logger.getLogger(FThietBi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FThietBi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FThietBi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FThietBi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FThietBi().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FThietBi.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbDVT;
    private javax.swing.JComboBox<LoaiTB> jcbMaLoai;
    private com.toedter.calendar.JDateChooser jdcDate;
    private javax.swing.JTable tblThietBi;
    private javax.swing.JTextField tftDateTime;
    private javax.swing.JTextField tftGiaMua;
    private javax.swing.JTextField tftMaTB;
    private javax.swing.JTextField tftSearch;
    private javax.swing.JTextField tftTenTB;
    // End of variables declaration//GEN-END:variables
}
