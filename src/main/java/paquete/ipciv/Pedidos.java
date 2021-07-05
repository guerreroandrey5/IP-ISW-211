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
public class Pedidos {
    public static Scanner leer = new Scanner(System.in);
    protected String Nombre_Cliente;
    protected String Tipo_mueble;
    protected String Estado;
    protected int madera;
    protected int metal;
    protected int pintura;
    protected int clavos;
    protected int tornillos;
    protected int ID;
    protected String color;
    
    public Pedidos(){
    this.ID = 0;
    this.Nombre_Cliente = "";
    this.Tipo_mueble = "";
    this.Estado = "";
    this.madera = 0;
    this.metal = 0;
    this.pintura = 0;
    this.color = "";
    this.clavos = 0;
    this.tornillos = 0;
    }
    
    public Pedidos(String name, String estado, int material, String color, int herramienta){
    this.color = color;
    this.ID = 0;
    this.Nombre_Cliente = name;
    this.Tipo_mueble = "";
    this.Estado = estado;
    if(material == 1){
        System.out.println("Digite la cantidad de madera a utilizar: ");
        this.madera = leer.nextInt();
    } else {
            this.color = "";
      
    }
    System.out.println("Digite la cantidad de pintura a utilizar: ");
    this.pintura = leer.nextInt();
    if (herramienta == 1) {
        System.out.println("Digite la cantidad de tornillos a utilizar: ");
        this.tornillos = leer.nextInt();
    } else {
        System.out.println("Digite la cantidad de clavos a utilizar: ");
        this.clavos = leer.nextInt();
      
    }
    
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public void setNombre_Cliente(String Nombre_Cliente) {
        this.Nombre_Cliente = Nombre_Cliente;
    }

    public String getTipo_mueble() {
        return Tipo_mueble;
    }

    public void setTipo_mueble(String Tipo_mueble) {
        this.Tipo_mueble = Tipo_mueble;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getMadera() {
        return madera;
    }

    public void setMadera(int madera) {
        this.madera = madera;
    }

    public int getMetal() {
        return metal;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public int getPintura() {
        return pintura;
    }

    public void setPintura(int pintura) {
        this.pintura = pintura;
    }

    public int getClavos() {
        return clavos;
    }

    public void setClavos(int clavos) {
        this.clavos = clavos;
    }

    public int getTornillos() {
        return tornillos;
    }

    public void setTornillos(int tornillos) {
        this.tornillos = tornillos;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public String getInfoPedido() {
        String info = "ID pedido:" + getID() + "\n" +
                "Nombre del Cliente: " + getID() + "\n" +
                "Estado: " + getID() + "\n" +
                "Tipo de mueble: " + getID() + "\n" +
                "Cantidad de materiales: Madera: " + getMadera() + ", Metal: " + getMetal()+  "\n" +
                "Cantidad de pintura: " + getPintura() + ", Color: " + getColor() + "\n" +
                "Cantidad de clavos" + getClavos() + ", cantidad de tornillos" + getTornillos() + "\n";
        return info;
    }
    
}
