/****************************************************************************
 * Fundamentos de Sistemas Embebidos
 * Proyecto Final: Stream Deck v1.0
 * Fecha: 18-08-21
 * Autor:
 * - Leyva Bejarano Miguel Angel
 ****************************************************************************/

/****************************************************************************
 * Configuración General
 ****************************************************************************/

/* Configuración del PIC */
#include <18F4550.h>                                                             //Establecemos la biblioteca correspondiente al pic.
#fuses HSPLL, NOWDT, NOPROTECT, NOLVP, NODEBUG, USBDIV, PLL5, CPUDIV1, VREGEN    // Habilitamos los fusibles necesarios del PIC
#use delay(clock=4M)                                                             // Establecemos el Reloj con el que trabajara PIC

/* Configuración del puerto USB */
#define USB_HID_DEVICE TRUE                                                      // Habilitamos el dispositivo  para una comunicación USB HID
#define USB_CONFIG_HID_TX_SIZE 2                                                 // Tamaño del paquete a transmitir (bytes)
#define USB_CONFIG_HID_RX_SIZE 2                                                 // Tamaño del paquete a recibir (bytes)
//#define USB_CONFIG_PID 0x000A                                                  // Establecemos el ID de proveedor (en caso de ser necesario establcer uno en especifico)
//#define USB_CONFIG_VID 0x04D8                                                  // Establecemos el ID de producto (en caso de ser necesario establcer uno en especifico)
#define USB_STRINGS_OVERWRITTEN                                                  // Sobreescribimos los datos de la conexión del dispositivo
#define USB_STRING(x)  (sizeof(_unicode(x))+2), 3, _unicode(x)                   // Establecemos el tamaño del string para los datos del dispositivo

rom char USB_STRING_DESC[]={                                                     // Configuramos los datos del dispositivo
    4, 3, 9, 4,                                                                  // 4(Tamaño del índice de la cadena), 3(Tipo de descriptor: cadena),9&4(Definición en inglés por Microsoft)
    USB_STRING("FSE"),                                                           // cadena 1 - proveedor (Es opcional, pero especificamos su uso en el descriptor del dispositivo)
    USB_STRING("USB STREAM DRECK"),                                              // cadena 2 - producto (Es opcional, pero especificamos su uso en el descriptor del dispositivo)
    USB_STRING("123456789")                                                      // cadena 3 - numero de serie (Es opcional, pero especificamos su uso en el descriptor del dispositivo)
};


/****************************************************************************
 * Bibliotecas o archivos de cabecera
 ****************************************************************************/
 
#include <stdio.h>                                                               // Biblioteca/Archivo cabecera  estandar de entrada-salida en C
#include <stdlib.h>                                                              // Biblioteca/Archivo cabecera de proposito general en C
#include <string.h>                                                              // Biblioteca/Archivo cabecera para el manejo de cadenas
#include <usb_desc_hid.h>                                                        // Biblioteca/Archivo cabecera donde van los descriptores del dispositivo USB-HID
#include <pic18_usb.h>                                                           // Biblioteca/Archivo cabecera para funciones de bajo nivel para la serie PIC18Fxx5x
#include <usb.c>                                                                 // Biblioteca para el manejo del usb

/****************************************************************************
 * Configuraciones y definiciones del firmware
 ****************************************************************************/
 
/* Definiciones para los leds conexión del dispositivo USB */
#define led_desconectado  PIN_C0                                                 // Led para esperar la conexión USB
#define led_conectado PIN_C1                                                     // Led para saber que el USB esta conectado

/* Definiciones de las acciones de los leds del teclado */
#define APAGADOS 0x00                                                            // Código correspondiente apagar todos los leds del teclado
#define ENCENDIDOS 0x01                                                          // Código correspondiente encender todos los leds del teclado
#define SECUENCIA 0x10                                                           // Código correspondiente hacer secuencia con los leds del teclado

/****************************************************************************
 * Definiciones de  las funciones a utilizar en el firmware
 ****************************************************************************/
void secuencia_inicial_leds();
void tecla_isr();

/****************************************************************************
 * Variables a utilizar en el firmware
 ****************************************************************************/
char data_in[1] = {0x10};                                                        // Arreglo para almacenar los bytes recibidos (Configuración recibida porla aplicación)
char data_out[1] = {0x00};                                                       // Arreglo para almacenar los bytes enviado (Codigo correspondiente al boton oprimido por el usuario)
char interrupcion = 0;                                                           // Bandera de interrupciones por cambio de nivel en el puerto B del PIC (apagada por default)  
int tecla_oprimida = -1;                                                         // Bandera utilizada para determinar que tecla se oprimio y poder encender el leds correspondiente
int contador_led = 0;                                                            // Contador para utilizar en la secuencia de leds

char leds[] = {0x21, 0x22, 0x24, 0x28, 0x30,                                     // Arreglo de codigos para determinar que leds del teclado se encienden de acuerdo a la configuración
               0x41, 0x42, 0x44, 0x48, 0x50,
               0x81, 0x82, 0x84, 0x88, 0x90};


/****************************************************************************
 * Funciones a utilizar en el firmware
 ****************************************************************************/
 
/* Función para le secuencia inicial de los leds cuando se conecta el equipo */
void secuencia_inicial_leds(){
    int i = 0;
    
    do {
      output_d(leds[i]);
      i += 1;
      delay_ms(100);
    }while (i <= 14);
}

 
/* Función para el control de los leds dea cuerdo a la configuración */
void control_leds(char codigo){
      
   switch(codigo){
      
      case (char) APAGADOS:                                                      // Todos los leds  del teclado apagados
         output_d(0x00);
         break;
      case (char) ENCENDIDOS:                                                    // Todos los leds del teclado  encendidos
         output_d(0xFF);
         break;
      case (char) SECUENCIA:                                                     // Todos los leds del teclado en  secuencia
         output_d(leds[contador_led]);
         break;
      default:                                                                   // Todos los leeds del teclado en pulso
         if (tecla_oprimida != -1){                                              // Verifica si se oprime una tecla
            output_d(leds[tecla_oprimida]);                                      // Enciende el led del teclado de acuerdo al código de la tecla
            delay_ms(500);                                                       // Espera 0.5s
            output_d(0x00);                                                      // Apaga todos los leds del teclado
            tecla_oprimida = -1;                                                 // Reinicia la bandera de tecla oprimida
         }
         break;
    }
    
    contador_led+=1;                                                             // Incrementamos el contador para pasar al siguiente led (en caso de la secuencia)
      
    if(contador_led > 14){                                                       // Si llega al ultimo led encendido, se reinicia el contador
         contador_led = 0;
    }  
      
}
   

/****************************************************************************
 * Interrupciones a utilizar en el firmware
 ****************************************************************************/
 
/* Función a atención a l interrupción por cambio de nivel en los pines (B4,B5,B6,B7)  de puerto B para detectar la tecla oprimida. */
#INT_RB    
void tecla_isr(){

   int8 entrada = input_b() & 0xF0;                                              // Leemos el valor del puerto B de la tecla oprimida.
   
   switch (entrada){
      
      case 0b11100000:                                                           // Tecla 1
         data_out[0] = 0x01;                                                     // Guardamos el codigo correspondiente a la tecla  en el arreglo de datos de salida
         tecla_oprimida = 0;                                                     // Establecemos el indice de la tecla oprimida para el control de luces 
         break;
      case 0b11010000:                                                           // Tecla 2
         data_out[0] = 0x02;
         tecla_oprimida = 1;
         break;
      case 0b11000000:                                                           // Tecla 3
         data_out[0] = 0x03;
         tecla_oprimida = 2;
         break;
      case 0b10110000:                                                           // Tecla 4
         data_out[0] = 0x04;
         tecla_oprimida = 3;
         break;
      case 0b10100000:                                                           // Tecla 5
         data_out[0] = 0x05;
         tecla_oprimida = 4;
         break;
      case 0b10010000:                                                           // Tecla 6
         data_out[0] = 0x06;
         tecla_oprimida = 5;
         break;
      case 0b10000000:                                                           // Tecla 7
         data_out[0] = 0x07;
         tecla_oprimida = 6;
         break;
      case 0b01110000:                                                           // Tecla 8
         data_out[0] = 0x08;
         tecla_oprimida = 7;
         break;
      case 0b01100000:                                                           // Tecla 9
         data_out[0] = 0x09;
         tecla_oprimida = 8;
         break;
      case 0b01010000:                                                           // Tecla A
         data_out[0] = 0x0A;
         tecla_oprimida = 9;
         break;
      case 0b01000000:                                                           // Tecla B
         data_out[0] = 0x0B;
         tecla_oprimida = 10;
         break;
      case 0b00110000:                                                           // Tecla C
         data_out[0] = 0x0C;
         tecla_oprimida = 11;
         break;
      case 0b00100000:                                                           // Tecla D
         data_out[0] = 0x0D;
         tecla_oprimida = 12;
         break;
      case 0b00010000:                                                           // Tecla E
         data_out[0] = 0x0E;
         tecla_oprimida = 13;
         break;
      case 0b00000000:                                                           // Tecla F
         data_out[0] = 0x0F;
         tecla_oprimida = 14;
         break;
      default:
         data_out[0] = 0x00;                                                     // Ninguna tecla oprimida
         tecla_oprimida = -1;
         break;
   }
      
   interrupcion = 1;                                                             // Activamos la bandera de interrupciones

}


/****************************************************************************
 * Función principal del firmware
 ****************************************************************************/
int  main(){
                   
     /* Configuración de los puertos y periféricos del PIC */
     set_tris_b(0xFF);                                                           // Puerto B como entrada digital
     set_tris_d(0x00);                                                           // Puerto D como salida digital
     
     /* Configuración de la interrupciones*/
     enable_interrupts(INT_RB);                                                  // Habilitamos la interrupción por cambio de nivel en el puerto B
     enable_interrupts(GLOBAL);                                                  // Habilitamos la interrupciones globales
     
     /* Proceso de conexión del dispositivo */
     output_high(led_desconectado);                                              // Se prende el led de desconetado
     output_low(led_conectado);                                                  // Se apaga el led de conectado
       
     usb_init();                                                                 // Inicializamos el USB
     usb_task();                                                                 // Monitorea el estado de la conexión.
     usb_wait_for_enumeration();                                                 // Esperar hasta que el  dispositivo es enumerado por el PC
     
     output_low(led_desconectado);                                               // Se apaga el led de desconectado
     output_high(led_conectado);                                                 // Se prende el led de conectado
     
     secuencia_inicial_leds();                                                   //Se realiza la secuencia inicial de los leds durante dos veces   
     secuencia_inicial_leds();

     delay_ms(1000);                                                             // Esperamos un segundo


     while(true){
     
         usb_task();                                                             // Monitorea el estado de la conexión.
               
          if (usb_enumerated()){                                                 // Verifica si el micro ha sido enumerado por el PC
            
             if (interrupcion){                                                  // Si se oprimió una tecla transmite el dato
                usb_put_packet(1, data_out, USB_CONFIG_HID_TX_SIZE, USB_DTS_TOGGLE);  // Transmite datos desde el micro a la PC por USB HID
                interrupcion = 0;             
            }
            
            if(usb_kbhit(1)){                                                    // Verifica si se han recibido datos por USB
                usb_get_packet(1, data_in, USB_CONFIG_HID_RX_SIZE);              // Lee el valor del dato recibido por USB HID y los almacenamos en data_in
            }
            
         }
         control_leds(data_in[0]);                                               // Verifica la configuración consultando el control de leds
         delay_ms(10);                                                           // Esperamos 10ms
     }     
     return 0;
}



