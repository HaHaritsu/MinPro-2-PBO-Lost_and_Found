/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Harits
 */
public class Pelapor {
    private String idPelapor;
    private String nama;
    private String nik;
    private String noHp;

    public Pelapor(String idPelapor, String nama, String nik, String noHp) {
        this.idPelapor = idPelapor;
        this.nama = nama;
        this.nik = nik;
        this.noHp = noHp;
    }

    public String getIdPelapor() {
        return idPelapor;
    }

    public void setIdPelapor(String idPelapor) {
        this.idPelapor = idPelapor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}
