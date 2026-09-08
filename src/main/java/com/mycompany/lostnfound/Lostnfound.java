/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lostnfound;

/**
 *
 * @author Harits
 */

//import
import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Lostnfound {

    static Scanner input = new Scanner(System.in);

    static ArrayList<Barang> daftarBarang = new ArrayList<>();
    static ArrayList<Pelapor> daftarPelapor = new ArrayList<>();
    static ArrayList<Laporan> daftarLaporan = new ArrayList<>();
    static ArrayList<Temuan> daftarTemuan = new ArrayList<>();

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("==============================================");
            System.out.println("       SISTEM MANAJEMEN BARANG HILANG");
            System.out.println("==============================================");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Kelola Pelapor");
            System.out.println("3. Kelola Laporan");
            System.out.println("4. Kelola Temuan");
            System.out.println("0. Keluar");
            System.out.println("==============================================");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    menuBarang();
                    break;
                case 2:
                    menuPelapor();
                    break;
                case 3:
                    menuLaporan();
                    break;
                case 4:
                    menuTemuan();
                    break;
                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 0);
    }

    // MENU BARANG
    static void menuBarang() {
        int pilihan;

        do {
            System.out.println("\n========== KELOLA BARANG ==========");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Barang");
            System.out.println("3. Edit Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    lihatBarang();
                    break;
                case 3:
                    editBarang();
                    break;
                case 4:
                    hapusBarang();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 0);
    }

    // BARANG - CREATE
    static void tambahBarang() {
        System.out.println("\n========== TAMBAH BARANG ==========");

        System.out.print("ID Barang        : ");
        String id = input.nextLine();

        // CEK ID BARANG
        for (Barang barang : daftarBarang) {
            if (barang.getIdBarang().equals(id)) {
                System.out.println("ID Barang sudah digunakan!");
                return;
            }
        }

        System.out.print("Nama Barang      : ");
        String nama = input.nextLine();

        System.out.print("Kategori         : ");
        String kategori = input.nextLine();

        System.out.print("Warna            : ");
        String warna = input.nextLine();

        System.out.print("Lokasi Ditemukan : ");
        String lokasi = input.nextLine();

        Barang barang = new Barang(
                id,
                nama,
                kategori,
                warna,
                lokasi
        );

        daftarBarang.add(barang);

        System.out.println("\nBarang berhasil ditambahkan!");
    }

    // BARANG - READ
    static void lihatBarang() {
        System.out.println("\n============================== DAFTAR BARANG ==============================");

        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada data barang.");
            return;
        }

        System.out.printf(
                "%-10s | %-20s | %-15s | %-15s | %-20s%n",
                "ID", "Nama Barang", "Kategori", "Warna", "Lokasi"
        );

        System.out.println(
                "-----------+----------------------+-----------------+-----------------+---------------------"
        );

        for (Barang barang : daftarBarang) {
            System.out.printf(
                    "%-10s | %-20s | %-15s | %-15s | %-20s%n",
                    barang.getIdBarang(),
                    barang.getNamaBarang(),
                    barang.getKategori(),
                    barang.getWarna(),
                    barang.getLokasi()
            );
        }
    }

    // BARANG - UPDATE
    static void editBarang() {
        System.out.println("\n========== EDIT BARANG ==========");

        System.out.print("Masukkan ID barang: ");
        String id = input.nextLine();

        for (Barang barang : daftarBarang) {
            if (barang.getIdBarang().equals(id)) {

                System.out.println("Kosongkan input jika tidak ingin mengubah data.");

                System.out.print("Nama Barang [" + barang.getNamaBarang() + "] : ");
                String nama = input.nextLine();

                System.out.print("Kategori [" + barang.getKategori() + "] : ");
                String kategori = input.nextLine();

                System.out.print("Warna [" + barang.getWarna() + "] : ");
                String warna = input.nextLine();

                System.out.print("Lokasi [" + barang.getLokasi() + "] : ");
                String lokasi = input.nextLine();

                if (!nama.isEmpty()) {
                    barang.setNamaBarang(nama);
                }

                if (!kategori.isEmpty()) {
                    barang.setKategori(kategori);
                }

                if (!warna.isEmpty()) {
                    barang.setWarna(warna);
                }

                if (!lokasi.isEmpty()) {
                    barang.setLokasi(lokasi);
                }

                System.out.println("\nBarang berhasil diubah!");
                return;
            }
        }

        System.out.println("Barang tidak ditemukan!");
    }

    // BARANG - DELETE
    static void hapusBarang() {
        System.out.println("\n========== HAPUS BARANG ==========");

        System.out.print("Masukkan ID barang: ");
        String id = input.nextLine();

        for (int i = 0; i < daftarBarang.size(); i++) {
            if (daftarBarang.get(i).getIdBarang().equals(id)) {

                daftarBarang.remove(i);

                System.out.println("Barang berhasil dihapus!");
                return;
            }
        }

        System.out.println("Barang tidak ditemukan!");
    }

    // MENU PELAPOR
    static void menuPelapor() {
        int pilihan;

        do {
            System.out.println("\n========== KELOLA PELAPOR ==========");
            System.out.println("1. Tambah Pelapor");
            System.out.println("2. Lihat Pelapor");
            System.out.println("3. Edit Pelapor");
            System.out.println("4. Hapus Pelapor");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahPelapor();
                    break;
                case 2:
                    lihatPelapor();
                    break;
                case 3:
                    editPelapor();
                    break;
                case 4:
                    hapusPelapor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 0);
    }

    // PELAPOR - CREATE
    static void tambahPelapor() {
        System.out.println("\n========== TAMBAH PELAPOR ==========");

        System.out.print("ID Pelapor : ");
        String id = input.nextLine();

        // CEK ID PELAPOR
        for (Pelapor pelapor : daftarPelapor) {
            if (pelapor.getIdPelapor().equals(id)) {
                System.out.println("ID Pelapor sudah digunakan!");
                return;
            }
        }

        System.out.print("Nama       : ");
        String nama = input.nextLine();

        System.out.print("NIK        : ");
        String nik = input.nextLine();

        System.out.print("No. HP     : ");
        String noHp = input.nextLine();

        Pelapor pelapor = new Pelapor(
                id,
                nama,
                nik,
                noHp
        );

        daftarPelapor.add(pelapor);

        System.out.println("\nPelapor berhasil ditambahkan!");
    }

    // PELAPOR - READ
    static void lihatPelapor() {
        System.out.println("\n========================== DAFTAR PELAPOR ==========================");

        if (daftarPelapor.isEmpty()) {
            System.out.println("Belum ada data pelapor.");
            return;
        }

        System.out.printf(
                "%-12s | %-20s | %-20s | %-15s%n",
                "ID", "Nama", "NIK", "No. HP"
        );

        System.out.println(
                "-------------+----------------------+----------------------+----------------"
        );

        for (Pelapor pelapor : daftarPelapor) {
            System.out.printf(
                    "%-12s | %-20s | %-20s | %-15s%n",
                    pelapor.getIdPelapor(),
                    pelapor.getNama(),
                    pelapor.getNik(),
                    pelapor.getNoHp()
            );
        }
    }

    // PELAPOR - UPDATE
    static void editPelapor() {
        System.out.println("\n========== EDIT PELAPOR ==========");

        System.out.print("Masukkan ID pelapor: ");
        String id = input.nextLine();

        for (Pelapor pelapor : daftarPelapor) {
            if (pelapor.getIdPelapor().equals(id)) {

                System.out.println("Kosongkan input jika tidak ingin mengubah data.");

                System.out.print("Nama [" + pelapor.getNama() + "] : ");
                String nama = input.nextLine();

                System.out.print("NIK [" + pelapor.getNik() + "] : ");
                String nik = input.nextLine();

                System.out.print("No. HP [" + pelapor.getNoHp() + "] : ");
                String noHp = input.nextLine();

                if (!nama.isEmpty()) {
                    pelapor.setNama(nama);
                }

                if (!nik.isEmpty()) {
                    pelapor.setNik(nik);
                }

                if (!noHp.isEmpty()) {
                    pelapor.setNoHp(noHp);
                }

                System.out.println("\nPelapor berhasil diubah!");
                return;
            }
        }

        System.out.println("Pelapor tidak ditemukan!");
    }

    // PELAPOR - DELETE
    static void hapusPelapor() {
        System.out.println("\n========== HAPUS PELAPOR ==========");

        System.out.print("Masukkan ID pelapor: ");
        String id = input.nextLine();

        for (int i = 0; i < daftarPelapor.size(); i++) {
            if (daftarPelapor.get(i).getIdPelapor().equals(id)) {

                daftarPelapor.remove(i);

                System.out.println("Pelapor berhasil dihapus!");
                return;
            }
        }

        System.out.println("Pelapor tidak ditemukan!");
    }

    // MENU LAPORAN
    static void menuLaporan() {
        int pilihan;

        do {
            System.out.println("\n========== KELOLA LAPORAN ==========");
            System.out.println("1. Tambah Laporan");
            System.out.println("2. Lihat Laporan");
            System.out.println("3. Edit Status Laporan");
            System.out.println("4. Hapus Laporan");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahLaporan();
                    break;
                case 2:
                    lihatLaporan();
                    break;
                case 3:
                    editLaporan();
                    break;
                case 4:
                    hapusLaporan();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 0);
    }

    // LAPORAN - CREATE
    static void tambahLaporan() {
        System.out.println("\n========== TAMBAH LAPORAN ==========");

        if (daftarPelapor.isEmpty() || daftarBarang.isEmpty()) {
            System.out.println("Data pelapor dan barang harus tersedia terlebih dahulu.");
            return;
        }

        System.out.print("ID Laporan : ");
        String id = input.nextLine();

        // CEK ID LAPORAN
        for (Laporan laporan : daftarLaporan) {
            if (laporan.getIdLaporan().equals(id)) {
                System.out.println("ID Laporan sudah digunakan!");
                return;
            }
        }

        System.out.print("ID Pelapor : ");
        String idPelapor = input.nextLine();

        Pelapor pelaporDipilih = null;

        for (Pelapor pelapor : daftarPelapor) {
            if (pelapor.getIdPelapor().equals(idPelapor)) {
                pelaporDipilih = pelapor;
                break;
            }
        }

        if (pelaporDipilih == null) {
            System.out.println("Pelapor tidak ditemukan!");
            return;
        }

        System.out.print("ID Barang  : ");
        String idBarang = input.nextLine();

        Barang barangDipilih = null;

        for (Barang barang : daftarBarang) {
            if (barang.getIdBarang().equals(idBarang)) {
                barangDipilih = barang;
                break;
            }
        }

        if (barangDipilih == null) {
            System.out.println("Barang tidak ditemukan!");
            return;
        }

        System.out.print("Tanggal            : ");
        String tanggal = input.nextLine();

        System.out.print("Lokasi Kehilangan  : ");
        String lokasi = input.nextLine();

        System.out.print("Keterangan         : ");
        String keterangan = input.nextLine();

        // PILIH STATUS LAPORAN
        System.out.println("\nPilih Status:");
        System.out.println("1. Belum ditemukan");
        System.out.println("2. Ditemukan");
        System.out.println("3. Selesai");
        System.out.print("Pilih status: ");

        int pilihanStatus = input.nextInt();
        input.nextLine();

        String status;

        switch (pilihanStatus) {
            case 1:
                status = "Belum ditemukan";
                break;
            case 2:
                status = "Ditemukan";
                break;
            case 3:
                status = "Selesai";
                break;
            default:
                System.out.println("Pilihan status tidak tersedia!");
                return;
        }

        Laporan laporan = new Laporan(
                id,
                pelaporDipilih,
                barangDipilih,
                tanggal,
                lokasi,
                keterangan,
                status
        );

        daftarLaporan.add(laporan);

        System.out.println("\nLaporan berhasil ditambahkan!");
    }

    // LAPORAN - READ
    static void lihatLaporan() {
        System.out.println("\n======================================== DAFTAR LAPORAN ========================================");

        if (daftarLaporan.isEmpty()) {
            System.out.println("Belum ada laporan.");
            return;
        }

        System.out.printf(
                "%-10s | %-18s | %-18s | %-12s | %-18s | %-25s | %-18s%n",
                "ID", "Pelapor", "Barang", "Tanggal",
                "Lokasi", "Keterangan", "Status"
        );

        System.out.println(
                "-----------+--------------------+--------------------+--------------+--------------------+---------------------------+-------------------"
        );

        for (Laporan laporan : daftarLaporan) {
            System.out.printf(
                    "%-10s | %-18s | %-18s | %-12s | %-18s | %-25s | %-18s%n",
                    laporan.getIdLaporan(),
                    laporan.getPelapor().getNama(),
                    laporan.getBarang().getNamaBarang(),
                    laporan.getTanggal(),
                    laporan.getLokasi(),
                    laporan.getKeterangan(),
                    laporan.getStatus()
            );
        }
    }

    // LAPORAN - UPDATE
    static void editLaporan() {
        System.out.println("\n========== EDIT STATUS LAPORAN ==========");

        System.out.print("Masukkan ID laporan: ");
        String id = input.nextLine();

        for (Laporan laporan : daftarLaporan) {
            if (laporan.getIdLaporan().equals(id)) {

                System.out.println("Status saat ini: " + laporan.getStatus());

                // PILIH STATUS BARU
                System.out.println("\nPilih Status Baru:");
                System.out.println("1. Belum ditemukan");
                System.out.println("2. Ditemukan");
                System.out.println("3. Selesai");
                System.out.print("Pilih status: ");

                int pilihanStatus = input.nextInt();
                input.nextLine();

                switch (pilihanStatus) {
                    case 1:
                        laporan.setStatus("Belum ditemukan");
                        break;
                    case 2:
                        laporan.setStatus("Ditemukan");
                        break;
                    case 3:
                        laporan.setStatus("Selesai");
                        break;
                    default:
                        System.out.println("Pilihan status tidak tersedia!");
                        return;
                }

                System.out.println("Status laporan berhasil diubah!");
                return;
            }
        }

        System.out.println("Laporan tidak ditemukan!");
    }

    // LAPORAN - DELETE
    static void hapusLaporan() {
        System.out.println("\n========== HAPUS LAPORAN ==========");

        System.out.print("Masukkan ID laporan: ");
        String id = input.nextLine();

        for (int i = 0; i < daftarLaporan.size(); i++) {
            if (daftarLaporan.get(i).getIdLaporan().equals(id)) {

                daftarLaporan.remove(i);

                System.out.println("Laporan berhasil dihapus!");
                return;
            }
        }

        System.out.println("Laporan tidak ditemukan!");
    }

    // MENU TEMUAN
    static void menuTemuan() {
        int pilihan;

        do {
            System.out.println("\n========== KELOLA TEMUAN ==========");
            System.out.println("1. Tambah Temuan");
            System.out.println("2. Lihat Temuan");
            System.out.println("3. Edit Status Temuan");
            System.out.println("4. Hapus Temuan");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tambahTemuan();
                    break;
                case 2:
                    lihatTemuan();
                    break;
                case 3:
                    editTemuan();
                    break;
                case 4:
                    hapusTemuan();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 0);
    }

    // TEMUAN - CREATE
    static void tambahTemuan() {
        System.out.println("\n========== TAMBAH TEMUAN ==========");

        if (daftarBarang.isEmpty()) {
            System.out.println("Data barang belum tersedia.");
            return;
        }

        System.out.print("ID Temuan      : ");
        String id = input.nextLine();

        // CEK ID TEMUAN
        for (Temuan temuan : daftarTemuan) {
            if (temuan.getIdTemuan().equals(id)) {
                System.out.println("ID Temuan sudah digunakan!");
                return;
            }
        }

        System.out.print("ID Barang      : ");
        String idBarang = input.nextLine();

        Barang barangDipilih = null;

        for (Barang barang : daftarBarang) {
            if (barang.getIdBarang().equals(idBarang)) {
                barangDipilih = barang;
                break;
            }
        }

        if (barangDipilih == null) {
            System.out.println("Barang tidak ditemukan!");
            return;
        }

        System.out.print("Lokasi Temuan  : ");
        String lokasi = input.nextLine();

        System.out.print("Tanggal Temuan : ");
        String tanggal = input.nextLine();

        // PILIH STATUS TEMUAN
        System.out.println("\nPilih Status:");
        System.out.println("1. Belum diklaim");
        System.out.println("2. Sudah diklaim");
        System.out.println("3. Selesai");
        System.out.print("Pilih status: ");

        int pilihanStatus = input.nextInt();
        input.nextLine();

        String status;

        switch (pilihanStatus) {
            case 1:
                status = "Belum diklaim";
                break;
            case 2:
                status = "Sudah diklaim";
                break;
            case 3:
                status = "Selesai";
                break;
            default:
                System.out.println("Pilihan status tidak tersedia!");
                return;
        }

        Temuan temuan = new Temuan(
                id,
                barangDipilih,
                lokasi,
                tanggal,
                status
        );

        daftarTemuan.add(temuan);

        System.out.println("\nData temuan berhasil ditambahkan!");
    }

    // TEMUAN - READ
    static void lihatTemuan() {
        System.out.println("\n============================== DAFTAR TEMUAN ==============================");

        if (daftarTemuan.isEmpty()) {
            System.out.println("Belum ada data temuan.");
            return;
        }

        System.out.printf(
                "%-10s | %-20s | %-20s | %-15s | %-18s%n",
                "ID", "Barang", "Lokasi", "Tanggal", "Status"
        );

        System.out.println(
                "-----------+----------------------+----------------------+-----------------+-------------------"
        );

        for (Temuan temuan : daftarTemuan) {
            System.out.printf(
                    "%-10s | %-20s | %-20s | %-15s | %-18s%n",
                    temuan.getIdTemuan(),
                    temuan.getBarang().getNamaBarang(),
                    temuan.getLokasi(),
                    temuan.getTanggal(),
                    temuan.getStatus()
            );
        }
    }

    // TEMUAN - UPDATE
    static void editTemuan() {
        System.out.println("\n========== EDIT STATUS TEMUAN ==========");

        System.out.print("Masukkan ID temuan: ");
        String id = input.nextLine();

        for (Temuan temuan : daftarTemuan) {
            if (temuan.getIdTemuan().equals(id)) {

                System.out.println("Status saat ini: " + temuan.getStatus());

                // PILIH STATUS BARU
                System.out.println("\nPilih Status Baru:");
                System.out.println("1. Belum diklaim");
                System.out.println("2. Sudah diklaim");
                System.out.println("3. Selesai");
                System.out.print("Pilih status: ");

                int pilihanStatus = input.nextInt();
                input.nextLine();

                switch (pilihanStatus) {
                    case 1:
                        temuan.setStatus("Belum diklaim");
                        break;
                    case 2:
                        temuan.setStatus("Sudah diklaim");
                        break;
                    case 3:
                        temuan.setStatus("Selesai");
                        break;
                    default:
                        System.out.println("Pilihan status tidak tersedia!");
                        return;
                }

                System.out.println("Status temuan berhasil diubah!");
                return;
            }
        }

        System.out.println("Temuan tidak ditemukan!");
    }

    // TEMUAN - DELETE
    static void hapusTemuan() {
        System.out.println("\n========== HAPUS TEMUAN ==========");

        System.out.print("Masukkan ID temuan: ");
        String id = input.nextLine();

        for (int i = 0; i < daftarTemuan.size(); i++) {
            if (daftarTemuan.get(i).getIdTemuan().equals(id)) {

                daftarTemuan.remove(i);

                System.out.println("Temuan berhasil dihapus!");
                return;
            }
        }

        System.out.println("Temuan tidak ditemukan!");
    }
}