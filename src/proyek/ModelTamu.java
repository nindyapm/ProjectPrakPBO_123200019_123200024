package proyek;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelTamu {
    Connector connector = new Connector(); 
    public int getBanyakData(){
        int jmlData=0;
        try{
            String query = "Select * from data_kamera"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //menghitung banyak baris pada database
                jmlData++; 
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
        }
        return jmlData;
    }
    
    public String[][] readData(){ //dua dimensi baris-kolom
        try{
            int jmlData = 0; //menampung jumlah data sebanyak jumlah data yang ada, defaultnya
            String data[][] = new String[getBanyakData()][5]; // nemampung array. barisnya isinya di getBanyakData,kolomnya itu atribut
            String query = "Select * from `data_kamera`"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);// result isinya tabel belum berupa string
            while(resultSet.next()){ //konversi tabel ke string
                data[jmlData][0] = resultSet.getString("merek"); // Harus sesuai database
                data[jmlData][1] = resultSet.getString("jenis"); // Harus sesuai database
                data[jmlData][2] = resultSet.getString("lensa"); // Harus sesuai database
                data[jmlData][3] = resultSet.getString("tahun");
                data[jmlData][4] = resultSet.getString("biaya");
                jmlData++; //barisnya berpindah terus sampai habis        
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
}

