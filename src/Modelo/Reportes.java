/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Ejecucion;
import Vista.Inicio;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class Reportes {
    
    public static String encabezadoReporte = "<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"  <head>\n" +
"    <meta charset=\"UTF-8\" />\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
"\n" +
"    <title>Estadísticas del ordenamiento</title>\n" +
"  </head>\n";
    
    public static String estilosCss = "  <style>\n" +
"    @import url(\"https://fonts.googleapis.com/css2?family=Karla:wght@400;700&display=swap\");\n" +
"    * {\n" +
"      padding: 0;\n" +
"      margin: 0;\n" +
"      box-sizing: border-box;\n" +
"    }\n" +
"\n" +
"    body {\n" +
"      font-family: \"Karla\", sans-serif;\n" +
"      background-color: #e5eff5;\n" +
"    }\n" +
"\n" +
"    .sombra {\n" +
"      box-shadow: 0px 0px 15px #00000024;\n" +
"    }\n" +
"\n" +
"    section {\n" +
"      justify-content: center;\n" +
"      padding: 50px 60px;\n" +
"    }\n" +
"\n" +
"    .container {\n" +
"      display: grid;\n" +
"      grid-template-columns: 100%;\n" +
"      border-radius: 10px;\n" +
"      margin: 0 auto;\n" +
"      overflow: hidden;\n" +
"    }\n" +
"\n" +
"    /* Detalles de la caja de encabezado */\n" +
"\n" +
"    .container .header {\n" +
"      display: inline-block;\n" +
"      padding: 20px;\n" +
"      background-color: #f5f5f5;\n" +
"      text-align: center;\n" +
"      border-bottom: 1px solid #000;\n" +
"    }\n" +
"\n" +
"    .container .header h1 {\n" +
"      margin-bottom: 20px;\n" +
"      color: #ea5d4f;\n" +
"      font-weight: 700;\n" +
"      font-size: 43px;\n" +
"    }\n" +
"\n" +
"    .container .header h2 {\n" +
"      margin-bottom: 20px;\n" +
"      color: #efab56;\n" +
"      font-size: 40px;\n" +
"    }\n" +
"\n" +
"    /* Detalles de la caja de las características de ordenamiento */\n" +
"\n" +
"    .container .detalle-ordenamiento {\n" +
"      background-color: #ea5d4f;\n" +
"      padding: 20px;\n" +
"      color: white;\n" +
"      border-bottom: 1px solid #000;\n" +
"    }\n" +
"\n" +
"    .container .detalle-ordenamiento h1 {\n" +
"      font-size: 37px;\n" +
"    }\n" +
"\n" +
"    .descripciones {\n" +
"      font-weight: bold;\n" +
"    }\n" +
"\n" +
"    /* Detalle de la caja de ejecución */\n" +
"\n" +
"    .container .detalle-ejecucion {\n" +
"      padding: 20px;\n" +
"      background-color: #f19a8a;\n" +
"      color: #fff;\n" +
"      border-bottom: 1px solid #000;\n" +
"    }\n" +
"\n" +
"    .container .detalle-ejecucion h1 {\n" +
"      margin-bottom: 20px;\n" +
"      font-size: 37px;\n" +
"    }\n" +
"\n" +
"    .container .estado-inicial h1 {\n" +
"      text-align: center;\n" +
"    }\n" +
"\n" +
"    p {\n" +
"      line-height: 1.6;\n" +
"      font-size: 22px;\n" +
"      font-weight: 100;\n" +
"      margin-bottom: 30px;\n" +
"      margin-top: 10px;\n" +
"      color: #ffffff;\n" +
"    }\n" +
"\n" +
"    .desc-grafica {\n" +
"      display: flex;\n" +
"      justify-content: center;\n" +
"      align-items: center;\n" +
"      text-align: center;\n" +
"      font-size: 20px;\n" +
"      font-weight: bold;\n" +
"    }\n" +
"\n" +
"    /* Estado inicial de la ejecución */\n" +
"    .estado-inicial {\n" +
"      padding: 25px;\n" +
"      color: #ea5d4f;\n" +
"      background-color: white;\n" +
"      border-bottom: 1px solid #000;\n" +
"    }\n" +
"\n" +
"    .estado-inicial h1 {\n" +
"      font-size: 35px;\n" +
"    }\n" +
"\n" +
"    /* Estado final de la ejecución */\n" +
"    .estado-final {\n" +
"      padding: 15px;\n" +
"      color: #ea5d4f;\n" +
"      background-color: white;\n" +
"    }\n" +
"\n" +
"    .estado-final h1 {\n" +
"      font-size: 35px;\n" +
"      text-align: center;\n" +
"    }\n" +
"\n" +
"    /* Diseño para las tablas */\n" +
"    table {\n" +
"      margin: 25px;\n" +
"      width: 90%;\n" +
"      border-collapse: collapse;\n" +
"      border-radius: 10px 0 0 10px;\n" +
"      overflow: hidden;\n" +
"      box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);\n" +
"    }\n" +
"\n" +
"    table td {\n" +
"      padding: 12px 15px;\n" +
"      border-right: 1px solid #ddd;\n" +
"      text-align: center;\n" +
"      font-size: 22px;\n" +
"    }\n" +
"\n" +
"    table td {\n" +
"      font-weight: 200;\n" +
"    }\n" +
"\n" +
"    table th {\n" +
"      font-size: 26px;\n" +
"      font-weight: 600;\n" +
"      color: white;\n" +
"      background-color: #ea5d4f;\n" +
"    }\n" +
"\n" +
"    table tbody td:nth-child(even) {\n" +
"      background-color: #f3f3f3;\n" +
"    }\n" +
"\n" +
"    table tbody td:last-of-type {\n" +
"      border-right: 2px solid #ea5d4f;\n" +
"    }\n" +
"\n" +
"    /* Configuración de las imágenes */\n" +
"    img {\n" +
"      text-align: center;\n" +
"      width: 50%;\n" +
"      height: 50%;\n" +
"      margin: 15px;\n" +
"    }\n" +
"    .imagen {\n" +
"      text-align: center;\n" +
"    }\n" +
"\n" +
"    @media (min-width: 768px) {\n" +
"      .container {\n" +
"        grid-template-columns: 1fr 1fr;\n" +
"      }\n" +
"      .container .header {\n" +
"        grid-area: 1/ 1/ 2/ 3;\n" +
"      }\n" +
"      .container .detalle-ordenamiento,\n" +
"      .container .detalle-ejecucion {\n" +
"        grid-row: 2;\n" +
"      }\n" +
"      .container .estado-inicial {\n" +
"        grid-row-start: 3;\n" +
"        grid-row-end: 3;\n" +
"        grid-column-start: 1;\n" +
"        grid-column-end: 3;\n" +
"      }\n" +
"\n" +
"      .container .estado-final {\n" +
"        grid-row-start: 4;\n" +
"        grid-row-end: 4;\n" +
"        grid-column-start: 1;\n" +
"        grid-column-end: 3;\n" +
"      }\n" +
"    }\n" +
"  </style>\n";
    
    public static String datosPersonales = "<body>\n" +
"    <section>\n" +
"      <div class=\"container sombra\">\n" +
"        <div class=\"header\">\n" +
"          <h1>Daniel Estuardo Cuque Ruíz</h1>\n" +
"          <h2>202112145</h2>\n" +
"        </div>\n";
    
    public static String detalleOrdenamiento = "";
    public static String detalleEjecucion = "";
    
    public static String tablaInicial = "";
    public static String tablaFinal = "";
    
    public static String pieReporte = "";
    
    public Reportes(){
        
    }
    
    public static void generarEstadoIncial(){
        //Construimos la tabla inicial sin ordenar
        tablaInicial = "        <div class=\"estado-inicial\">\n" +
"          <h1>ESTADO INICIAL</h1>\n" +
"          <table>\n" +
"            <tr>\n" +
"              <th>"+Inicio.titulos[0]+"</th>\n";
        for (Datos arregloDato : Inicio.arregloDatos) {
            tablaInicial += "              <td>" + arregloDato.getDatoTexto() + "</td>\n";
        }

                tablaInicial +=
"            </tr>\n" +
"            <tr>\n" +
"              <th>"+Inicio.titulos[1]+"</th>\n";
                
        for (Datos arregloDato : Inicio.arregloDatos) {
            tablaInicial += "              <td>" + arregloDato.getDatoNumerico() + "</td>\n";
        }                  
                tablaInicial +=
"            </tr>\n" +
"          </table>\n" +
"          <div class=\"imagen\">\n" +
"            <img\n" +
"              src=\"/Users/daniel/Desktop/USAC PRIMER SEMESTRE 2022/IPC 1/LABORATORIO/PRACTICAS/Practica_2/Imagenes/imagenInicial.png\"\n" +
"              alt=\"Grafica Inicial\"\n" +
"            />\n" +
"          </div>\n" +
"          <span class=\"desc-grafica\">Gráfica desordenada</span>\n" +
"        </div>";
    }
    
    public static void generarDocHTML(){
        String texto = generarCodigoHTML();
         File f;
         FileWriter w;
         BufferedWriter bw;
         PrintWriter pw;
         
         try{
         f = new File("/Users/daniel/Desktop/USAC PRIMER SEMESTRE 2022/IPC 1/LABORATORIO/PRACTICAS/Practica_2/Reporte-de-ejecucion.html");
         w = new FileWriter(f);
         bw = new BufferedWriter(w);
         pw = new PrintWriter(bw);
         pw.write(texto);
         bw.close();
         pw.close();
             
         }catch(IOException e){
             System.out.println(e.getMessage());
         }
    }
    
    public static String generarCodigoHTML(){
        //Colocamos los datos del ordenamiento
        detalleOrdenamiento = "<div class=\"detalle-ordenamiento\">\n" +
"          <h1>Detalle de ordenamiento</h1>\n" +
"          <p>\n" +
"            <span class=\"descripciones\">Algoritmo: </span>\n" +
"            <span>"+Ejecucion.etiquetaAlgoritmo.getText()+"</span>\n" +
"          </p>\n" +
"          <p>\n" +
"            <span class=\"descripciones\">Tipo: </span>\n" +
"            <span>"+Ejecucion.etiquetaTipo.getText()+"</span>\n" +
"          </p>\n" +
"          <p>\n" +
"            <span class=\"descripciones\">Velocidad: </span>\n" +
"            <span>"+Ejecucion.etiquetaVelocidad.getText()+"</span>\n" +
"          </p>\n" +
"        </div>\n";
        
        //Colocamos el tiempo y los pasos
        detalleEjecucion = "        <div class=\"detalle-ejecucion\">\n" +
"          <h1>Detalle de ejecución</h1>\n" +
"          <p>\n" +
"            <span class=\"descripciones\">Tiempo: </span>\n" +
"            <span>"+Ejecucion.etiquetaTiempo.getText()+"</span>\n" +
"          </p>\n" +
"          <p>\n" +
"            <span class=\"descripciones\">Pasos: </span>\n" +
"            <span>"+Ejecucion.etiquetaPasos.getText()+"</span>\n" +
"          </p>\n" +
"        </div>";
           
                //Construimos la tabla final ordenada
                tablaFinal += "<div class=\"estado-final\">\n" +
"          <h1>ESTADO FINAL</h1>\n" +
"          <table>\n" +
"            <tr>\n" +
"              <th>"+Inicio.titulos[0]+"</th>\n";
                for (Datos arregloDato : Ordenamiento.arregloDatos) {
                    tablaFinal += "              <td>" + arregloDato.getDatoTexto() + "</td>\n";
                } 
               tablaFinal += 
"            </tr>\n" +
"            <tr>\n" +
"              <th>"+Inicio.titulos[1]+"</th>\n";
        for (Datos arregloDato : Ordenamiento.arregloDatos) {
            tablaFinal += "              <td>" + arregloDato.getDatoNumerico() + "</td>\n";
        }
        tablaFinal +=
"            </tr>\n" +
"          </table>\n" +
"\n" +
"          <div class=\"imagen\">\n" +
"            <img\n" +
"              src=\"/Users/daniel/Desktop/USAC PRIMER SEMESTRE 2022/IPC 1/LABORATORIO/PRACTICAS/Practica_2/Imagenes/imagenFinal.png\"\n" +
"              alt=\"Grafica Final\"\n" +
"            />\n" +
"            <span class=\"desc-grafica\">Gráfica ordenada</span>\n" +
"          </div>\n" +
"        </div>";
        
        pieReporte = "      </div>\n" +
"    </section>\n" +
"  </body>\n" +
"</html>";
        
        
        return encabezadoReporte + estilosCss + datosPersonales + detalleOrdenamiento + detalleEjecucion + tablaInicial + tablaFinal + pieReporte;
        
    }
    
    
}
