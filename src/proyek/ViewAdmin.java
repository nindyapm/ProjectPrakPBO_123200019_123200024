package proyek;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ViewAdmin extends JFrame {
    //DEKLARASI KOMPONEN
    String nama;
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"MEREK KAMERA","JENIS","LENSA","TAHUN","BIAYA SEWA"}; //membuat kolom dgn array tipe object;
    final JTextField fmerek = new JTextField(50);
    final JTextField fjenis = new JTextField(20);
    final JTextField flensa = new JTextField(20);
    final JTextField ftahun = new JTextField(10);
    final JTextField fbiaya = new JTextField(10);
    JLabel lmerek= new JLabel("Merek");
    JLabel ljenis = new JLabel("Jenis");
    JLabel llensa = new JLabel("Lensa");
    JLabel ltahun = new JLabel("Tahun");
    JLabel lbiaya = new JLabel("Biaya Sewa");
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");
    JButton btnBack = new JButton("Menu Awal");
    
    public ViewAdmin(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(800,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Admin");
        setDefaultCloseOperation(3);
  
        add(scrollPane);
        add(lmerek);
        add(fmerek);
        add(ljenis);
        add(fjenis);
        add(llensa);
        add(flensa);
        add(ltahun);
        add(ftahun);
        add(lbiaya);
        add(fbiaya);
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);
        add(btnBack);

        scrollPane.setBounds(20, 35, 500, 345);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        lmerek.setBounds(550, 35, 120, 20);
        fmerek.setBounds(550, 60, 170, 20);
        ljenis.setBounds(550, 90, 120, 20);
        fjenis.setBounds(550, 115, 170, 20);
        llensa.setBounds(550, 145, 120, 20);
        flensa.setBounds(550, 170, 170, 20);
        ltahun.setBounds(550, 200, 120, 20);
        ftahun.setBounds(550, 225, 170, 20);
        lbiaya.setBounds(550, 255, 120, 20);
        fbiaya.setBounds(550, 280, 170, 20);
        btnTambah.setBounds(550, 315, 80, 20);
        btnUpdate.setBounds(550, 345, 80, 20);
        btnDelete.setBounds(650, 315, 80, 20);
        btnClear.setBounds(650, 345, 80, 20);
        btnBack.setBounds(20, 10, 100, 20);
        
        //mengambil data dari tabel yang di klik
        tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                JTable target = (JTable)me.getSource();
                int baris = target.getSelectedRow(); // select a row
                nama =tabel.getValueAt(baris, 0).toString();
                fmerek.setText(tabel.getValueAt(baris, 0).toString());
                fjenis.setText(tabel.getValueAt(baris, 1).toString());
                flensa.setText( tabel.getValueAt(baris, 2).toString());
                ftahun.setText(tabel.getValueAt(baris, 3).toString());
                fbiaya.setText(tabel.getValueAt(baris, 4).toString());         
            }
        });
        
    }
    
    public JTextField getFmerek() {
        return fmerek;
    }

    public JTextField getFjenis() {
        return fjenis;
    }

    public JTextField getFlensa() {
        return flensa;
    }
    
    public JTextField getFtahun() {
        return ftahun;
    }
    
    public JTextField getFbiaya() {
        return fbiaya;
    }

    void deleteData(String merek) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

