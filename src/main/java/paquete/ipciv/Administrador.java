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
     
    public Administrador(Usuario User){
       super(User.getID(),User.getName(), User.getFecha(), User.getCorreo(), User.getTipo(), User.getContra());
    }   
    public Administrador(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase){
       super(Ced, Nombre, Fecha, Correo, Tipo, Contrase);
    }   
    public boolean Menu(){
        int opt;
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
                    Pedidos();
                    
                    break;
                case 4:
                    Recetas();
                    
                    break;
                case 5:
                    Consultas();
                    
                    break;
                case 6:
                    return false;
            }
            return true;
    }
    

    public static void LeerPedidos() {
        for (int i = 0; i < Main.Pedidos.size(); i++) {
                System.out.println(Main.Pedidos.get(i));
        }
    }
     public static void AdministrarPedidos(){
         
     }
     
     public static void Pedidos(){
         for (int i = 0; i < Main.Pedidos.size(); i++) {
                System.out.println(Main.Pedidos.get(i));
        }
     }
     
     public static void Recetas(){
         for (int i = 0; i < Main.Recetas.size(); i++) {
                System.out.println(Main.Recetas.get(i));
        }
     }
     
     public static void Consultas(){
         
     }
     

}
