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
public class ThietBi {

    private String map;
    private String tenp;
    private String matb;
    private String tentb;
    private Date ngaysx;
    private String thoigianbaohanh;
    private Float giamua;
    private String dvt;
    private String maloai;
    private String tenloai;
    private String tennv;
    private Float soluong;
    private Date ngaytrangbi;
    private String trangthai;

    public ThietBi() {

    }

    public ThietBi(String map, String tenp, String matb, String tentb, Date ngaysx, String thoigianbaohanh, Float giamua, String dvt, String tennv, Float soluong, Date ngaytrangbi, String trangthai) {
        this.map = map;
        this.tenp = tenp;
        this.matb = matb;
        this.tentb = tentb;
        this.ngaysx = ngaysx;
        this.thoigianbaohanh = thoigianbaohanh;
        this.giamua = giamua;
        this.dvt = dvt;
        this.tennv = tennv;
        this.soluong = soluong;
        this.ngaytrangbi = ngaytrangbi;
        this.trangthai = trangthai;
    }

    public ThietBi(String matb, String tentb, Date ngaysx, String thoigianbaohanh, Float giamua, String dvt, String tenloai) {
        this.matb = matb;
        this.tentb = tentb;
        this.ngaysx = ngaysx;
        this.thoigianbaohanh = thoigianbaohanh;
        this.giamua = giamua;
        this.dvt = dvt;
        this.tenloai = tenloai;
    }

    public ThietBi(String matb, String tentb, Date ngaysx, String thoigianbaohanh, Float giamua, String dvt, String maloai, String tenloai) {
        this.matb = matb;
        this.tentb = tentb;
        this.ngaysx = ngaysx;
        this.thoigianbaohanh = thoigianbaohanh;
        this.giamua = giamua;
        this.dvt = dvt;
        this.maloai = maloai;
        this.tenloai = tenloai;
    }

    public ThietBi(String matb, String tentb) {
        this.matb = matb;
        this.tentb = tentb;
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

    public Date getNgaysx() {
        return ngaysx;
    }

    public void setNgaysx(Date ngaysx) {
        this.ngaysx = ngaysx;
    }

    public String getThoigianbaohanh() {
        return thoigianbaohanh;
    }

    public void setThoigianbaohanh(String thoigianbaohanh) {
        this.thoigianbaohanh = thoigianbaohanh;
    }

    public Float getGiamua() {
        return giamua;
    }

    public void setGiamua(Float giamua) {
        this.giamua = giamua;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    @Override
    public String toString() {
        return matb.trim() + "-" + tentb;
    }
}
