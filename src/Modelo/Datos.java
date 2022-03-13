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
    private String datoTexto;
    private int datoNumerico;
    
    //Arreglo que guardará los datos
    public static Datos[] arregloDatos = new Datos[100];
    
    public Datos(String columna1, int columna2){
        this.datoTexto = columna1;
        this.datoNumerico = columna2;
    }
    
    public Datos(){
        
    }
    
    public static void ingresarDatos(Datos nuevoDato){
        for(int i = 0; i < arregloDatos.length; i++){
            if(arregloDatos[i] == null){
                arregloDatos[i] = nuevoDato;
                break;
            }
        }
    }
    
    public static void reinicarArreglo(){
        for(int i = 0; i < arregloDatos.length; i++){
                arregloDatos[i] = null;   
        }
    }

    public String getDatoTexto() {
        return datoTexto;
    }

    public void setColumna1(String columna1) {
        this.datoTexto = columna1;
    }

    public int getDatoNumerico() {
        return datoNumerico;
    }

    public void setDatoNumerico(int datoNumerico) {
        this.datoNumerico = datoNumerico;
    }
    
    
    
    
    
    
}
