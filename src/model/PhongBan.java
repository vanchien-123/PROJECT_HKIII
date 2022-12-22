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
public class PhongBan {
    
    private String map;
    private String tenp;

    public PhongBan(String map, String tenp) {
        this.map = map;
        this.tenp = tenp;
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

    @Override
    public String toString() {
        return  map.trim()+"--"+tenp;
    }
    
}
