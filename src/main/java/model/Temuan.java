/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Harits
 */
public class Temuan {
    private String idTemuan;
    private Barang barang;
    private String lokasi;
    private String tanggal;
    private String status;

    public Temuan(String idTemuan, Barang barang,
                  String lokasi, String tanggal, String status) {
        this.idTemuan = idTemuan;
        this.barang = barang;
        this.lokasi = lokasi;
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getIdTemuan() {
        return idTemuan;
    }

    public void setIdTemuan(String idTemuan) {
        this.idTemuan = idTemuan;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
