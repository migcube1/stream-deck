/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author migcu
 */
public class Eventos implements Serializable {
    
    private Dictionary<Integer, Evento> eventos;
    private byte configuracion = 0x00;
    
    public Eventos(){
        this.eventos = new Hashtable<Integer, Evento>();
    }

    public Dictionary<Integer, Evento> obtenerEventos() {
        return eventos;
    }

    public void establecerEventos(Dictionary<Integer, Evento> eventos) {
        this.eventos = eventos;
    }
    
    public boolean agregarEvento(Integer indice,Evento evento){
        eventos.put(indice, evento);
        return true;
    }

    public byte getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(byte configuracion) {
        this.configuracion = configuracion;
    }
    
    
        
    
    
}
