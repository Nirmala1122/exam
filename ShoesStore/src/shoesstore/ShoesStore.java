/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shoesstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShoesStore {

    private static Connection MySQLConfig;

    public static Connection configDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost/shoesstore";
            String user = "root";
            String pass = "";

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Koneksi ke database gagal: " + e.getMessage());
        }
        return MySQLConfig;
    }

}

