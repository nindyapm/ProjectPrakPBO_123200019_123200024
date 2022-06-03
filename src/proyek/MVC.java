package proyek;
//function admin dan tamu
public class MVC {
    public void Admin(){
        ViewAdmin lihatAdmin = new ViewAdmin();
        ModelAdmin admin = new ModelAdmin();
        Controller controller = new Controller(lihatAdmin, admin);
    }
    
    public void Tamu(){
        ViewTamu lihatTamu = new ViewTamu();
        ModelTamu tamu = new ModelTamu();
        Controller controller = new Controller(lihatTamu, tamu);
    }
}

