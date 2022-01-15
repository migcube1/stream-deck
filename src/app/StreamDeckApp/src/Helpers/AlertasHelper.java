package Helpers;

import javax.swing.JOptionPane;

public class AlertasHelper {
    
    
    public AlertasHelper(){
            
    }
    
    public void MensajeDialogo(String mensaje,int option){
        switch (option){
            
            case 1:
                JOptionPane.showMessageDialog(null, mensaje, "Advertencia",JOptionPane.WARNING_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, mensaje,"Info",JOptionPane.INFORMATION_MESSAGE);
                break;
        }
        
    }
    
    
    public void ConfirmaciónDialogo(){
    }
    
    public void OpcionDialogo(){
    }
    
    public void EntradaDialogo(){
    }
}
