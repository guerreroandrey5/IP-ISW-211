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
    private int madera;
    private int metal;
    private int pintura;
    private int clavos;
    private int tornillos;
    
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

    public int getMadera() {
        return madera;
    }

    public int getMetal() {
        return metal;
    }

    public int getPintura() {
        return pintura;
    }

    public int getClavos() {
        return clavos;
    }

    public int getTornillos() {
        return tornillos;
    }

    public int[] getInventearioNum() {
        int[] materiales = new int[] {this.madera ,this.metal,this.pintura,this.clavos,this.tornillos};
        return materiales;
    }
    
    public void restarInv(int[] recetaM){
        this.madera = this.madera - recetaM[0];
        this.metal = this.metal - recetaM[1];
        this.pintura = this.pintura - recetaM[2];
        this.clavos = this.clavos - recetaM[3];
        this.tornillos = this.tornillos - recetaM[4];
    }
    
    @Override
    public String toString() {
        return "Cantidad de Madera: " + madera + "\nCantidad de Metal: " + metal + "\nCantidad de Pintura: " + pintura + "\nCantidad de Clavos: " + clavos + "\nCantidad de Tornillos: " + tornillos +"\n";
    }

    //</editor-fold>
}