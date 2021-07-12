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
                Boolean ciclo = true;
         while(ciclo) {
             System.out.println("<--------------------------------------------------->");
             for (int i = 0; i < Main.Pedidos.size(); i++) {
                 System.out.println((i+1)+"- Pedido " + Main.Pedidos.get(i).getID());
             }
             if(Main.Pedidos.isEmpty()) {
                 System.out.println("\n       Sin pedidos para visualizar           \n");
             }
             System.out.println("<--------------------------------------------------->");
             System.out.println("1-Agregar nuevo pedido\n2-Salir");
            int o = lee.nextInt();
            if (o == 1){
                NPedido();
            } else if (o == 2) {               
                ciclo = false;
            }
         }                   
            case 2:
//                int cont = 0;
//                for (int i = 0; i < Main.Pedidos.size(); i++) {
//                    if ("Aprobado".equals(Main.Pedidos.get(i).Estado)) {
//                        cont += 1;
//                        System.out.print(cont + Main.Pedidos.get(i).getInfoPedido());
//                    }
//                }
                    Administrador.LeerPedidos();
                    System.out.println("1-Terminar Pedidos\n2-Volver");               
                    int opts = lee.nextInt();
                    if (opts == 1){                      
                        for (int i = 0; i < Main.Pedidos.size(); i++) {
                        if ("Aprobado".equals(Main.Pedidos.get(i).getEstado())){
                            String as = Main.Pedidos.get(i).getEstado();
                            if ( as.equals("En revisión.")){
                              System.out.println("El Pedido debe ser aprobado antes de que pueda ser terminado.");
                              break;
                            }
                            else{
                              //Main.Terminados.add(Main.Pedidos.get(i));
                            Main.Pedidos.get(i).setEstado("Terminado");  
                            }                            
                            }
                        }
                            break;
                        }                                
            case 3:
                break;
        }                  
        }
        
     public static void SendPed(){
        Boolean ciclo = true;
         while(ciclo) {
             System.out.println("<--------------------------------------------------->");
             for (int i = 0; i < Main.Pedidos.size(); i++) {
                 System.out.println((i+1)+"- Pedido " + Main.Pedidos.get(i).getID());
             } 
             if(Main.Pedidos.isEmpty()) {
                 System.out.println("\n       Sin pedidos para visualizar           \n");
             }
             System.out.println("<--------------------------------------------------->");
             System.out.println("1-Enviar Pedido\n2-Salir");
            int o = lee.nextInt();
            if (o == 1){
                while (true){
                    if (Main.Pedidos.isEmpty()) {
                        System.out.println("\n          \033[31m No hay pedidos para Enviar        \n");
                        break;
                    }
                    System.out.println("Seleccione el ID del pedido. Los ID estan listados arriba ");
                    int ID = (lee.nextInt()-1);
                    System.out.println("<--------------------------------------------------->");
                    System.out.println(Main.Pedidos.get(ID).getInfoPedido());
                    String as = Main.Pedidos.get(ID).getEstado();
                    System.out.println("<--------------------------------------------------->");
                    System.out.println("1-Enviar Pedido\n2-Volver");
                    int opt = lee.nextInt();
                    if (as.equals("Terminado")){
                      if (opt == 1){
                        System.out.println("¿Esta seguro de querer enviar el pedido?" + Main.Pedidos.get(ID).getID() + " Hecho por " + Main.Pedidos.get(ID).getNombre_Cliente() + "?");
                        System.out.println("1-Enviar Pedido\n2-Volver");
                        System.out.println("Pedido Enviado a su destino!");
                        int opt2 = lee.nextInt();
                        if (opt2 == 1) {
                            Main.Pedidos.remove(ID);
                            break;
                            }
                            } 
                            else {
                            break;
                            }  
                    }
                    else {
                       System.out.println("Este pedido no puede ser enviado todavía, solicite ayuda al Administrador"); 
                       break;
                    }     
                }
                
            } else if (o == 2) { 
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
