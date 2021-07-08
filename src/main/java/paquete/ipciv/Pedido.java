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
    protected int ID;
    
    public Pedido(){
    this.ID = 0;
    this.Nombre_Cliente = "";
    this.Tipo_mueble = 0;
    this.Estado = "";
    }
    
    public Pedido(String name, String estado, int Tipo){
    this.ID = 0;
    this.Nombre_Cliente = name;
    this.Tipo_mueble = Tipo;
    this.Estado = estado;
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }


    public int getTipo_mueble() {
        return Tipo_mueble;
    }

    public String getEstado() {
        return Estado;
    }


    public int getID() {
        return ID;
    }



    public String getInfoPedido() {
        String info = "ID pedido:" + getID() + "\n" +
                "Nombre del Cliente: " + getNombre_Cliente() + "\n" +
                "Estado: " + getEstado() + "\n" +
                "Tipo de mueble: " + getTipo_mueble() + "\n";
        return info;
    }

    
}
