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

public class Administrador extends Usuario { 
    public Administrador(Usuario User){
       super(User.getID(),User.getName(), User.getFecha(), User.getCorreo(), User.getTipo(), User.getContra());
    }   
    public Administrador(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase){
       super(Ced, Nombre, Fecha, Correo, Tipo, Contrase);
    }   
    public boolean Menu(){
        int opt;
            System.out.println("1-Leer Pedidos");
            System.out.println("2-Aprobar/Rechazar Cartas");
            System.out.println("3-Pedidos");
            System.out.println("4-Recetas");
            System.out.println("5-Consultas");
            System.out.println("6-Regresar al inicio de sesión");
            opt = lee.nextInt();
            switch (opt) {
                case 1:
                    LeerPedidos("");
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
    
//<editor-fold defaultstate="collapsed" desc="Métodos">
    
     public static void AdministrarPedidos(){
         ArrayList<Pedido> comp = LeerPedidos("En revisión.");
            if (comp.isEmpty()) {} else {
                System.out.println("Seleccione el ID del pedido a administrar");
                int index = lee.nextInt();
                if (index > 0) {
                    index = index -1;
                }
                System.out.println("\n" + comp.get((index)).getInfoPedido() + "\n");
                System.out.println("1-Aprobar\n2-Rechazar\n3-Volver");
                int lop = lee.nextInt();
                switch (lop) {
                    case 1:
                        System.out.println("¿Esta seguro de querer aprobar el pedido?\n1-Si\n2-No");
                        int apv = lee.nextInt();
                        if (apv == 1) {
                            int ind =  getIndexArr(comp, index);      
                            Main.Pedidos.get(ind).setEstado("Aprobado");                         
                        }
                        break;
                    case 2:
                        System.out.println("¿Desea rechazar el pedido?");
                        int rch = lee.nextInt();
                        if (rch == 1) {
                            Main.Pedidos.remove(index); 
                        }
                        break;
                        
                    case 3:
                        break;
                }
            }
        }
     
        
     
     public static void Pedidos(){
         boolean ciclo = true;
         ArrayList<Pedido> con;
         while(ciclo) {
             con = LeerPedidos("id");
             System.out.println("1-Agregar nuevo pedido\n2-Cancelar Pedido\n3-Salir");
            int o = lee.nextInt();
            if (o == 1){
                NPedido();
            } else if (o == 2) {
                while (true){
                    if (con.isEmpty()) {
                        System.out.println("\n          \033[31m No hay pedidos para cancelar        \n");
                        break;
                    }
                    System.out.println("Seleccione el ID del pedido. Los ID estan listados arriba ");
                    int ID = (lee.nextInt()-1);
                    System.out.println("<--------------------------------------------------->");
                    System.out.println(con.get(ID).getInfoPedido());
                    System.out.println("<--------------------------------------------------->");
                    System.out.println("1-Cancelar Pedido\n2-Volver");
                    int opt = lee.nextInt();
                    if (opt == 1){
                        System.out.println("¿Esta seguro de querer cancelar el pedido? " + Main.Pedidos.get(ID).getID() + " Hecho por: " + Main.Pedidos.get(ID).getNombre_Cliente() + "?");
                        System.out.println("1-Cancelar Pedido\n2-Volver");
                        int opt2 = lee.nextInt();
                        if (opt2 == 1) {
                            int ind =  getIndexArr(con, ID);      
                            Main.Pedidos.remove(ind);
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
                System.out.println("<--------------------------------------------------->");
                System.out.println(Main.Recetas.get(i).toString());
        }
     }
     
     public static void Consultas(){
        int opt;
            System.out.println("1-Consultar Inventario de Insumos");
            System.out.println("2-Consultar Muebles Terminados");
            System.out.println("3-Volver");
        opt = lee.nextInt();
        switch (opt) {
            case 1:  
                String sInv = Main.newInv.toString();
                System.out.println(sInv);
                CompararPM(false);
                System.out.println("\n1-Comparar pedidos con materiales disponibles\n2-Salir");
                int ac = lee.nextInt();
                switch(ac) {
                    case 1:
                        if (Main.Pedidos.isEmpty()) {
                            System.out.println("                \nNo hay pedidos en estado de revisión.     \n");   
                        } else {
                         CompararPM(true); 
                        }
                        break;
                    case 2:
                        break;
                }
                break;
                
            case 2:       
                ArrayList<Pedido> con = LeerPedidos("Terminado");
                if (con.isEmpty()) {} else {
                   System.out.println("Seleccione el ID del pedido a visualizar");
                int index = (lee.nextInt()-1);
                int ind = 0;
                ind =  getIndexArr(con, index);              
                System.out.println("\n" + Main.Pedidos.get((ind)).getInfoPedido() + "\n"); 
                }
                break;
            case 3:
                break;
        }   
     }
     
     public static void CompararPM(boolean condition){
        int[] receta;
        int madera = 0;
        int metal = 0;
        int pintura = 0;
        int clavos = 0;
        int tornillos = 0;
        int[] inventario = new int[5];
        inventario = Main.newInv.getInventearioNum();
        if(condition) {
         for (int i = 0; i < Main.Pedidos.size(); i++) {
             if ("En revisión.".equals(Main.Pedidos.get(i).getEstado()) || "Aprobado".equals(Main.Pedidos.get(i).getEstado())) {
                 int mueble = Main.Pedidos.get(i).getTipo_muebleIndx();
                 for (int j = 0; j < Main.Recetas.size(); j++) {
                     if (j == mueble) {
                         madera = madera + Main.Recetas.get(j).getRmadera();
                         metal = metal + Main.Recetas.get(j).getRmetal();
                         pintura = pintura + Main.Recetas.get(j).getRpintura();
                         clavos = clavos + Main.Recetas.get(j).getRclavos();
                         tornillos = tornillos + Main.Recetas.get(j).getRtornillos();
                     }
                 }
             }
         }
            receta = new int[] {madera,metal,pintura,clavos,tornillos};
            for (int i = 0; i < 5; i++) {
                String mueble = "";
                switch(i){
                    case 0:
                        mueble = "Madera";
                        break;
                    
                    case 1:
                        mueble = "Metal";
                        break;
                        
                        
                    
                    case 2:
                        mueble = "Pintura";
                        break;
                        
                    
                    case 3:
                        mueble = "Clavos";
                        break;
                        
                        
                    
                    case 4:
                        mueble = "Tornillos";
                        break;
            }
                System.out.println("----------------> " + mueble);
                System.out.println("\nCantidad de " + mueble +" necesaria para los pedidos: " + receta[i]);
                System.out.println("Cantidad de "+ mueble +" disponible: " + inventario[i] + "\n");
                alert(inventario[i], receta[i], mueble);
            }
            
        } else {
            
            for (int i = 0; i < Main.Recetas.size(); i++) {
             receta = Main.Recetas.get(i).getRecetaNum();
             String mueble = Main.Recetas.get(i).getNmueble();
             cantM(inventario, receta, mueble);
             }
        }
         
    }
   
     
     public static void cantM(int[] av, int[] ned, String mueble) {
         int cantidad = 0;
         for (int i = 0; i < av.length; i++) {
          if(ned[i] == 0) {
              continue;
             } else if (ned[i] > av[i]) {
                 cantidad = 0;
                 break;
             } else {
                 if (i == 0 || cantidad == 0) {
                     cantidad = av[i]/ned[i];    
                 } else if (cantidad > (av[i]/ned[i])){
                    cantidad = av[i]/ned[i];
                 }                
                
             }   
         }
         if (cantidad == 0) {
             System.out.println("No es posible crear " + mueble);
         } else {            
            System.out.println("La cantidad de " + mueble + " que se pueden crear es de: " + cantidad);
         }
     }
     
    
     
//</editor-fold>
}
