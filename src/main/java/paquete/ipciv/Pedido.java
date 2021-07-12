/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;
import java.util.Scanner;
/**
 *
 * @author Cris
 */
public class Pedido {
    public static Scanner leer = new Scanner(System.in);
    protected String Nombre_Cliente;
    protected int Tipo_mueble;
    protected String Estado;
    protected String ID;
    
    public Pedido(){
    this.ID = "";
    this.Nombre_Cliente = "";
    this.Tipo_mueble = 0;
    this.Estado = "";
    }
    
    public Pedido(String name, String estado, int Tipo, String id){
    this.ID = id;
    this.Nombre_Cliente = name;
    this.Tipo_mueble = Tipo;
    this.Estado = estado;
    }

    //<editor-fold defaultstate="collapsed" desc="Gets & Sets">
    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public String getTipo_mueble() {
        String Mueble;
        Mueble = Main.Recetas.get((this.Tipo_mueble - 1)).getNmueble();
        return Mueble;
    }
    
    public int getTipo_muebleIndx() {
        return (this.Tipo_mueble -1);
    }

    public String getEstado() {
        return Estado;
    }
    
    public void setEstado(String state) {
            this.Estado = state;
  
    }

    public String getID() {
        return ID;
    }

    public String getInfoPedido() {
        String info = "ID pedido: " + getID() + "\n" +
                "Nombre del Cliente: " + getNombre_Cliente() + "\n" +
                "Estado: " + getEstado() + "\n" +
                "Tipo de mueble: " + getTipo_mueble() + "\n";
        return info;
    }
    
    //</editor-fold>
    
}
