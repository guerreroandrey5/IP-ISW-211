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
    
    public Administrador(Usuario user){
        boolean control = true;
        while(control){
            control = menu();
        }
    }
    
    public Administrador(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase){
        super(Ced, Nombre, Fecha, Correo, Tipo, Contrase);

    }
    
    public boolean menu(){
        int opt;
        System.out.println("Bienvenido " + getName());
        System.out.println("Leer Pedidos (1)");
        System.out.println("Aprobar/Rechazar Cartas (2)");
        System.out.println("Pedidos (3)");
        System.out.println("Recetas (4)");
        System.out.println("Consultas (5)");
        System.out.println("Regresar al inicio de sesión (6)");
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
                return false;
        }
        return true;
    }

    public static void LeerPedidos() {
        
    }
     public static void AdministrarPedidos(){
         
     }
     
     public static void ProcesarPedidos(){
         
     }
     
     public static void Consultas(){
         
     }
     

}
