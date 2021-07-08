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
                System.out.println("---------------------------------------------------");
                System.out.println(Main.Pedidos.get(i).getInfoPedido());
        }
    }
     public static void AdministrarPedidos(){
         
     }
     
     public static void Pedidos(){
         Boolean ciclo = true;
         while(ciclo) {
             System.out.println("---------------------------------------------------");
             for (int i = 0; i < Main.Pedidos.size(); i++) {
                 System.out.println((i+1)+"- Pedido " + Main.Pedidos.get(i).getID());
             }
             System.out.println("---------------------------------------------------");
             System.out.println("1-Agregar nuevo pedido\n2-Cancelar Pedido\n3-Salir");
            int o = lee.nextInt();
            if (o == 1){
                NPedido();
            } else if (o == 2) {
                while (true){
                    System.out.println("Seleccione el ID del pedido. Los ID estan listados arriba ");
                    int ID = (lee.nextInt()-1);
                    System.out.println("---------------------------------------------------");
                    System.out.println(Main.Pedidos.get(ID).getInfoPedido());
                    System.out.println("---------------------------------------------------");
                    System.out.println("1-Cancelar Pedido\n2-Volver");
                    int opt = lee.nextInt();
                    if (opt == 1){
                        System.out.println("Seguro que desea cancelar el pedido " + Main.Pedidos.get(ID).getID() + " Hecho por " + Main.Pedidos.get(ID).getNombre_Cliente() + "?");
                        System.out.println("1-Cancelar Pedido\n2-Volver");
                        int opt2 = lee.nextInt();
                        if (opt2 == 1) {
                            Main.Pedidos.remove(ID);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                ciclo = false;
            }
         }
     }
     
     public static void Recetas(){
         for (int i = 0; i < Main.Recetas.size(); i++) {
                System.out.println("---------------------------------------------------");
                System.out.println(Main.Recetas.get(i).toString());
        }
     }
     
     public static void Consultas(){
         
     }
     

}
