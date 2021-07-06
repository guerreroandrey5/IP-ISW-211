/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

/**
 *
 * @author guerr
 */
public class Receta {
    protected String nmueble;
    protected int madera;
    protected int metal;
    protected int pintura;
    protected int clavos;
    protected int tornillos;   
    
    public Receta(){
        this.nmueble = "";
        this.madera = 0;
        this.metal = 0;
        this.pintura = 0;
        this.clavos = 0;
   
    }
    public Receta(String nmueble, int madera, int metal, int pintura, int clavos, int tornillos) {
        this.nmueble = nmueble;
        this.madera = madera;
        this.metal = metal;
        this.pintura = pintura;
        this.clavos = clavos;
        this.tornillos = tornillos;

    }
    public String getRecetaz(){
     return    
               "Nombre del Mueble:" + nmueble
             + "\nCantidad de Madera: " + madera            
             + "\nCantidad de Metal: " + metal
             + "\nCantidad de Pintura: " + pintura 
             + "\nCantidad de Clavos: " + clavos
             + "\nCantidad de Tornillos: " + tornillos;}

    @Override
    public String toString() {
        return "Nombre del Mueble: " + nmueble + "\nCantidad de Madera: " + madera + "\nCantidad de Metal: " + metal + "\nCantidad de Pintura: " + pintura + "\nCantidad de Clavos: " + clavos + "\nCantidad de Tornillos: " + tornillos +"\n";
    }

 
}
