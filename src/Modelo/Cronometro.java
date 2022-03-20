/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ejecucion;

/**
 *
 * @author daniel
 */
public class Cronometro extends Thread{
        
    private static int  minutos = 0, segundos = 0, milisegundos = 0;
    
    public Cronometro(){
        
    }
    
    public void run(){
        try{
            while(Ejecucion.verificarOrdenamiento){
                comenzarCronometro();
                Thread.sleep(1,777777);                
            }
            Reportes.generarDocHTML();
            
        }catch(Exception e){
            System.out.println("Problemas con el cronómetro "+e.getMessage());
        }
    }
   
    
    private void comenzarCronometro(){
        //Comenzamos a aumentar los milisegundos
        milisegundos+=2;
        
        /*
            Un segundo tiene 1000 ms por lo que
            cuando sea 1000, regresamos los ms a 
            0 y sumamos 1 unidad a los segundos
        */
        if(milisegundos > 999){
            milisegundos = 0;
            segundos++;
            
            /*1 minuto tiene 59 s por lo que
             cuando los segundos lleguen a 59
             los reiniciamos y aumentamos 1
             unidad a los minutos
            */
            if(segundos  > 59){
                segundos = 0;
                minutos++;
            }
        }
        String reloj = minutos + ":" + segundos + ":" + milisegundos;
        Ejecucion.etiquetaTiempo.setText(reloj);
        
    }
}
