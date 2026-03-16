/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyVanPhongPham;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyVanPhongPham;encrypt=true;trustServerCertificate=true";
            String user = "sa";
            String password = "12345";

            conn = DriverManager.getConnection(url, user, password);

            System.out.println("Connected SQL Server");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}