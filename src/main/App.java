/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatLightLaf;

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
}
