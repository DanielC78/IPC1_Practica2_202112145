/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ejecucion;
import Vista.Inicio;
import java.awt.BorderLayout;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author daniel
 */
public class Ordenamiento extends Thread{
   
    //Creamos los elementos para crear la gráfica
    //DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
    //ChartPanel panelDatos;
    //JFreeChart chart;
    
    //Atributos de ordenamiento
    public String algoritmo;
    public String tipo;
    public String velocidad;
    
    //Creamos el arreglo tipo datos
    public final static Datos [] arregloDatos = Inicio.arregloDatos;
    private int contador;
    
    //Indice auxilicar para el ordenamiento del arrelgo
    private Datos auxiliar;
    
    //Se coloca el tipo de ordenamiento
    private final String ascendente = "Ascendente";
    private final String descendente = "Descendente";
    
    //Tipos de algoritmos
    private final String burbuja = "Burbuja";
    private final String seleccion = "Selección";
    private final String insercion = "Inserción";
    
    //Tipo de velocidades
    private final String strRapido = "Rapida";
    private final String strMedio = "Media";
    private final String strLento = "Lenta";
    
    //Velocidades en ms
    private int nVelocidad;

    public Ordenamiento(String algoritmo, String tipo, String velocidad){
        this.algoritmo = algoritmo;
        this.tipo = tipo;
        this.velocidad = velocidad;
        establecerVelocidad();
    }
    
    @Override
    public void run(){
        try{  
            switch(algoritmo){
                case burbuja:
                    metodoBurbuja();
                    break;
                case seleccion:
                    metodoSeleccion();
                    break;
                case insercion:
                    metodoInsercion();
                    break;
            }
        }catch(Exception e){
            System.out.println("Problemas con el ordenamiento "+e.getMessage());
        }
    }
    /*
    Creamos un método para crear un dataSet y mostrarlo en pantalla
    */
    
    public void crearGrafico(int i){
        String titulo = "";
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        JFreeChart chart;
        rellenarDataSet(dataSet);
        chart = ChartFactory.createBarChart(Inicio.tituloGrafica, Inicio.titulos[0], Inicio.titulos[1], dataSet, PlotOrientation.VERTICAL, true,true,false);
        if(i == 0 || i == 1){
            if(i == 0){
                titulo = "imagenInicial.png";
            } else if(i == 1){
                titulo = "imagenFinal.png";
            }
            try{    
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File imagen = new File("/Users/daniel/Desktop/USAC PRIMER SEMESTRE 2022/IPC 1/LABORATORIO/PRACTICAS/Practica_2/Imagenes/"+titulo);
            ChartUtilities.saveChartAsPNG(imagen, chart, 600, 700,info);
            }catch(Exception e){   
            }
        }
        ChartPanel panelDatos = new ChartPanel(chart);
        panelDatos.setMouseWheelEnabled(true);
        Ejecucion.panelGrafica.add(panelDatos,BorderLayout.CENTER);
        new Ejecucion().repaint();
        new Ejecucion().pack();
    }
    
    public void rellenarDataSet(DefaultCategoryDataset dataSet){
        switch(tipo){
            case descendente:
                for (int i = (arregloDatos.length - 1); i >= 0; i--) {
                    if(arregloDatos[i] != null){
                        dataSet.addValue(arregloDatos[i].getDatoNumerico(), arregloDatos[i].getDatoTexto(), arregloDatos[i].getDatoTexto());
                    }
                }                
                break;
            case ascendente:
                for (int i = 0; i < arregloDatos.length; i ++) {
                    if(arregloDatos[i] != null){
                        dataSet.addValue(arregloDatos[i].getDatoNumerico(), arregloDatos[i].getDatoTexto(), arregloDatos[i].getDatoTexto());
                    }
                }
                break;
        }
    }
    
    
    
    /*
    Se crean los algorimtos de ordenamiento,
    recibiendo como parámetro el tipo de ordenamiento
    que se quiere (ascendente o descendente)
    */
    
    private void establecerVelocidad(){
        switch(velocidad){
            case strRapido:
                nVelocidad = 250;
                break;
            case strMedio:
                nVelocidad = 500;
                break;
            case strLento:
                nVelocidad = 750;
                break;
        }
    }
    
    public void metodoBurbuja(){
        crearGrafico(0);
        Reportes.generarEstadoIncial();
        for(int i = 0; i < arregloDatos.length; i++){
            for(int j = 0; j < (arregloDatos.length - 1); j++){
                        mostrarPasos();
                        try {
                            Thread.sleep(nVelocidad);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Ordenamiento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        if(arregloDatos[j].getDatoNumerico() > arregloDatos[j+1].getDatoNumerico()){
                                auxiliar = arregloDatos[j];
                                arregloDatos[j] = arregloDatos[j+1];
                                arregloDatos[j+1] = auxiliar;
                        }
                        crearGrafico(2);
            }
        }
        crearGrafico(1);
        Ejecucion.verificarOrdenamiento = false;
    }
    
    public void metodoSeleccion(){
        crearGrafico(0);
        Reportes.generarEstadoIncial();
        int i,j,pos;
        Datos tmp;
        for(i = 0; i < (arregloDatos.length-1); i++){
                pos = i;
                for(j = (i+1); j < arregloDatos.length; j++){
                    if(arregloDatos[j].getDatoNumerico() < arregloDatos[pos].getDatoNumerico()){
                        pos = j;
                    }

                    try {
                        Thread.sleep(nVelocidad);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Ordenamiento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                mostrarPasos();
                crearGrafico(2);
                }
                tmp = arregloDatos[i];
                arregloDatos[i] = arregloDatos[pos];
                arregloDatos[pos] = tmp;
        }
        crearGrafico(1);
        Ejecucion.verificarOrdenamiento = false;
    }
    
    public void metodoInsercion(){
        crearGrafico(0);
        Reportes.generarEstadoIncial();
        int i,j;
        for(i = 1; i < arregloDatos.length; i++){
                try {
                    Thread.sleep(nVelocidad);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ordenamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
                auxiliar = arregloDatos[i];
                for (j = i; (j > 0) && (arregloDatos[j-1].getDatoNumerico() > auxiliar.getDatoNumerico()); j--) {
                    arregloDatos[j] = arregloDatos[j-1];
                }
                arregloDatos[j] = auxiliar;
                crearGrafico(2);
                mostrarPasos();
        }
        crearGrafico(1);
        Ejecucion.verificarOrdenamiento = false;
    }
    
    private void mostrarPasos(){
        contador++;
        Ejecucion.etiquetaPasos.setText(String.valueOf(contador));
    }
}
