package Views;

import Models.Evento;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AppView extends javax.swing.JFrame {
    
    private Evento evento;
           
    public AppView() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Assets/logos/logo.png")));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        estadoLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Btn1 = new javax.swing.JButton();
        Btn6 = new javax.swing.JButton();
        BtnB = new javax.swing.JButton();
        BtnC = new javax.swing.JButton();
        Btn8 = new javax.swing.JButton();
        Btn7 = new javax.swing.JButton();
        Btn2 = new javax.swing.JButton();
        Btn3 = new javax.swing.JButton();
        BtnD = new javax.swing.JButton();
        Btn4 = new javax.swing.JButton();
        Btn9 = new javax.swing.JButton();
        BtnE = new javax.swing.JButton();
        Btn5 = new javax.swing.JButton();
        BtnA = new javax.swing.JButton();
        BtnF = new javax.swing.JButton();
        infoBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        guardarConfigBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ConfigComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stream Deck v1.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(45, 45, 45));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Estado:");

        estadoLabel.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("MS PGothic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/logos/logoletras.png"))); // NOI18N

        Btn1.setBackground(new java.awt.Color(80, 217, 135));
        Btn1.setForeground(new java.awt.Color(30, 161, 238));
        Btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Btn6.setBackground(new java.awt.Color(232, 125, 13));
        Btn6.setForeground(new java.awt.Color(30, 161, 238));
        Btn6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnB.setBackground(new java.awt.Color(255, 143, 107));
        BtnB.setForeground(new java.awt.Color(30, 161, 238));
        BtnB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnC.setBackground(new java.awt.Color(30, 161, 238));
        BtnC.setForeground(new java.awt.Color(30, 161, 238));
        BtnC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Btn8.setBackground(new java.awt.Color(30, 161, 238));
        Btn8.setForeground(new java.awt.Color(30, 161, 238));
        Btn8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Btn7.setBackground(new java.awt.Color(33, 163, 102));
        Btn7.setForeground(new java.awt.Color(30, 161, 238));
        Btn7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Btn2.setBackground(new java.awt.Color(111, 46, 152));
        Btn2.setForeground(new java.awt.Color(30, 161, 238));
        Btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Btn3.setBackground(new java.awt.Color(232, 125, 13));
        Btn3.setForeground(new java.awt.Color(30, 161, 238));
        Btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnD.setBackground(new java.awt.Color(254, 242, 0));
        BtnD.setForeground(new java.awt.Color(30, 161, 238));
        BtnD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Btn4.setBackground(new java.awt.Color(30, 161, 238));
        Btn4.setForeground(new java.awt.Color(30, 161, 238));
        Btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Btn9.setBackground(new java.awt.Color(255, 143, 107));
        Btn9.setForeground(new java.awt.Color(30, 161, 238));
        Btn9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnE.setBackground(new java.awt.Color(80, 217, 135));
        BtnE.setForeground(new java.awt.Color(30, 161, 238));
        BtnE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Btn5.setBackground(new java.awt.Color(33, 163, 102));
        Btn5.setForeground(new java.awt.Color(30, 161, 238));
        Btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnA.setBackground(new java.awt.Color(254, 242, 0));
        BtnA.setForeground(new java.awt.Color(30, 161, 238));
        BtnA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BtnF.setBackground(new java.awt.Color(111, 46, 152));
        BtnF.setForeground(new java.awt.Color(30, 161, 238));
        BtnF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        infoBtn.setBackground(new java.awt.Color(45, 45, 45));
        infoBtn.setForeground(new java.awt.Color(45, 45, 45));
        infoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/images/info.png"))); // NOI18N
        infoBtn.setBorder(null);
        infoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        guardarConfigBtn.setBackground(new java.awt.Color(145, 235, 144));
        guardarConfigBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/images/save.png"))); // NOI18N
        guardarConfigBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Configuración");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/images/settings.png"))); // NOI18N

        ConfigComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Apagados", "Encendidos", "Secuencia", "Pulsos" }));
        ConfigComboBox.setToolTipText("");
        ConfigComboBox.setAutoscrolls(true);
        ConfigComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(estadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnC, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnE, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guardarConfigBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(infoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ConfigComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnA, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnB, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnC, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnD, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnE, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnF, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(estadoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ConfigComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(guardarConfigBtn)
                        .addGap(134, 134, 134)
                        .addComponent(infoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void infoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoBtnActionPerformed
        InfoView info = new InfoView();
        info.setVisible(true);
    }//GEN-LAST:event_infoBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn1;
    private javax.swing.JButton Btn2;
    private javax.swing.JButton Btn3;
    private javax.swing.JButton Btn4;
    private javax.swing.JButton Btn5;
    private javax.swing.JButton Btn6;
    private javax.swing.JButton Btn7;
    private javax.swing.JButton Btn8;
    private javax.swing.JButton Btn9;
    private javax.swing.JButton BtnA;
    private javax.swing.JButton BtnB;
    private javax.swing.JButton BtnC;
    private javax.swing.JButton BtnD;
    private javax.swing.JButton BtnE;
    private javax.swing.JButton BtnF;
    private javax.swing.JComboBox<String> ConfigComboBox;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JButton guardarConfigBtn;
    private javax.swing.JButton infoBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    public void mostar(){
        this.setVisible(true);
    }
    
    public void ocultar(){
        this.setVisible(false);
    }
    
    public void actualizarEstado(String estado){
        this.estadoLabel.setText(estado);
    }
    
    public JButton getBtn1() {
        return Btn1;
    }

    public JButton getBtn2() {
        return Btn2;
    }

    public JButton getBtn3() {
        return Btn3;
    }

    public JButton getBtn4() {
        return Btn4;
    }

    public JButton getBtn5() {
        return Btn5;
    }

    public JButton getBtn6() {
        return Btn6;
    }

    public JButton getBtn7() {
        return Btn7;
    }

    public JButton getBtn8() {
        return Btn8;
    }

    public JButton getBtn9() {
        return Btn9;
    }

    public JButton getBtnA() {
        return BtnA;
    }

    public JButton getBtnB() {
        return BtnB;
    }

    public JButton getBtnC() {
        return BtnC;
    }

    public JButton getBtnD() {
        return BtnD;
    }

    public JButton getBtnE() {
        return BtnE;
    }

    public JButton getBtnF() {
        return BtnF;
    }

    public JButton getGuardarConfigBtn() {
        return guardarConfigBtn;
    }

    public void setGuardarConfigBtn(JButton guardarConfigBtn) {
        this.guardarConfigBtn = guardarConfigBtn;
    }

    public JComboBox<String> getConfigComboBox() {
        return ConfigComboBox;
    }

    public void setConfigComboBox(JComboBox<String> ConfigComboBox) {
        this.ConfigComboBox = ConfigComboBox;
    }

   
    
    
      
}
