package proyek;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Home home = new Home(); 
    }
}
    //Halaman Utama
    class Home extends JFrame {
    Menu menu;
    
    JButton btnAdmin = new JButton("Login Admin");
    JButton btnTamu = new JButton("Pengunjung");
    
    Home(){
        setTitle("Sewa Kamera");
	setSize(350,120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
        
        add(btnAdmin);
        add(btnTamu);
        
        setVisible(true);
        btnAdmin.setBounds(10,20,150,40);
        btnTamu.setBounds(170,20,150,40);
        
         btnAdmin.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dispose();
                  Login login = new Login();        
              }
         });
         
         btnTamu.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  dispose();
                  MVC mvc = new MVC();
                  mvc.Tamu();
              }
         });
     
   }
}
    //Halaman Login
   class Login extends JFrame {
   final JTextField funame = new JTextField(10);
   final JPasswordField fpass = new JPasswordField(10);
   
   JLabel lTitle = new JLabel(" LOGIN ADMIN ");
   JLabel luname = new JLabel(" Username ");
   JLabel lpass = new JLabel(" Password ");
   
   JButton btnLoginAdmin = new JButton(" LOGIN ");

        Login() {
	setTitle("LOGIN ADMIN");
	setSize(350,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);
        
        add(lTitle);
	add(luname);
	add(funame);
        add(lpass);
	add(fpass);
	add(btnLoginAdmin);  
        
        setVisible(true);
        lTitle.setBounds(150,20,140,20);
	luname.setBounds(10,50,120,20);
	funame.setBounds(130,50,150,20);
	lpass.setBounds(10,80,120,20);
	fpass.setBounds(130,80,150,20);
	btnLoginAdmin.setBounds(100,120,120,20);
        
        btnLoginAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = funame.getText();
                String pass = fpass.getText();
                
                if(uname.equals("admin") && pass.equals("admin")){
                    dispose();
                    MVC mvc = new MVC();
                    mvc.Admin();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Login Gagal!");
                }
            }
        });
	
    }
  }

