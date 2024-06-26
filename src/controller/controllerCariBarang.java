/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author bakti
 */

import dao.daoCariBarang;
import model.CariBarang;
import view.FormCariBarang;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class controllerCariBarang {
    FormCariBarang frame;
    private daoCariBarang daoCariBarang;
    private FormCariBarang formBarang;

    public controllerCariBarang(FormCariBarang formBarang) {
        this.formBarang = formBarang;
        daoCariBarang = new daoCariBarang();
        loadBarang();
    }

    public void loadBarang() {
        List<CariBarang> barangList = daoCariBarang.getAllBarang();
        DefaultTableModel tableModel = (DefaultTableModel) formBarang.getTable().getModel();
        tableModel.setRowCount(0); 

        for (CariBarang barang : barangList) {
            tableModel.addRow(new Object[]{barang.getId(), barang.getKode(), barang.getNama(), barang.getJumlah(), barang.getHarga(), barang.getMerek()});
        }
    }

    public void searchBarang() {
        String name = formBarang.getTxtSearch().getText();
        List<CariBarang> barangList = daoCariBarang.searchBarangByName(name);
        DefaultTableModel tableModel = (DefaultTableModel) formBarang.getTable().getModel();
        tableModel.setRowCount(0); // Clear existing data

        for (CariBarang barang : barangList) {
            tableModel.addRow(new Object[]{barang.getId(), barang.getKode(), barang.getNama(), barang.getJumlah(), barang.getHarga(), barang.getMerek()});
        }
    }
    
    public void keluar() {
        frame.dispose();
    }
    
}
