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
        
     /* Permite al empleado registrar nuevos clientes y agregarlos al arreglo de Usuarios*/
     public static void RegClient() {
        int ID; String nombre, fnac, email, direcc;
        String pass = "";
        System.out.println("Digite la Cédula del cliente: ");
        ID = lee.nextInt();
        String name = getNameClient(ID);              
        if (name.equals("")){
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
        } else {
            System.out.println("El cliente ya se encuentra registrado en el sistema.");
        }
        
     }
     
     
     /* Permite al empleado realizar nuevos pedidos o empezar la fabricacion del mueble de los pedidos aprovados */
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
                        boolean act;
                        if (opts == 1) {
                        System.out.println("Seleccione el ID del pedido a finalizar de la lista anterior");
                            int index = (lee.nextInt()-1);
                            System.out.println("\n" + con.get((index)).getInfoPedido() + "\n");
                            System.out.println("¿Desea inciar la produccion del pedido y finalizarlo?");
                            System.out.println("1-Finalizar\n2-Volver");
                            int o = lee.nextInt();
                            if (o == 1){
                                    int ind = con.get((index)).getTipo_muebleIndx();
                                    act = compararINV(ind);
                                    if (act == true) {
                                        int indx =  getIndexArr(con, index); 
                                        Main.newInv.restarInv(Main.Recetas.get(ind).getRecetaNum());
                                        Main.Pedidos.get((indx)).setEstado("Terminado");
                                    } else {
                                        break;
                                    }
                                break;
                            } else {
                                break;
                            }
                        } else {
                        break;
                       }    
                            
                    }
                                                               
            case 3:
                break;
        }                  
        }
        
     
     /* El pedido es enviado al cliente y pasa al estado "Completado" */
     public static void SendPed(){
        boolean ciclo = true;
        ArrayList<Pedido> cond = new ArrayList();
        int o;
        while(ciclo) {
             cond = LeerPedidos("Etiquetado");
             if (cond.isEmpty()) {
                 System.out.println("Asegurese de etiquetar los pedidos antes de enviarlos\n");
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
                    System.out.println("    1-Enviar Pedido\n2-Volver");
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
     
     
     
     /* Se impime la etiqueta de los muebles terminados, y se le otorga el estado "Etiquetado" en orden de habilitar la entrega del mueble */
     public static void PrintEti(){
 boolean ciclo = true;
        ArrayList<Pedido> cond = new ArrayList();
        int o;
        while(ciclo) {
             cond = LeerPedidos("Terminado");
             if (cond.isEmpty()) {
                 System.out.println("1-Imprimir Etiqueta (No disponible)\n2-Salir");
                 o = lee.nextInt();
                
            } else {
                 System.out.println("1-Imprimir Etiqueta\n2-Salir");
                 o = lee.nextInt();
                 if (o == 1){
                    while (true){
                    System.out.println("Seleccione el ID del pedido. Los ID estan listados arriba ");
                    int ID = (lee.nextInt()-1);
                    System.out.println("<--------------------------------------------------->");
                    System.out.println(cond.get(ID).getInfoPedido());
                    System.out.println("<--------------------------------------------------->");
                    System.out.println("    1-Imprimir Etiqueta\n   2-Volver");
                    int opt = lee.nextInt();
                      if (opt == 1){
                            System.out.println("Informmacion del cliente\n <--------------------------------------------------->");
                            System.out.println(cond.get(ID).getData_Cliente());
                            System.out.println(" <--------------------------------------------------->");
                            int ind =  getIndexArr(cond, ID);                      
                            Main.Pedidos.get(ind).setEstado("Etiquetado");
                            ciclo = false;
                            break;
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
    
   //</editor-fold>  
}
