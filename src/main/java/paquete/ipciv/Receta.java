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
public class Receta {
    private String rnmueble;
    private int rmadera;
    private int rmetal;
    private int rpintura;
    private int rclavos;
    private int rtornillos;   
    
    public Receta(){
        this.rnmueble = "";
        this.rmadera = 0;
        this.rmetal = 0;
        this.rpintura = 0;
        this.rclavos = 0;
   
    }
    
    public Receta(String rnmueble, int rmadera, int rmetal, int rpintura, int rclavos, int rtornillos) {
        this.rnmueble = rnmueble;
        this.rmadera = rmadera;
        this.rmetal = rmetal;
        this.rpintura = rpintura;
        this.rclavos = rclavos;
        this.rtornillos = rtornillos;

    }
    
    //<editor-fold defaultstate="collapsed" desc="Gets & Sets">

    public String getNmueble() {
        return rnmueble;
    }

    public int getRmadera() {
        return rmadera;
    }

    public int getRmetal() {
        return rmetal;
    }

    public int getRpintura() {
        return rpintura;
    }

    public int getRclavos() {
        return rclavos;
    }

    public int getRtornillos() {
        return rtornillos;
    }
    
    public int[] getRecetaNum() {
        int[] materiales = new int[] {this.rmadera ,this.rmetal,this.rpintura,this.rclavos,this.rtornillos};
        return materiales;
    }
    
//</editor-fold>
    
    @Override
    public String toString() {
        return "Nombre del Mueble: " + rnmueble + "\nCantidad de Madera: " + rmadera + "\nCantidad de Metal: " + rmetal + "\nCantidad de Pintura: " + rpintura + "\nCantidad de Clavos: " + rclavos + "\nCantidad de Tornillos: " + rtornillos +"\n";
    }

}
