package proyek;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewTamu extends JFrame {
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"MEREK KAMERA","JENIS","LENSA","TAHUN","BIAYA SEWA"};
    JButton btnBack = new JButton("Menu Awal");
    public ViewTamu(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(700,500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Pengunjung");
        setDefaultCloseOperation(3);
        add(btnBack);
        add(scrollPane);
        
        scrollPane.setBounds(20, 35, 500, 345);
        btnBack.setBounds(20, 10, 100, 20);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
}

