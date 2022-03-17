/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Cronometro;

/**
 *
 * @author daniel
 */
public class Ejecucion extends javax.swing.JFrame {

    /**
     * Creates new form Ejecucion
     * @param tipoAlgoritmo
     * @param tipoOrdenamiento
     * @param tipoVelocidad
     */
    
    
    public static boolean verificarOrdenamiento = true;

    public Ejecucion(String tipoAlgoritmo, String tipoOrdenamiento, String tipoVelocidad) {
        initComponents();
        mostrarAtributosOrdenamiento(tipoAlgoritmo,tipoOrdenamiento,tipoVelocidad);
        iniciarCronometro();
        this.setLocationRelativeTo(null);
        this.setTitle("SIMULACIÓN");
        
    }
    
    public Ejecucion(){
    }
    
        private void iniciarCronometro(){
        Cronometro cronometro = new Cronometro();
        cronometro.start();
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        relleno1 = new javax.swing.JPanel();
        relleno2 = new javax.swing.JPanel();
        relleno3 = new javax.swing.JPanel();
        relleno4 = new javax.swing.JPanel();
        panelCentral = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        contenedorCronometro = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        etiquetaTiempo = new javax.swing.JLabel();
        etiquetaPasos = new javax.swing.JLabel();
        contenedorInformacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        etiquetaAlgoritmo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        etiquetaTipo = new javax.swing.JLabel();
        etiquetaVelocidad = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        relleno1.setBackground(new java.awt.Color(255, 255, 255));
        relleno1.setPreferredSize(new java.awt.Dimension(925, 25));

        javax.swing.GroupLayout relleno1Layout = new javax.swing.GroupLayout(relleno1);
        relleno1.setLayout(relleno1Layout);
        relleno1Layout.setHorizontalGroup(
            relleno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1092, Short.MAX_VALUE)
        );
        relleno1Layout.setVerticalGroup(
            relleno1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        getContentPane().add(relleno1, java.awt.BorderLayout.PAGE_START);

        relleno2.setBackground(new java.awt.Color(255, 255, 255));
        relleno2.setPreferredSize(new java.awt.Dimension(25, 545));

        javax.swing.GroupLayout relleno2Layout = new javax.swing.GroupLayout(relleno2);
        relleno2.setLayout(relleno2Layout);
        relleno2Layout.setHorizontalGroup(
            relleno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        relleno2Layout.setVerticalGroup(
            relleno2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );

        getContentPane().add(relleno2, java.awt.BorderLayout.LINE_END);

        relleno3.setBackground(new java.awt.Color(255, 255, 255));
        relleno3.setPreferredSize(new java.awt.Dimension(925, 35));

        javax.swing.GroupLayout relleno3Layout = new javax.swing.GroupLayout(relleno3);
        relleno3.setLayout(relleno3Layout);
        relleno3Layout.setHorizontalGroup(
            relleno3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1092, Short.MAX_VALUE)
        );
        relleno3Layout.setVerticalGroup(
            relleno3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        getContentPane().add(relleno3, java.awt.BorderLayout.PAGE_END);

        relleno4.setBackground(new java.awt.Color(255, 255, 255));
        relleno4.setPreferredSize(new java.awt.Dimension(25, 545));

        javax.swing.GroupLayout relleno4Layout = new javax.swing.GroupLayout(relleno4);
        relleno4.setLayout(relleno4Layout);
        relleno4Layout.setHorizontalGroup(
            relleno4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        relleno4Layout.setVerticalGroup(
            relleno4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );

        getContentPane().add(relleno4, java.awt.BorderLayout.LINE_START);

        panelCentral.setBackground(new java.awt.Color(255, 255, 255));
        panelCentral.setLayout(new java.awt.BorderLayout(0, 20));

        panelSuperior.setBackground(new java.awt.Color(255, 255, 255));
        panelSuperior.setPreferredSize(new java.awt.Dimension(775, 125));
        panelSuperior.setLayout(new java.awt.BorderLayout(10, 0));

        contenedorCronometro.setBackground(new java.awt.Color(255, 255, 255));
        contenedorCronometro.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ejecución", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Work Sans", 0, 16))); // NOI18N
        contenedorCronometro.setPreferredSize(new java.awt.Dimension(250, 200));

        jLabel9.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel9.setText("Tiempo:");

        jLabel10.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel10.setText("Pasos:");

        etiquetaTiempo.setText("00:00:00");

        etiquetaPasos.setText("0");

        javax.swing.GroupLayout contenedorCronometroLayout = new javax.swing.GroupLayout(contenedorCronometro);
        contenedorCronometro.setLayout(contenedorCronometroLayout);
        contenedorCronometroLayout.setHorizontalGroup(
            contenedorCronometroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorCronometroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contenedorCronometroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addGroup(contenedorCronometroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaPasos, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etiquetaTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        contenedorCronometroLayout.setVerticalGroup(
            contenedorCronometroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorCronometroLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(contenedorCronometroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(etiquetaTiempo))
                .addGap(18, 18, 18)
                .addGroup(contenedorCronometroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(etiquetaPasos))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panelSuperior.add(contenedorCronometro, java.awt.BorderLayout.LINE_END);

        contenedorInformacion.setBackground(new java.awt.Color(255, 255, 255));
        contenedorInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Características de ordenamiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Work Sans", 0, 16))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel1.setText("Algoritmo:");

        etiquetaAlgoritmo.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaAlgoritmo.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel5.setText("Tipo:");

        jLabel6.setFont(new java.awt.Font("Work Sans", 1, 18)); // NOI18N
        jLabel6.setText("Velocidad:");

        etiquetaTipo.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaTipo.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N

        etiquetaVelocidad.setBackground(new java.awt.Color(255, 255, 255));
        etiquetaVelocidad.setFont(new java.awt.Font("Work Sans", 0, 14)); // NOI18N

        javax.swing.GroupLayout contenedorInformacionLayout = new javax.swing.GroupLayout(contenedorInformacion);
        contenedorInformacion.setLayout(contenedorInformacionLayout);
        contenedorInformacionLayout.setHorizontalGroup(
            contenedorInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorInformacionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(etiquetaAlgoritmo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(etiquetaVelocidad, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        contenedorInformacionLayout.setVerticalGroup(
            contenedorInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorInformacionLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(contenedorInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(etiquetaTipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(contenedorInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etiquetaAlgoritmo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)
                        .addComponent(etiquetaVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(113, 113, 113))
        );

        panelSuperior.add(contenedorInformacion, java.awt.BorderLayout.CENTER);

        panelCentral.add(panelSuperior, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1042, Short.MAX_VALUE)
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        panelCentral.add(panelInferior, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    private void mostrarAtributosOrdenamiento(String alg, String tipo, String velocidad){
        etiquetaAlgoritmo.setText(alg);
        etiquetaTipo.setText(tipo);
        etiquetaVelocidad.setText(velocidad);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedorCronometro;
    private javax.swing.JPanel contenedorInformacion;
    private javax.swing.JLabel etiquetaAlgoritmo;
    private javax.swing.JLabel etiquetaPasos;
    public static javax.swing.JLabel etiquetaTiempo;
    private javax.swing.JLabel etiquetaTipo;
    private javax.swing.JLabel etiquetaVelocidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JPanel relleno1;
    private javax.swing.JPanel relleno2;
    private javax.swing.JPanel relleno3;
    private javax.swing.JPanel relleno4;
    // End of variables declaration//GEN-END:variables

}
