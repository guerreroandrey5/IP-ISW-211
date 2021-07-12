/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

import java.util.*;

/**
 *
 * @author guerreroandrey5
 */
public class Main {

    /**
     * @param args the command line arguments
     */
//<editor-fold defaultstate="collapsed" desc="ArrayLists">
    protected static Scanner lee = new Scanner(System.in);
    protected static ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
    protected static ArrayList<Pedido> Pedidos = new ArrayList<Pedido>();
    protected static ArrayList<Receta> Recetas = new ArrayList<Receta>();
    protected static ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    protected static ArrayList<Inventario> Inventarios = new ArrayList<Inventario>();
    protected static ArrayList<Pedido> Terminados = new ArrayList<Pedido>(); 
//</editor-fold>
    public static void main(String[] args) {
        // TODO code application logic here
         Main.fload();
         Main.menu();        
    }
    
    static void menu(){
        while (true) {
        int opc = Main.valor();
        switch (opc)
        {
        case 1:
            Main.login();            
            break;
            
            case 2:
            System.out.println("Hoy será un día maravilloso!");
            
            break;
        default:
        }            
        }
    }
    
//<editor-fold defaultstate="collapsed" desc="Métodos">
    static int valor(){
        int opc;
        System.out.println("\nBienvenido al sistema de la Fábrica de Muebles\n");
        System.out.println("    1-Login    ");
        System.out.println("    2-Mensaje Motivacional    ");
        opc = lee.nextInt();
        return opc;
    }
    
    static void login(){
    int IDinput; 
    String passinput;
        System.out.println("Digite su Cédula (ID): ");
        IDinput = lee.nextInt();
        System.out.println("Digite una contraseña: ");
        passinput = lee.next();
        for (int i = 0; i <Usuarios.size() ; i++) {
            if (Usuarios.get(i).getID() == IDinput && Usuarios.get(i).getContra().equals(passinput)) {
                if ("Admin" == Usuarios.get(i).getTipo()){
                    System.out.println("Bienvenido Administrado " + Usuarios.get(i).getName());
                    Administrador USER = new Administrador(Usuarios.get(i));
                    boolean control = true;
                    while(control){
                        control = USER.Menu();
                    }
                } else if ("Empleado" == Usuarios.get(i).getTipo()){
                    System.out.println("Bienvenido Empleado " + Usuarios.get(i).getName());
                    Empleado USER = new Empleado(Usuarios.get(i));
                    boolean control = true;
                    while(control){
                        control = USER.Menu();
                    }
                } 
                
            } 
        }       
    }
    
    static void fload(){
        
        int n1 = (int) (Math.random()*300+0);
        int n2 = (int) (Math.random()*300+0);
        int n3 = (int) (Math.random()*300+0);
        int n4 = (int) (Math.random()*300+0);
        int n5 = (int) (Math.random()*300+0);
        
        Administrador newUserad = new Administrador(23, "Pedro", "06/11/2002", "admin@mueblesitos.siuuu", "Admin", "123");
        Empleado newUserem = new Empleado(20, "Esteban", "20/06/2000", "worker@mueblesitos.siuuu", "Empleado", "13");
        Cliente newUsercl = new Cliente(22, "Piter", "20/06/2000", "Piter@haus.com", "Cliente", "Choza","");
        Receta newRecipe1 = new Receta("Mesita Gamer", /*Madera*/10, /*Metal*/0, /*Pintura*/20, /*Clavos*/10, /*Tornillos*/0);
        Receta newRecipe2 = new Receta("Banquito de Metal Reforzado Gamer", /*Madera*/0, /*Metal*/20, /*Pintura*/15, /*Clavos*/0, /*Tornillos*/20);
        Receta newRecipe3 = new Receta("Estantería Gamer", /*Madera*/10, /*Metal*/0, /*Pintura*/10, /*Clavos*/8, /*Tornillos*/0);
        Inventario newInv = new Inventario(/*Madera*/n1, /*Metal*/n2, /*Pintura*/n3, /*Clavos*/n4, /*Tornillos*/n5);
        Usuarios.add(newUserad); 
        Usuarios.add(newUsercl);
        Usuarios.add(newUserem);
        Recetas.add(newRecipe1); 
        Recetas.add(newRecipe2);
        Recetas.add(newRecipe3);
        Inventarios.add(newInv);
    }
    
    //</editor-fold>
    
}
