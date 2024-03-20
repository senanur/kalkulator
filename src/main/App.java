/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class App {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        KalkulatorForm kf = new KalkulatorForm();
        kf.setLocationRelativeTo(null);
        kf.setVisible(true);
    }

    public static Double hitung(Double angka1, Double angka2, String operator) {
        Double hasil = null;
        if (operator.equals("+")) {
            hasil = penjumlahan(angka1, angka2);
        } else if (operator.equals("-")) {
            hasil = pengurangan(angka1, angka2);
        } else if (operator.equals("*")) {
            hasil = perkalian(angka1, angka2);
        } else if (operator.equals("/")) {
            hasil = pembagian(angka1, angka2);
        }
        return hasil;
    }

    public static Double penjumlahan(Double angka1, Double angka2) {
        Double hasil = angka1 + angka2;
        return hasil;
    }

    public static Double pengurangan(Double angka1, Double angka2) {
        Double hasil = angka1 - angka2;
        return hasil;
    }

    public static Double perkalian(Double angka1, Double angka2) {
        Double hasil = angka1 * angka2;
        return hasil;
    }

    public static Double pembagian(Double angka1, Double angka2) {
        Double hasil = angka1 / angka2;
        return hasil;
    }

    public static void insertHitung(Double angka1, Double angka2, String operator, Double hasil) {
        Connection connect;
        PreparedStatement pst;
        String url = "jdbc:mysql://localhost:3306/kalkulator";
        String username = "root";
        String password = "";
        String query = "insert into data_hitung (angka_1, angka_2, operator, hasil) values (?,?,?,?)";

        try {
            connect = DriverManager.getConnection(url, username, password);
            pst = connect.prepareStatement(query);
            pst.setDouble(1, angka1);
            pst.setDouble(2, angka2);
            pst.setString(3, operator);
            pst.setDouble(4, hasil);
            pst.executeUpdate();
            pst.close();
            connect.close();
        } catch (SQLException ex) {
            System.out.println("Bah error: " + ex);
        }
    }
}
