/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

import java.util.ArrayList;

/**
 *
 * @author Cris
 */
public class Empleado extends Usuario {
    
    public Empleado(Usuario User){
        super(User.getID(),User.getName(), User.getFecha(), User.getCorreo(), User.getTipo(), User.getContra());
    }  
    public Empleado(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase){
        super(Ced, Nombre, Fecha, Correo, Tipo, Contrase);
    }  
    
        public boolean Menu(){
        int opt;
            System.out.println("1-Registrar Clientes");
            System.out.println("2-Realizar/Finalizar Pedido");
            System.out.println("3-Imprimir Váucher/Etiqueta");
            System.out.println("4-Enviar Pedidos");
            System.out.println("5-Regresar al inicio de sesión");
        opt = lee.nextInt();
        switch (opt) {
            case 1:
                RegClient();         
                break;
            case 2:
                ReaFinPed();
                break;
            case 3:
                PrintEti();
                break;
            case 4:
                SendPed();
                break;
            case 5:
                return false;
        }
        return true;
    }
        
        //<editor-fold defaultstate="collapsed" desc="Métodos">
     public static void RegClient() {
        int ID; String nombre, fnac, email, direcc;
        String pass = "";
        System.out.println("Digite la Cédula del cliente: ");
        ID = lee.nextInt();
        System.out.println("Digite el nombre completo del cliente (Si desea utilizar espacios, utlice guiones en lugar de espacios): ");
        nombre = lee.next();
        System.out.println("Digite la fecha de nacimiento del cliente (dd/mm/aaaa): ");
        fnac = lee.next();
        System.out.println("Digite el correo electrónico del cliente: ");
        email = lee.next();
        System.out.println("Digite la dirección del domicilio del cliente(Si desea utilizar espacios, utlice guiones en lugar de espacios): ");
        direcc = lee.next();
        Cliente newUser = new Cliente(ID, nombre, fnac, email, "Cliente", direcc, pass);
        Main.Usuarios.add(newUser);
     }
     
     public static void ReaFinPed(){
         int opt;
            System.out.println("1-Realizar Pedido");
            System.out.println("2-Finalizar Pedido");
            System.out.println("3-Volver");
        opt = lee.nextInt();
        switch (opt) {
            case 1:
                NPedido();
                break;
            case 2:
                ArrayList<Pedido> con = new ArrayList<>();
                    con = LeerPedidos("Aprobado");
                    int opts;
                    if (con.isEmpty()) {
                        System.out.println("1-Terminar Pedidos (No disponible)\n2-Volver");
                        opts = lee.nextInt();
                    } else {
                        System.out.println("1-Terminar Pedidos\n2-Volver");    
                        opts = lee.nextInt();
                        if (opts == 1)
                            System.out.println("Seleccione el ID del pedido a finalizar de la lista anterior");
                            int index = (lee.nextInt()-1);
                            System.out.println("\n" + con.get((index)).getInfoPedido() + "\n");
                            System.out.println("¿Desea inciar la produccion del pedido y finalizarlo?");
                            System.out.println("1-Finalizar\n2-Volver");
                            int o = lee.nextInt();
                            if (o == 1){
                                int ind =  getIndexArr(con, index); 
                                Main.Pedidos.get((ind)).setEstado("Terminado");
                                break;
                            } else {
                                break;
                            }
                    }
                    if (opts == 2){
                        break;
                       }                                               
            case 3:
                break;
        }                  
        }
        
     public static void SendPed(){
        boolean ciclo = true;
        ArrayList<Pedido> cond = new ArrayList();
        int o;
        while(ciclo) {
             cond = LeerPedidos("Terminado");
             if (cond.isEmpty()) {
                 System.out.println("1-Enviar Pedido (No disponible)\n2-Salir");
                 o = lee.nextInt();
                
            } else {
                 System.out.println("1-Enviar Pedido\n2-Salir");
                 o = lee.nextInt();
                 if (o == 1){
                    while (true){
                    System.out.println("Seleccione el ID del pedido. Los ID estan listados arriba ");
                    int ID = (lee.nextInt()-1);
                    System.out.println("<--------------------------------------------------->");
                    System.out.println(cond.get(ID).getInfoPedido());
                    System.out.println("<--------------------------------------------------->");
                    System.out.println("1-Enviar Pedido\n2-Volver");
                    int opt = lee.nextInt();
                      if (opt == 1){
                        System.out.println("¿Esta seguro de querer enviar el pedido?" + cond.get(ID).getID() + " Hecho por " + cond.get(ID).getNombre_Cliente() + "?");
                        System.out.println("1-Enviar Pedido\n2-Volver");
                        int opt2 = lee.nextInt();
                        if (opt2 == 1) {
                            int ind =  getIndexArr(cond, ID);                         
                            System.out.println("Pedido Enviado a su destino!");
                            Main.Pedidos.get(ind).setEstado("Completado");
                            break;
                            }
                       } else {
                            break;
                            }  
                    }
                    }     
                }
             if (o == 2) { 
                ciclo = false;
                }             
         }
     }
     
     public static void PrintEti(){
        for(int i = 0; i < Main.Pedidos.size() ; i++) {
            if("Completado".equals(Main.Pedidos.get(i).Estado)){
                Main.Pedidos.get(i).getInfoPedido();
            }
        }
     }
    
   //</editor-fold>  
}
