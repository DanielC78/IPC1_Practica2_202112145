/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author daniel
 */
public class Datos {
    
    //Atributos de la clase
    private String columna1;
    private int columna2;
    
    //Arreglo que guardará los datos
    public static Datos[] arregloDatos = new Datos[100];
    
    public Datos(String columna1, int columna2){
        this.columna1 = columna1;
        this.columna2 = columna2;
    }
    
    public static void ingresarDatos(Datos nuevoDato){
        for(int i = 0; i < arregloDatos.length; i++){
            if(arregloDatos[i] == null){
                arregloDatos[i] = nuevoDato;
                return;
            }
        }
    }
    
    public static void recorrerDatos(){
        for (Datos arregloDato : arregloDatos) {
            if (arregloDato != null) {
                System.out.println("La clase es: " + arregloDato.getColumna1());
                System.out.println("La nota es: " + arregloDato.getColumna2());
            } 
        }
    }

    public String getColumna1() {
        return columna1;
    }

    public void setColumna1(String columna1) {
        this.columna1 = columna1;
    }

    public int getColumna2() {
        return columna2;
    }

    public void setColumna2(int columna2) {
        this.columna2 = columna2;
    }
    
    
    
    
    
    
}
