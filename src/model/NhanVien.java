/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 84392
 */
public class NhanVien {

    private String manv;
    private String tennv;
    private String sdtnv;
    private String diachi;
    private boolean gioitinh;

    public NhanVien(String manv, String tennv, String sdtnv, String diachi, boolean gioitinh) {
        this.manv = manv;
        this.tennv = tennv;
        this.sdtnv = sdtnv;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }

    public NhanVien(String manv, String tennv) {
        this.manv = manv;
        this.tennv = tennv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getSdtnv() {
        return sdtnv;
    }

    public void setSdtnv(String sdtnv) {
        this.sdtnv = sdtnv;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return manv.trim()+"--"+tennv;
    }

    
    
}
