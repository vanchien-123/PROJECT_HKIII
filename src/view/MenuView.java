/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MenuController;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author 84392
 */
public class MenuView extends JFrame {

    private final JLabel jl;

    public MenuView() throws HeadlessException {

        MenuController handle = new MenuController(this);

        this.setTitle("QUẢN LÍ THIẾT BỊ");
        this.setSize(1200, 655);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // tạo thanh meunu
        JMenuBar jmb = new JMenuBar();

        // tạo các menu con
        JMenu jm_file = new JMenu("File");
        JMenuItem jmi_open = new JMenuItem("Open");
        jmi_open.addActionListener(handle);
        JMenuItem jmi_exit = new JMenuItem("Exit");
        jmi_exit.addActionListener(handle);
        jm_file.add(jmi_open);
        jm_file.addSeparator();
        jm_file.add(jmi_exit);

        JMenu jm_manager = new JMenu("Manager");

        JMenuItem jmi_thietbi = new JMenuItem("Thiết Bị", KeyEvent.VK_T);
        jmi_thietbi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_DOWN_MASK));
        jmi_thietbi.addActionListener(handle);
        JMenuItem jmi_nhanvien = new JMenuItem("Nhân Viên", KeyEvent.VK_N);
        jmi_nhanvien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        jmi_nhanvien.addActionListener(handle);
        JMenuItem jmi_phongban = new JMenuItem("Phòng Ban", KeyEvent.VK_P);
        jmi_phongban.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        jmi_phongban.addActionListener(handle);
        JMenuItem jmi_loaitb = new JMenuItem("Loại TB", KeyEvent.VK_L);
        jmi_loaitb.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        jmi_loaitb.addActionListener(handle);
        JMenuItem jmi_phancong = new JMenuItem("Phân Công", KeyEvent.VK_O);
        jmi_phancong.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        jmi_phancong.addActionListener(handle);

        jm_manager.add(jmi_thietbi);
        jm_file.addSeparator();
        jm_manager.add(jmi_nhanvien);
        jm_file.addSeparator();
        jm_manager.add(jmi_phongban);
        jm_file.addSeparator();
        jm_manager.add(jmi_loaitb);
        jm_file.addSeparator();
        jm_manager.add(jmi_phancong);

        JMenu jm_statistical = new JMenu("Statistical");
        
        JMenuItem jmi_thongketheoloai = new JMenuItem("Thống Kê Theo Loại", KeyEvent.VK_X);
        jmi_thongketheoloai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        jmi_thongketheoloai.addActionListener(handle);
        JMenuItem jmi_thongketheophong = new JMenuItem("Thống Kê Theo Phòng", KeyEvent.VK_S);
        jmi_thongketheophong.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        jmi_thongketheophong.addActionListener(handle);
        
        jm_statistical.add(jmi_thongketheoloai);
        jm_statistical.add(jmi_thongketheophong);

        JMenu jm_about = new JMenu("About");
        JMenuItem jmi_aboutme = new JMenuItem("About Me", KeyEvent.VK_X);
        jmi_aboutme.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
        jmi_aboutme.addActionListener(handle);
        jm_about.add(jmi_aboutme);

        jmb.add(jm_file);
        jmb.add(jm_manager);
        jmb.add(jm_statistical);
        jmb.add(jm_about);

        // thêm thanh menu vào chương trình  
        this.setJMenuBar(jmb);

        // tạo label hiển thị
        Font font = new Font("Arial", Font.BOLD, 40);
        jl = new JLabel();
        jl.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MenuView.class.getResource("itachi.png"))));
        this.setLayout(new BorderLayout());
        this.add(jl, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public void setTextJL(String s) {
        this.jl.setText(s);
    }

    public void hienThiAbout() {
        JOptionPane.showMessageDialog(this, "Phần mềm quản lý thiết bị trung tâm 1.0");
    }

    public void thoatKhoiChuongTrinh() {
        int luaChon = JOptionPane.showConfirmDialog(
                this,
                "Bạn có muốn thoải khỏi chương trình?",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void openFThietBi() throws SQLException {
        URL urlIconNotepad = MenuView.class.getResource("education.png"); // create image
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);  //  đưa image vào trong chương trình 
        FThietBi fTB = new FThietBi();
        fTB.setIconImage(img);
        fTB.setTitle("Quản Lí Thiết Bị");
        fTB.setLocationRelativeTo(null);
        fTB.setVisible(true);
        fTB.setSize(1209, 900);
    }

    public void openFNhanVien() throws SQLException {
        URL urlIconNotepad = MenuView.class.getResource("education.png"); // create image
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);  //  đưa image vào trong chương trình 
        FNhanVien fNV = new FNhanVien();
        fNV.setIconImage(img);
        fNV.setTitle("Quản Lí Nhân Viên");
        fNV.setLocationRelativeTo(null);
        fNV.setVisible(true);
        fNV.setSize(1209, 900);
    }

    public void openFPhongBan() throws SQLException {
        URL urlIconNotepad = MenuView.class.getResource("education.png"); // create image
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);  //  đưa image vào trong chương trình 
        FPhongban fPB = new FPhongban();
        fPB.setIconImage(img);
        fPB.setTitle("Quản Lí Phòng Ban");
        fPB.setLocationRelativeTo(null);
        fPB.setVisible(true);
        fPB.setSize(1029, 454);
    }

    public void openFLoaiTB() throws SQLException {
        URL urlIconNotepad = MenuView.class.getResource("education.png"); // create image
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);  //  đưa image vào trong chương trình 
        FLoaiTB fLTB = new FLoaiTB();
        fLTB.setIconImage(img);
        fLTB.setTitle("Quản Lí Loại Thiết Bị");
        fLTB.setLocationRelativeTo(null);
        fLTB.setVisible(true);
        fLTB.setSize(1029, 454);
    }

    public void openFPhanCong() throws SQLException {
        URL urlIconNotepad = MenuView.class.getResource("education.png"); // create image
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);  //  đưa image vào trong chương trình 
        FPhanCong fPC = new FPhanCong();
        fPC.setIconImage(img);
        fPC.setTitle("Quản Lí Phân Công");
        fPC.setLocationRelativeTo(null);
        fPC.setVisible(true);
        fPC.setSize(770, 740);
    }

    public void openFThongKeTheoLoaiTB() throws SQLException {
        URL urlIconNotepad = MenuView.class.getResource("education.png"); // create image
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);  //  đưa image vào trong chương trình 
        FThongKeTheoLoaiTB fTKTL = new FThongKeTheoLoaiTB();
        fTKTL.setIconImage(img);
        fTKTL.setTitle("Thống Kê Thiết Bị Theo Loại");
        fTKTL.setLocationRelativeTo(null);
        fTKTL.setVisible(true);
        fTKTL.setSize(900, 840);
    }

    public void openFThongKeTheoPhong() throws SQLException {
        URL urlIconNotepad = MenuView.class.getResource("education.png"); // create image
        Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);  //  đưa image vào trong chương trình 
        FThongKeTheoPhong fTHKTP = new FThongKeTheoPhong();
        fTHKTP.setIconImage(img);
        fTHKTP.setLocationRelativeTo(null);
        fTHKTP.setVisible(true);
        fTHKTP.setSize(1370, 780);
        fTHKTP.setTitle("Thống Kê Thiết Bị Theo Phòng");

    }
}
