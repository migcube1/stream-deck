package Helpers;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconosHelper {
    
   public void cargaIcono(JButton btn,String nombreIcono){
      
      ImageIcon img;
      URL ruta = getClass().getResource("/Assets/images/" + nombreIcono);
      
      if (ruta != null ){
        img = new ImageIcon(ruta);
        btn.setIcon(img);
      }else{
        ruta = getClass().getResource("/Assets/images/default.png");
        img = new ImageIcon(ruta);
        btn.setIcon(img);
      }       
   }
    
    
}
