/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ejecucion;
import Vista.Inicio;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author daniel
 */
public class Ordenamiento extends Thread{
   
    //Creamos los elementos para crear la gráfica
    DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
    ChartPanel panelDatos;
    JFreeChart chart;
    
    //Atributos de ordenamiento
    public String algoritmo;
    public String tipo;
    public String velocidad;
    
    //Creamos el arreglo tipo datos
    private final Datos [] arregloDatos = Datos.arregloDatos;
    private int contador;
    
    //Indice auxilicar para el ordenamiento del arrelgo
    private Datos auxiliar;
    private int pos;
    
    //Se coloca el tipo de ordenamiento
    private final String ascendente = "Ascendente";
    private final String descendente = "Descendente";
    
    //Tipos de algoritmos
    private final String burbuja = "Burbuja";
    private final String seleccion = "Seleccion";
    private final String insercion = "Insercion";
    
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
    
    public void run(){
        try{  
            switch(algoritmo){
                case burbuja:
                    for (int i = 0; i < (arregloDatos.length - 1); i++) {
                        metodoBurbuja(i);
                        Thread.sleep(nVelocidad);
                    }
                    break;
                case seleccion:
                    metodoSeleccion();
                    break;
                case insercion:
                    metodoInsercion();
                    break;
            }
            
            Ejecucion.verificarOrdenamiento = false;
        }catch(Exception e){
            System.out.println("Problemas con el ordenamiento "+e.getMessage());
        }
    }
    /*
    Creamos un método para crear un dataSet y mostrarlo en pantalla
    */
    
    public void crearGrafico(){
        rellenarDataSet(arregloDatos);
        chart = ChartFactory.createBarChart(Inicio.tituloGrafica, Inicio.titulos[0], Inicio.titulos[1], dataSet, PlotOrientation.VERTICAL, true,true,false);
        panelDatos = new ChartPanel(chart);
        panelDatos.setMouseWheelEnabled(true);
        panelDatos.setPreferredSize(new Dimension(100,100));
        Ejecucion.panelGrafica.add(panelDatos, BorderLayout.CENTER);
        new Ejecucion().repaint();
        new Ejecucion().pack();
    }
    
    public void rellenarDataSet(Datos[] arreglo){
        switch(tipo){
            case descendente:
                for (int i = (arreglo.length-1); i >= 0; i--) {
                    if(arreglo[i] != null){
                        dataSet.addValue(arreglo[i].getDatoNumerico(), arreglo[i].getDatoTexto(), arreglo[i].getDatoTexto());
                        System.out.print("Num: " +arreglo[i].getDatoNumerico());
                        System.out.println("Texto: " +arreglo[i].getDatoTexto());
                    }
                }                
                break;
            case ascendente:
                for (int i = (arreglo.length-1); i >= 0; i--) {
                    if(arreglo[i] != null){
                        dataSet.addValue(arreglo[i].getDatoNumerico(), arreglo[i].getDatoTexto(), arreglo[i].getDatoTexto());
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
    
    public void metodoBurbuja(int i){
        System.out.println("Si llega");
            if(arregloDatos[i] != null){
                for(int j = 0; j < (arregloDatos.length - 1); j++){
                    if(arregloDatos[j] != null && arregloDatos[j+1] != null){
                        if(arregloDatos[j].getDatoNumerico() > arregloDatos[j+1].getDatoNumerico()){
                                auxiliar = arregloDatos[j];
                                arregloDatos[j] = arregloDatos[j+1];
                                arregloDatos[j+1] = auxiliar;
                                //crearGrafico();
                            
                        }
                    }
                }
            }
        
    }
    
    public void metodoSeleccion(){
        
    }
    
    public void metodoInsercion(){
        for(int i = 0; i < arregloDatos.length - 1; i++){
            pos = i;
            auxiliar = arregloDatos[i];
            
            while((pos > 0) && (arregloDatos[pos-1].getDatoNumerico() > auxiliar.getDatoNumerico())){
                arregloDatos[pos] = arregloDatos[pos-1];
                pos--;
            }
            arregloDatos[pos] = auxiliar;
        }
    }
}
