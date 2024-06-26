/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author bakti
 */
import model.CariBarang;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class daoCariBarang {

    private Connection connection;

    public daoCariBarang() {
        try {
            String url = "jdbc:mysql://localhost:3306/inventori";
            String username = "root";  
            String password = ""; 
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CariBarang> getAllBarang() {
        List<CariBarang> barangList = new ArrayList<>();
        try {
            String query = "SELECT * FROM Barang";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                CariBarang barang = new CariBarang(
                        resultSet.getInt("id"),
                        resultSet.getString("kode"),
                        resultSet.getString("nama"),
                        resultSet.getInt("jumlah"),
                        resultSet.getInt("harga"),
                        resultSet.getString("merek")
                );
                barangList.add(barang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barangList;
    }

    public List<CariBarang> searchBarangByName(String name) {
        List<CariBarang> barangList = new ArrayList<>();
        try {
            String query = "SELECT * FROM Barang WHERE nama LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                CariBarang barang = new CariBarang(
                        resultSet.getInt("id"),
                        resultSet.getString("kode"),
                        resultSet.getString("nama"),
                        resultSet.getInt("jumlah"),
                        resultSet.getInt("harga"),
                        resultSet.getString("merek")
                );
                barangList.add(barang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return barangList;
    }

}
