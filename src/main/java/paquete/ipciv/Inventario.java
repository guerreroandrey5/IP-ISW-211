/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

/**
 *
 * @author guerreroandrey5
 */

public class Inventario {
    protected int madera;
    protected int metal;
    protected int pintura;
    protected int clavos;
    protected int tornillos;
    
    public Inventario(){       
        this.madera = 0;
        this.metal = 0;
        this.pintura = 0;
        this.clavos = 0; 
        this.tornillos = 0;
    }
    
    public Inventario(int madera, int metal, int pintura, int clavos, int tornillos) {
        this.madera = madera;
        this.metal = metal;
        this.pintura = pintura;
        this.clavos = clavos;
        this.tornillos = tornillos;
    }
    //<editor-fold defaultstate="collapsed" desc="Métodos">
    public String getInv(){
     return    
               "\nCantidad de Madera: " + madera            
             + "\nCantidad de Metal: " + metal
             + "\nCantidad de Pintura: " + pintura 
             + "\nCantidad de Clavos: " + clavos
             + "\nCantidad de Tornillos: " + tornillos;}

    @Override
    public String toString() {
        return "Cantidad de Madera: " + madera + "\nCantidad de Metal: " + metal + "\nCantidad de Pintura: " + pintura + "\nCantidad de Clavos: " + clavos + "\nCantidad de Tornillos: " + tornillos +"\n";
    }

    //</editor-fold>
}