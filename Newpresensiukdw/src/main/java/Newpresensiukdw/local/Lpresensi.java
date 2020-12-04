/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

/**
 *
 * @author Acer
 */
public class Lpresensi {
    
    public int no;
    public String matkul;
    public String group;
    public String waktu;
    

    public Lpresensi(int no, String matkul, String group, String waktu) {
       this.no= no;
       this.matkul=matkul;
       this.group=group;
       this.waktu=waktu;
    }

    public int getNo() {
        return no;
    }

    public String getMatkul() {
        return matkul;
    }

    public String getGroup() {
        return group;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
    
}
