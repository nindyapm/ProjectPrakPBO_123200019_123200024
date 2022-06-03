package proyek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {
    String DBurl = "jdbc:mysql://localhost/kamera";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;
    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }
}

