package proyek;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModelAdmin {
    Connector connector = new Connector(); 
    public int getBanyakData(){
        int jmlData=0;
        try{
            String query = "Select * from data_kamera"; 
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); //result isinya tabel belum berupa string
            while(resultSet.next()){ //menghitung banyak baris yang ada di database
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
    
    public void tambahData(String merek,String jenis,String lensa,String tahun,String biaya){
        
         try {
            String query = "INSERT INTO data_kamera VALUES ('"+merek+"','"+jenis+"','"+lensa+"','"+tahun+"','"+biaya+"')";  
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Insert Berhasil !!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,"Data Sudah Ada !!");
        }
    }
    
    public void updateData(String nama,String merek,String jenis,String lensa,String tahun,String biaya){
            
        try {
            String query = "update data_kamera set merek=?, "
                    + "jenis=?, lensa=?, tahun=?, biaya=? where merek=?";
            PreparedStatement preparedStmt = connector.koneksi.prepareStatement(query);
            preparedStmt.setString(1, merek);
            preparedStmt.setString(2, jenis);
            preparedStmt.setString(3, lensa);
            preparedStmt.setString(4, tahun);
            preparedStmt.setString(5, biaya);
            preparedStmt.setString(6, nama);
            preparedStmt.execute();
            
           if(nama.compareTo(merek)==0)
            JOptionPane.showMessageDialog(null,"Update Berhasil !!");
            else
                JOptionPane.showMessageDialog(null,"Data Tidak Ada!!");
        } catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteData(String merek){
        try{
            String query = "DELETE from data_kamera WHERE merek = '"+merek+"'";
            connector.statement = connector.koneksi.createStatement();
            connector.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }

    
}

