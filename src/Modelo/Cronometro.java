/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class Cronometro extends Observable implements Runnable{

    private int minutos, segundos, milisegundos;

    public Cronometro(int minutos, int segundos, int milisegundos) {
        this.minutos = minutos;
        this.segundos = segundos;
        this.milisegundos = milisegundos;
    }
    
    
    
    @Override
    public void run() {
         //To change body of generated methods, choose Tools | Templates.
         
         String tiempo;
         while(true){
             
             try {
                 tiempo = "";
                 
                 if(minutos < 10){
                     tiempo += "0" + minutos;
                 } else{
                     tiempo += minutos;
                 }
                 
                 if(segundos < 10){
                     
                     tiempo += "0" + segundos;
                     
                 } else{
                     tiempo += segundos;
                 }
                 
                 if(milisegundos < 10){
                     tiempo += "0"+milisegundos;
                 } else{
                     tiempo += milisegundos;
                 }
                 
                 this.setChanged();
                 this.notifyObservers();
                 this.clearChanged();
                 Thread.sleep(1000);
                 
                 milisegundos++;
                 
                 if(milisegundos == 1000){
                     segundos++;
                     milisegundos = 0;
                     if(segundos == 60){
                         segundos = 0;
                         minutos++;
                     }
                 }
                 
                 
                 
             } catch (InterruptedException ex) {
                 Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         }
    }
    
}
