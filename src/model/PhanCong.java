/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author 84392
 */
public class PhanCong {
    
    private String manv;
    private String tennv;
    private String map;
    private String tenp;
    private String matb;
    private String tentb;
    private Float soluong;
    private Date ngaytrangbi;
    private String trangthai;

    public PhanCong(String manv, String tennv, String map, String tenp, String matb, String tentb, Float soluong, Date ngaytrangbi, String trangthai) {
        this.manv = manv;
        this.tennv = tennv;
        this.map = map;
        this.tenp = tenp;
        this.matb = matb;
        this.tentb = tentb;
        this.soluong = soluong;
        this.ngaytrangbi = ngaytrangbi;
        this.trangthai = trangthai;
    }

    public PhanCong(String manv, String map, String matb, Float soluong, Date ngaytrangbi, String trangthai) {
        this.manv = manv;
        this.map = map;
        this.matb = matb;
        this.soluong = soluong;
        this.ngaytrangbi = ngaytrangbi;
        this.trangthai = trangthai;
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

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getTenp() {
        return tenp;
    }

    public void setTenp(String tenp) {
        this.tenp = tenp;
    }

    public String getMatb() {
        return matb;
    }

    public void setMatb(String matb) {
        this.matb = matb;
    }

    public String getTentb() {
        return tentb;
    }

    public void setTentb(String tentb) {
        this.tentb = tentb;
    }

    public Float getSoluong() {
        return soluong;
    }

    public void setSoluong(Float soluong) {
        this.soluong = soluong;
    }

    public Date getNgaytrangbi() {
        return ngaytrangbi;
    }

    public void setNgaytrangbi(Date ngaytrangbi) {
        this.ngaytrangbi = ngaytrangbi;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public PhanCong(String manv, String tennv) {
        this.manv = manv;
        this.tennv = tennv;
    }

   
    
    
    
    
    
    
    
    
    
}
