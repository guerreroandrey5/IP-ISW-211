/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Cris
 */
public class Usuario {
    public static Scanner lee = new Scanner(System.in);  
    private int ID;
    private String Name;
    private String FechaNacimiento;
    private String Correo;
    private String Type;
    private String Password;
    protected ArrayList<Pedidos> APedidos;
    
    public Usuario(){
        this.ID = 0;
        this.Correo = "";
        this.FechaNacimiento = "";
        this.Name = "";
        this.Password = "";
        this.Type = "";
    }
    
    public Usuario(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase) {
        this.ID = Ced;
        this.APedidos = Main.Pedidos;
        this.Correo = Correo;
        this.FechaNacimiento = Fecha;
        this.Name = Nombre; 
        this.Password = Contrase;
        this.Type = Tipo;
        
    }
    
    
    public String getName() {
        return this.Name;
    }
    public int getID() {
        return this.ID;
    }
    public String getFecha() {
        return this.FechaNacimiento;
    }
    public String getContra() {
        return this.Password;
    }
    
    public String getTipo(){
        return this.Type;
    }
    
    public String getCorreo(){
        return this.Correo;
    }
    
    public static String getNameClient(int ID){
        String name = "";
        for (int i = 0; i < Main.Usuarios.size(); i++) {
            if (ID == Main.Usuarios.get(i).ID ){
                name = Main.Usuarios.get(i).Name;
            }
        }
        return name;
    }
    
}
