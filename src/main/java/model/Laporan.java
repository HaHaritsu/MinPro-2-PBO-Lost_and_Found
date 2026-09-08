/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Harits
 */
public class Laporan {
    
    private String idLaporan;
    private Pelapor pelapor;
    private Barang barang;
    private String tanggal;
    private String lokasi;
    private String keterangan;
    private String status;

    public Laporan(String idLaporan, Pelapor pelapor, Barang barang,
                   String tanggal, String lokasi, String keterangan,
                   String status) {
        this.idLaporan = idLaporan;
        this.pelapor = pelapor;
        this.barang = barang;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.keterangan = keterangan;
        this.status = status;
    }

    public String getIdLaporan() {
        return idLaporan;
    }

    public void setIdLaporan(String idLaporan) {
        this.idLaporan = idLaporan;
    }

    public Pelapor getPelapor() {
        return pelapor;
    }

    public void setPelapor(Pelapor pelapor) {
        this.pelapor = pelapor;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
