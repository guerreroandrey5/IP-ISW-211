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
}
