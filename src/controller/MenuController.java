/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MenuView;

/**
 *
 * @author 84392
 */
public class MenuController implements ActionListener {

    private final MenuView MEV;

    public MenuController(MenuView MEV) {
        this.MEV = MEV;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String button = ae.getActionCommand();
        //System.out.print(button);

        if (button.equals("Open")) {
            this.MEV.setTextJL("You was click button" + button);
        } else if (button.equals("About Me")) {
            this.MEV.hienThiAbout();
        } else if (button.equals("Exit")) {
            this.MEV.thoatKhoiChuongTrinh();
        } else if (button.equals("Thiết Bị")) {
            try {
                this.MEV.openFThietBi();
            } catch (SQLException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (button.equals("Nhân Viên")) {
            try {
                this.MEV.openFNhanVien();
            } catch (SQLException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (button.equals("Phòng Ban")) {
            try {
                this.MEV.openFPhongBan();
            } catch (SQLException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (button.equals("Loại TB")) {
            try {
                this.MEV.openFLoaiTB();
            } catch (SQLException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (button.equals("Phân Công")) {
            try {
                this.MEV.openFPhanCong();
            } catch (SQLException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (button.equals("Thống Kê Theo Loại")) {
            try {
                this.MEV.openFThongKeTheoLoaiTB();
            } catch (SQLException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if (button.equals("Thống Kê Theo Phòng")) {
            try {
                this.MEV.openFThongKeTheoPhong();
            } catch (SQLException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
