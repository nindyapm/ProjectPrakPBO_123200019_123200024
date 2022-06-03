package proyek;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Controller {
    ModelAdmin admin;
    ViewAdmin viewAdmin ;
    ModelTamu tamu;
    ViewTamu viewTamu;

    Controller(ViewAdmin viewAdmin, ModelAdmin admin) {
    this.admin = admin;
    this.viewAdmin = viewAdmin;
    
    //mengecek data yang ada dari database dan memasukkan ke dalam tabel
    if(admin.getBanyakData() != 0){
            String data[][] = admin.readData();
            viewAdmin.tabel.setModel((new JTable(data, viewAdmin.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
    
    //aksi ketika menekan tombol tambah
    viewAdmin.btnTambah.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String merek = viewAdmin.getFmerek().getText();
        String jenis = viewAdmin.getFjenis().getText();
        String lensa = viewAdmin.getFlensa().getText();
        String tahun = viewAdmin.getFtahun().getText();
        String biaya = viewAdmin.getFbiaya().getText();
        if (merek.equals("") || jenis.equals("")||lensa.equals("")||tahun.equals("")||biaya.equals("")) {
            JOptionPane.showMessageDialog(viewAdmin, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            admin.tambahData(merek,jenis,lensa,tahun,biaya);
            viewAdmin.dispose();
            MVC mvc = new MVC();
            mvc.Admin();
        }
        }
    });
    
    //aksi ketika menekan tombol update
    viewAdmin.btnUpdate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nama = viewAdmin.nama;
        String merek = viewAdmin.getFmerek().getText();
        String jenis = viewAdmin.getFjenis().getText();
        String lensa = viewAdmin.getFlensa().getText();
        String tahun = viewAdmin.getFtahun().getText();
        String biaya = viewAdmin.getFbiaya().getText();
        if (merek.equals("") || jenis.equals("")||lensa.equals("")||tahun.equals("")||biaya.equals("")) {
            JOptionPane.showMessageDialog(viewAdmin, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            admin.updateData(nama,merek,jenis,lensa,tahun,biaya);
            viewAdmin.dispose();
            MVC mvc = new MVC();
            mvc.Admin();
        }
        }
    });
    
    //aksi ketika menekan tombol delete
    viewAdmin.btnDelete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String merek = viewAdmin.getFmerek().getText();

        if (merek.equals("")) {
            JOptionPane.showMessageDialog(viewAdmin, "Isi Merek Kamera Yang Akan Dihapus");
        }else {
            admin.deleteData(merek);
            viewAdmin.dispose();
            MVC mvc = new MVC();
            mvc.Admin();
        }
        }
    });
    
    //aksi ketika menekan tombol clear
     viewAdmin.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAdmin.fmerek.setText("");
                viewAdmin.fjenis.setText("");
                viewAdmin.flensa.setText("");
                viewAdmin.ftahun.setText("");
                viewAdmin.fbiaya.setText("");
            }
        });
     
     //aksi ketika menekan tombol Menu Utama
     viewAdmin.btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAdmin.dispose();
                Home home = new Home();
            }
        });
    
    }
    
    Controller(ViewTamu lihatTamu, ModelTamu tamu) {
    this.tamu = tamu;
    this.viewTamu = lihatTamu;
    
    //mengecek data yang ada dari database dan memasukkan ke dalam tabel
    if(tamu.getBanyakData() != 0){
            String data[][] = tamu.readData();
            lihatTamu.tabel.setModel((new JTable(data, lihatTamu.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Kosong!!\nMinta Admin Untuk Menginput Data!!");
        }
    
    //aksi ketika menekan tombol Menu Utama
    lihatTamu.btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                lihatTamu.dispose();
                Home home = new Home();
            }
        });
    
    }
    
}

