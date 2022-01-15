package Models;

import java.io.IOException;
import java.io.Serializable;

public class Evento implements Serializable {
   
    private int id;
    private String nombre;
    private String comando;
    private boolean activo;
    private String icono;
    
    public Evento(int _id, String _nombre, String _comando, String _icono, boolean _activo){
        this.id = _id;
        this.nombre = _nombre;
        this.comando = _comando;
        this.activo = _activo;
        this.icono = _icono;
    }
   
    public void run(){
        try{
            Runtime.getRuntime().exec(comando); //"cmd /c start winword.exe"
        }catch(IOException e){
            System.out.print(e);
        }
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    
    
}
