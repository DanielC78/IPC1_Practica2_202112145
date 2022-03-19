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
    
    public Datos(String datoTexto, int datoNumerico){
        this.datoTexto = datoTexto;
        this.datoNumerico = datoNumerico;
    }
    
    public Datos(){
        
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
