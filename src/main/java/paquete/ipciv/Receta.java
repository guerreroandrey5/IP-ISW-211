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
    protected String rnmueble;
    protected int rmadera;
    protected int rmetal;
    protected int rpintura;
    protected int rclavos;
    protected int rtornillos;   
    
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
    
//</editor-fold>
    
    @Override
    public String toString() {
        return "Nombre del Mueble: " + rnmueble + "\nCantidad de Madera: " + rmadera + "\nCantidad de Metal: " + rmetal + "\nCantidad de Pintura: " + rpintura + "\nCantidad de Clavos: " + rclavos + "\nCantidad de Tornillos: " + rtornillos +"\n";
    }

}
