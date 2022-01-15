package Views;

import Models.Evento;
import java.awt.Toolkit;
import java.util.Dictionary;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class EventosView extends javax.swing.JFrame {
    
    private Dictionary<Integer, Evento> eventos;
    private int eventoActual;

    public EventosView() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Assets/logos/logo.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        EventosComboBox = new javax.swing.JComboBox<>();
        GuardarBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(45, 45, 45));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nueva Función:");

        EventosComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        GuardarBtn.setBackground(new java.awt.Color(30, 161, 238));
        GuardarBtn.setText("Guardar");
        GuardarBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EventosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(GuardarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EventosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GuardarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> EventosComboBox;
    private javax.swing.JButton GuardarBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public void mostar() {
        this.setVisible(true);
    }

    public void ocultar() {
        this.setVisible(false);
    }
    
    public void setEventos(Dictionary<Integer, Evento> eventos) {
        this.eventos = eventos;
    }
    
    public Dictionary<Integer, Evento> getEventos() {
        return this.eventos; 
    }
    
    public void setEventoActual(int eventoActual) {
        this.eventoActual = eventoActual;
    }
    
    public int getEventoActual() {
        return this.eventoActual;
    }    
    
    public JComboBox<String> getEventosComboBox(){
        return  this.EventosComboBox;
    }

    public JButton getGuardarBtn() {
        return GuardarBtn;
    }

    public void cargaDatos(){

        EventosComboBox.removeAllItems();        //Limpiamos los items del combobox
        Enumeration<Evento> e = eventos.elements();
        
        while (e.hasMoreElements()){    //Para cada evento
            Evento evento = e.nextElement();
            if (evento.isActivo() != true){ //Verificamos si el evento esta disponible para usar
                EventosComboBox.addItem(evento.getNombre());
            }
        }
    }

    
    
    
    
}
