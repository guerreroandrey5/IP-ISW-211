/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;
import java.util.*;

/**
 *
 * @author Cris
 */
public class Usuario {
    public static Scanner lee = new Scanner(System.in);  
    protected int ID;
    protected String Name;
    protected String FechaNacimiento;
    protected String Correo;
    protected String Type;
    protected String Password;
    protected ArrayList<Pedido> APedidos;
    
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
    
    //<editor-fold defaultstate="collapsed" desc="Gets & Sets">
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
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Métodos">
    public static String getNameClient(int ID){
        String name = "";
        for (int i = 0; i < Main.Usuarios.size(); i++) {
            if (ID == Main.Usuarios.get(i).ID ){
                name = Main.Usuarios.get(i).Name;
            }
        }
        return name;
              
    }
    public static void NPedido(){
                System.out.println("Digite la Cédula del cliente: ");
                int IDC = lee.nextInt();
                String name = getNameClient(IDC);              
                if (name.equals("")){
                System.out.println("Ese cliente no se encuentra registrado en el sistema.");            
                    }
                else{
                String state = "En revisión.";
                System.out.println("Ingrese el tipo de mueble: ");
                for (int i = 0; i < Main.Recetas.size(); i++) {
                    System.out.println((i+1)+ "-" + Main.Recetas.get(i).getNmueble());
                    }
                int type = lee.nextInt();
                String ID = "";
                if (type == 1) {
                    ID = "MST" + ((int)(Math.random() * 9) + 1) + (IDC);
                    } else if (type == 2) {
                    ID = "BG" + ((int)(Math.random() * 9) + 1) + (IDC);
                    } else if (type == 3) {
                    ID = "EG" + ((int)(Math.random() * 9) + 1) + (IDC);
                    }
                Pedido pedido = new Pedido(name, state, type, ID);
                Main.Pedidos.add(pedido);
                }
    }
    
    //</editor-fold>
}
