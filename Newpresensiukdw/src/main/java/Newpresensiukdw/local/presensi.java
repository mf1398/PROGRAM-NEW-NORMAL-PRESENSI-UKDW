/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Newpresensiukdw.local;

/**
 *
 * @author PPLK
 */
public class presensi {
    private int id;
    private String foto, nama, nim, presensi, tanggal, matkul;

    presensi(int id, String foto, String nama, String nim, String presensi, String tanggal, String matkul) {
        this.id = id;
        this.presensi = presensi;
        this.foto = foto;
        this.nama = nama;
        this.nim = nim;
        this.tanggal = tanggal;
        this.matkul = matkul;
    }

    public int getId() {
        return id;
    }

    public String getPresensi() {
        return presensi;
    }

    public String getFoto() {
        return foto;
    }

    public String getNim() {
        return nim;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getTanggal() {
        return tanggal;
    }
    public String getMatkul() {
        return matkul;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public void setPresensi(String presensi) {
        this.presensi = presensi;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setNim(String nim) {
        this.nim = nim;
    }
    
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }
}
