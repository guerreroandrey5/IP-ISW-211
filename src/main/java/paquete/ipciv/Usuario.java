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
    private int ID;
    private String Name;
    private String FechaNacimiento;
    private String Correo;
    private String Type;
    private String Password;
    private ArrayList<Pedido> APedidos;
    
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
            if (ID == Main.Usuarios.get(i).getID() ){
                name = Main.Usuarios.get(i).getName();
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
    
    public static ArrayList<Pedido> LeerPedidos(String term) {
        int com = 0;
        ArrayList<Pedido> data = new ArrayList();
        if (Main.Pedidos.isEmpty()) {} else {
            System.out.println("<--------------------------------------------------->");
            for (int i = 0; i < Main.Pedidos.size(); i++) {
                if (term != "" && term != "id") {
                    if((term).equals(Main.Pedidos.get(i).getEstado())){
                    com++;
                    System.out.println((com)+"- Pedido " + Main.Pedidos.get(i).getID());
                    data.add(Main.Pedidos.get(i));
                    System.out.println("<--------------------------------------------------->");
                    }
                } else if (("id").equals(term)) {
                    com++;
                    System.out.println((com)+"- Pedido " + Main.Pedidos.get(i).getID());
                    data.add(Main.Pedidos.get(i));
                    System.out.println("<--------------------------------------------------->");                
               
                } else {
                    System.out.println(Main.Pedidos.get(i).getInfoPedido());
                    com++;
                    data.add(Main.Pedidos.get(i));
                    System.out.println("<--------------------------------------------------->");
                }
            }
        }
        if (com == 0) {
            System.out.println("<--------------------------------------------------->");
            System.out.println("                \nNo hay pedidos para visualizar.                   \n");
            System.out.println("<--------------------------------------------------->");
        }
        return data;
    }
    
    public static int getIndexArr(ArrayList<Pedido> list2, int index) {
        ArrayList<Pedido> list1 = Main.Pedidos;
        int ind = 0;
        for (int i = 0; i < Main.Pedidos.size(); i++) {
            String infoID = Main.Pedidos.get(i).getID();
            for (int j = 0; j < list2.size(); j++) {
                if((infoID).equals(list2.get(index).getID())){
                    ind = i;
                    break;
                }
            }
        }
        return ind;
    }
    
    public static boolean compararINV(int index){
        boolean condition = true;
        boolean bypass = true;
        int madera = 0, metal = 0, pintura = 0, clavos = 0, tornillos = 0;
        for (int j = 0; j < Main.Recetas.size(); j++) {
                     if (j == index) {
                         madera =  Main.Recetas.get(j).getRmadera();
                         metal =  Main.Recetas.get(j).getRmetal();
                         pintura =  Main.Recetas.get(j).getRpintura();
                         clavos =  Main.Recetas.get(j).getRclavos();
                         tornillos = Main.Recetas.get(j).getRtornillos();
                     }
                 }
        int[] inventario = new int[5];
        inventario = Main.newInv.getInventearioNum();
        int[] receta = new int[] {madera,metal,pintura,clavos,tornillos};
        for (int i = 0; i < inventario.length; i++) {
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
            if (condition == false && bypass == true) {
                bypass = condition;
            }
            condition = alert(inventario[i], receta[i], mueble);
            
        }
        return bypass;
    
    }
    
         public static boolean alert(int av, int ned, String fur) {
         if (av < ned) {
             System.out.println("\033[31m No hay suficientes materiales");
             System.out.println("   \033[32m Se recomienda comprar " + (ned - av) + " de " + fur + " para poder completar los pedidos\n");
             return false;
         } 
         return true;
     }
     
    
    //</editor-fold>
}
