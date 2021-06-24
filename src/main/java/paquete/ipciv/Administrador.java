/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

/**
 *
 * @author Cris
 */
public class Administrador extends Usuario {

    protected int ID;
    protected String Name;
    
    public Administrador(){
        this.ID = 0;
        this.Name = "";
    }
    
    public Administrador(int Cedula, String Nombre){
        this.ID = Cedula;
        this.Name = Nombre;
        boolean control = false;
        
        while(control){
            control = menu();
        }
    }
    
    public boolean menu(){
        int opt;
        System.out.println("Bienvenido " + this.Name);
        System.out.println("Seleccione la accion que desea realizar: \n1-Leer pedidos\n2-Administrar Pedidos\n3-Procesar Pedidos\n4-Consultas\n5-Salir");
        opt = lee.nextInt();
        switch (opt) {
            case 1:
                LeerPedidos();
                break;
            case 2:
                AdministrarPedidos();
                break;
            case 3:
                ProcesarPedidos();
            case 4:
                Consultas();
                break;
            case 5:
                return true;
        }
        return false;
    }

    public static void LeerPedidos() {
        
    }
     public static void AdministrarPedidos(){
         
     }
     
     public static void ProcesarPedidos(){
         
     }
     
     public static void Consultas(){
         
     }
     
     public String getNombre() {
         return this.Name;
     }
     public int getID(){
         return this.ID;
     }
}
