/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author bakti
 */
public class CariBarang {
    
    private int id;
    private String kode;
    private String nama;
    private int jumlah;
    private int harga;
    private String merek;
    
    public CariBarang(int id, String kode, String nama, int jumlah, int harga, String merek) {
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.jumlah = jumlah;
        this.harga = harga;
        this.merek = merek;
    }
    
    public int getId() {
        return id;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public String getMerek() {
        return merek;
    }
    
    
}
