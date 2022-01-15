package Controllers;

import Helpers.IconosHelper;
import Helpers.AccionesHelper;
import Helpers.AlertasHelper;
import Models.Evento;
import Models.Eventos;
import Views.AppView;
import Views.EventosView;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Dictionary;
import java.util.List;
import purejavahidapi.*;

public class AppController {

    volatile static boolean deviceOpen = false;
    public AppView appView;
    public EventosView eventosView;
    private Eventos eventosModel;
    private IconosHelper iconosHelper;
    private AccionesHelper accionesHelper;
    private AlertasHelper alertasHelper;
    private byte[] data;
    private boolean enviar = true;

    public AppController() {
        //Cargamos la funciones de ayuda
        iconosHelper = new IconosHelper();
        accionesHelper = new AccionesHelper();
        alertasHelper = new AlertasHelper();

        //Cargamos los eventos
        eventosModel = new Eventos();
        cargaEventos();

        //Cargamos la vsta de eventos
        eventosView = new EventosView();
        eventosView.setEventos(eventosModel.obtenerEventos());

        //Cargammos la vista principal de eventos
        appView = new AppView();
        cargaIconos();
        cargarAcciones();
        cargaConfiguracion();

    }

    public void cargaEventos() {
        File archivo = new File("config.dat");

        if (archivo.exists()) {

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("config.dat"))) {

                eventosModel = (Eventos) ois.readObject();

            } catch (ClassNotFoundException e) {
                alertasHelper.MensajeDialogo("Ocurrió un error al cargar los eventos de \'config.dat\': " + e, 2);
            } catch (EOFException e) {
                alertasHelper.MensajeDialogo("Ocurrió un error al cargar los eventos de \'config.dat\': " + e, 2);
            } catch (IOException e) {
                alertasHelper.MensajeDialogo("Ocurrió un error al cargar los eventos de \'config.dat\': " + e, 2);
            }

        } else {

            eventosModel.agregarEvento(1, new Evento(1, "Word Office", "cmd /c start winword.exe", "word.png", true));
            eventosModel.agregarEvento(2, new Evento(2, "PowerPoint Office", "cmd /c start powerpnt.exe",  "powerpoint.png", true));
            eventosModel.agregarEvento(3, new Evento(3, "Excel Office", "cmd /c start excel.exe",  "excel.png", true));
            eventosModel.agregarEvento(4, new Evento(4, "Notepad", "cmd /c start notepad.exe", "notepad.png", true));
            eventosModel.agregarEvento(5, new Evento(5, "Terminal", "cmd /c start cmd", "terminal.png", true));
            eventosModel.agregarEvento(6, new Evento(6, "Windows Media Player", "cmd /c start wmplayer.exe", "mediaplayer.png", true));
            eventosModel.agregarEvento(7, new Evento(7, "Paint", "cmd /c start mspaint.exe", "paint.png", true));
            eventosModel.agregarEvento(8, new Evento(8, "Chrome", "cmd /c start chrome.exe", "chrome.png", true));
            eventosModel.agregarEvento(9, new Evento(9, "Control Panel", "cmd /c start control.exe", "panel.png", true));
            eventosModel.agregarEvento(10, new Evento(10, "Teclado Virtual", "cmd /c start osk.exe", "teclado.png", true));
            eventosModel.agregarEvento(11, new Evento(11, "Programas", "cmd /c start appwiz.cpl", "programas.png", true));
            eventosModel.agregarEvento(12, new Evento(12, "Administrador de Tareas", "cmd /c start Taskmgr.exe", "task.png", true));
            eventosModel.agregarEvento(13, new Evento(13, "Configuración Windows", "cmd /c start ms-settings:", "config.png", true));
            eventosModel.agregarEvento(14, new Evento(14, "Calculadora", "cmd /c start calc.exe", "calc.png", true));
            eventosModel.agregarEvento(15, new Evento(15, "Recortes", "cmd /c start SnippingTool.exe", "recortes.png", true));
            eventosModel.agregarEvento(16, new Evento(16, "Explorador Windows", "cmd /c start explorer.exe", "explorer.png", false));
            eventosModel.agregarEvento(17, new Evento(17, "Windows Defender", "cmd /c start explorer.exe windowsdefender:",  "defender.png", false));
            eventosModel.agregarEvento(18, new Evento(18, "Mozilla Firefox", "cmd /c start firefox.exe", "mozilla.png", false));
            eventosModel.agregarEvento(19, new Evento(19, "Admin. Dispositivos", "cmd /c start devmgmt.msc", "dispositivos.png", false));
            eventosModel.agregarEvento(20, new Evento(20, "Propiedades del Sistema", "cmd /c start control.exe system", "propiedades.png", false));
            
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("config.dat"))) {
                oos.writeObject(eventosModel);
            } catch (IOException e) {
                alertasHelper.MensajeDialogo("Ocurrió un error al guardar los eventos en \'config.dat\': " + e, 2);
            }
        }

    }
    
    public void cargaConfiguracion(){
       byte config = eventosModel.getConfiguracion();
       
       switch (config){
           
           case (byte) 0x01: 
               appView.getConfigComboBox().setSelectedIndex(1);
               break;
           case (byte)  0x10:
               appView.getConfigComboBox().setSelectedIndex(2);
               break;
           case (byte) 0x11:
               appView.getConfigComboBox().setSelectedIndex(3);
               break;
           default:
               appView.getConfigComboBox().setSelectedIndex(0);
               break;
       }
        
        
    }

    public void guardarEventos() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("config.dat"))) {
            oos.writeObject(eventosModel);
        } catch (IOException e) {
            alertasHelper.MensajeDialogo("Ocurrió un error al guardar los eventos en \'config.dat\': " + e, 2);
        }
    }

    public void cargaIconos() {

        Dictionary<Integer, Evento> eventos = eventosModel.obtenerEventos();
        Evento evento;

        evento = eventos.get(1);
        iconosHelper.cargaIcono(appView.getBtn1(), evento.getIcono());
        appView.getBtn1().setToolTipText(evento.getNombre());

        evento = eventos.get(2);
        iconosHelper.cargaIcono(appView.getBtn2(), evento.getIcono());
        appView.getBtn2().setToolTipText(evento.getNombre());

        evento = eventos.get(3);
        iconosHelper.cargaIcono(appView.getBtn3(), evento.getIcono());
        appView.getBtn3().setToolTipText(evento.getNombre());

        evento = eventos.get(4);
        iconosHelper.cargaIcono(appView.getBtn4(), evento.getIcono());
        appView.getBtn4().setToolTipText(evento.getNombre());

        evento = eventos.get(5);
        iconosHelper.cargaIcono(appView.getBtn5(), evento.getIcono());
        appView.getBtn5().setToolTipText(evento.getNombre());

        evento = eventos.get(6);
        iconosHelper.cargaIcono(appView.getBtn6(), evento.getIcono());
        appView.getBtn6().setToolTipText(evento.getNombre());
        
        evento = eventos.get(7);
        iconosHelper.cargaIcono(appView.getBtn7(), evento.getIcono());
        appView.getBtn7().setToolTipText(evento.getNombre());

        evento = eventos.get(8);
        iconosHelper.cargaIcono(appView.getBtn8(), evento.getIcono());
        appView.getBtn8().setToolTipText(evento.getNombre());

        evento = eventos.get(9);
        iconosHelper.cargaIcono(appView.getBtn9(), evento.getIcono());
        appView.getBtn9().setToolTipText(evento.getNombre());

        evento = eventos.get(10);
        iconosHelper.cargaIcono(appView.getBtnA(), evento.getIcono());
        appView.getBtnA().setToolTipText(evento.getNombre());

        evento = eventos.get(11);
        iconosHelper.cargaIcono(appView.getBtnB(), evento.getIcono());
        appView.getBtnB().setToolTipText(evento.getNombre());

        evento = eventos.get(12);
        iconosHelper.cargaIcono(appView.getBtnC(), evento.getIcono());
        appView.getBtnC().setToolTipText(evento.getNombre());

        evento = eventos.get(13);
        iconosHelper.cargaIcono(appView.getBtnD(), evento.getIcono());
        appView.getBtnD().setToolTipText(evento.getNombre());

        evento = eventos.get(14);
        iconosHelper.cargaIcono(appView.getBtnE(), evento.getIcono());
        appView.getBtnE().setToolTipText(evento.getNombre());

        evento = eventos.get(15);
        iconosHelper.cargaIcono(appView.getBtnF(), evento.getIcono());
        appView.getBtnF().setToolTipText(evento.getNombre());

    }

    public void cargarAcciones() {

        appView.getBtn1().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 1)
        );

        appView.getBtn2().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 2)
        );

        appView.getBtn3().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 3)
        );

        appView.getBtn4().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 4)
        );

        appView.getBtn5().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 5)
        );

        appView.getBtn6().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 6)
        );

        appView.getBtn7().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 7)
        );

        appView.getBtn8().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 8)
        );

        appView.getBtn9().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 9)
        );

        appView.getBtnA().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 10)
        );

        appView.getBtnB().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 11)
        );

        appView.getBtnC().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 12)
        );

        appView.getBtnD().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 13)
        );

        appView.getBtnE().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 14)
        );

        appView.getBtnF().addActionListener(accionesHelper.abrirVentanaEventos(eventosView, 15)
        );
        
        appView.getGuardarConfigBtn().addActionListener(accionesHelper.guardarConfiguracion(this));
        
        eventosView.getGuardarBtn().addActionListener(accionesHelper.guardarEvento(eventosView, this, eventosModel.obtenerEventos())
        );
        
        
    }

    public void leerEvento(byte codigo) {

        Dictionary<Integer, Evento> eventos = eventosModel.obtenerEventos();
        Evento evento;

        switch (codigo) {
            case (byte) 0x01:
                evento = eventos.get(0x01);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla 1");
                break;
            case (byte) 0x02:
                evento = eventos.get(0x02);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla 2");
                break;
            case (byte) 0x03:
                evento = eventos.get(0x03);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla 3");
                break;
            case (byte) 0x04:
                evento = eventos.get(0x04);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla 4");
                break;
            case (byte) 0x05:
                evento = eventos.get(0x05);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla 5");
                break;
            case (byte) 0x06:
                evento = eventos.get(0x06);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla 6");
                break;
            case (byte) 0x07:
                evento = eventos.get(0x07);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla 7");
                break;
            case (byte) 0x08:
                evento = eventos.get(0x08);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla 8");
                break;
            case (byte) 0x09:
                evento = eventos.get(0x09);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla 9");
                break;
            case (byte) 0x0A:
                evento = eventos.get(0x0A);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla A");
                break;
            case (byte) 0x0B:
                evento = eventos.get(0x0B);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla B");
                break;
            case (byte) 0x0C:
                evento = eventos.get(0x0C);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla C");
                break;
            case (byte) 0x0D:
                evento = eventos.get(0x0D);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla D");
                break;
            case (byte) 0x0E:
                evento = eventos.get(0x0E);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla E");
                break;
            case (byte) 0x0F:
                evento = eventos.get(0x0F);   //Obtenemos el evento
                evento.run();                 //Ejecutamos el evento
                //System.out.print("Tecla F");
                break;
            default:
                System.out.print("Tecla Default");
                break;

        }
    } 
    
    public void iniciar() {

        appView.mostar();

        try {

            while (true) {

                HidDeviceInfo devInfo = null;

                if (!deviceOpen) {

                    appView.actualizarEstado("Conectando...");

                    List<HidDeviceInfo> devList = PureJavaHidApi.enumerateDevices();
                    for (HidDeviceInfo info : devList) {
                        if (info.getVendorId() == (short) 0x0461 && info.getProductId() == (short) 0x0020) {
                            devInfo = info;
                            break;
                        }
                    }
                    if (devInfo == null) {
                        appView.actualizarEstado("Desconectando");
                        Thread.sleep(1000);
                    } else {
                        appView.actualizarEstado("Conectado");

                        if (true) {
                            deviceOpen = true;
                            final HidDevice dev = PureJavaHidApi.openDevice(devInfo);

                            dev.setDeviceRemovalListener(new DeviceRemovalListener() {
                                @Override
                                public void onDeviceRemoval(HidDevice source) {
                                    appView.actualizarEstado("Desconectando");
                                    deviceOpen = false;
                                }
                            });

                            dev.setInputReportListener(new InputReportListener() {
                                @Override
                                public void onInputReport(HidDevice source, byte Id, byte[] data, int len) {

                                    if (data[0] != (byte) 0x00) {
                                        leerEvento(data[0]);
                                        appView.actualizarEstado("Botón pulsado");
                                        
                                    }
                                }
                                
                            });
                            
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    while (true) {
                                        data = new byte[1];
                                        data[0] = 1;
                                        int len = 0;
                                        if (((len = dev.getFeatureReport(data, data.length)) >= 0) && true) {
                                            int Id = data[0];
                                            System.out.printf("getFeatureReport: id %d len %d data ", Id, len);
                                            for (int i = 0; i < data.length; i++) {
                                                System.out.printf("%02X ", data[i]);
                                            }
                                            System.out.println();
                                        }
                                        
                                        if (enviar){
                                            data[0] = eventosModel.getConfiguracion(); //Establecemos el codigo de configuración de los leds
                                            dev.setOutputReport((byte)0, data, 1);      // Enviamos  el codigo
                                            enviar = false;
                                        }
                                        
                                        if (deviceOpen){
                                            appView.actualizarEstado("Conectado");
                                        }else{
                                            appView.actualizarEstado("Desconectado");
                                        }
    
                                    }
                                }
                            }).start();
                            

                            Thread.sleep(40);
                            //dev.close();
                            //deviceOpen = false;
                            
                        }
                    }
                }
            }
        } catch (Throwable e) {
            alertasHelper.MensajeDialogo("Ocurrió un error con la comunicación: " + e, 2);
        }

    }

    public boolean isEnviar() {
        return enviar;
    }

    public void setEnviar(boolean enviar) {
        this.enviar = enviar;
    }

    public Eventos getEventosModel() {
        return eventosModel;
    }

    public void setEventosModel(Eventos eventosModel) {
        this.eventosModel = eventosModel;
    }    

}
