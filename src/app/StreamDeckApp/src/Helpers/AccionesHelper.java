package Helpers;

import Controllers.AppController;
import Models.Evento;
import Views.AppView;
import Views.EventosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.Enumeration;


public class AccionesHelper {
    
    private AlertasHelper alertasHelper;
    
    public AccionesHelper(){
        alertasHelper = new AlertasHelper();
    }
    
    public ActionListener abrirVentanaEventos(EventosView ventana, int codigo){
        
        return new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ventana.setEventoActual(codigo);
                ventana.cargaDatos(); //Enviamos los datos a la ventana
                ventana.setVisible(true);           //Hacemos visible la ventana
            }
        };
    }
    
    public ActionListener guardarEvento(EventosView ventana, AppController ac, Dictionary<Integer, Evento> eventos){
        
        return new ActionListener(){
            public void actionPerformed(ActionEvent ae){;
                
                String item;
                Enumeration<Evento> e;
                Evento nuevoEvento = null;
                int idEventoActual;
                
                e = eventos.elements(); //Obtenemos los eventos actuales
                item =  ventana.getEventosComboBox().getSelectedItem().toString(); //Obtenemos el item seleccionado
                idEventoActual = ventana.getEventoActual();  //Obtenemos el indice del evento actual

                while (e.hasMoreElements()){    //Para cada evento
                    nuevoEvento = e.nextElement();

                    if (nuevoEvento.getNombre()== item){  //Si se encuentra el evento 
                        break;
                    }
                }
                
                //Proceso de intercambio de eventos
                if (nuevoEvento != null){

                    Evento eventoActual = eventos.get(idEventoActual);  //Obtenemos el evento actual asociado al botón
                    nuevoEvento.setActivo(true);
                    eventos.put(idEventoActual,nuevoEvento); // Insertamos el nuevo evento en lugar del evento actual
                    eventoActual.setId(nuevoEvento.getId()); //Actualizamos el indice del evento actual con el del nuevo evento
                    eventoActual.setActivo(false);
                    eventos.put(nuevoEvento.getId(), eventoActual); //Insertamos el evento actual en el indice del nuevo evento
                    
                }else{
                    alertasHelper.MensajeDialogo("Error al actualizar el evento.", 1);
                }
                
                
                ac.cargaIconos();      //Actualizamos lo iconos de la ventana principal
                ac.guardarEventos();  //Guardamos los eventos en el archivo de configuración.
                ventana.ocultar();    //Ocultamos la ventana secundaria
                alertasHelper.MensajeDialogo("Se actualizó correctamente el evento.", 0);
            }
        };
    }
    
    
    public ActionListener guardarConfiguracion(AppController ac){
        
        return new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                AppView av = ac.appView;
                int index = av.getConfigComboBox().getSelectedIndex();
                
                switch(index){
                    case 1:
                        ac.getEventosModel().setConfiguracion((byte)0x01);        //Leds Encendidos
                        break;
                    case 2:
                        ac.getEventosModel().setConfiguracion((byte)0x10);       // Leds en Secuencia
                        break;
                    case 3:
                        ac.getEventosModel().setConfiguracion((byte)0x11);       // Leds en pulso
                        break;
                    default:
                        ac.getEventosModel().setConfiguracion((byte)0x00);         // Leds Apagados
                        break;
                }
                
                ac.guardarEventos();
                ac.setEnviar(true);
                alertasHelper.MensajeDialogo("Se actualizó la configuración correctamente.", 0);
            };
                
          
        };
    }
    
}
