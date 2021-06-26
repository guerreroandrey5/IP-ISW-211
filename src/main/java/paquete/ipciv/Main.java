/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author guerr
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static Usuario USER = new Usuario();
    public static Scanner lee = new Scanner(System.in);
    public static ArrayList<Usuario> Usuarios = new ArrayList();
    
    public static void main(String[] args) {
        // TODO code application logic here
         Main.menu();
    }
    static void menu(){
        while (true) {
        int opc = Main.valor();
        switch (opc)
        {
            case 1:
            Main.Reg();
            break;
            case 2:
           Main.login();
            break;
        default:
        }            
        }

    }

    static int valor(){
        int opc;
        System.out.println("Registro (1)");
        System.out.println("Login (2)");
        opc = lee.nextInt();
        return opc;
    }
    static void Reg(){
    int ID, tipo; String nombre, fnac, email, pass;
        System.out.println("Digite su Cédula (ID): ");
        ID = lee.nextInt();
        System.out.println("Digite su nombre completo (Si desea usar espacios, utlice guiones en lugar de espacios)");
        nombre = lee.next();
        System.out.println("Digite su fecha de nacimiento (XX/XX/XXXX): ");
        fnac = lee.next();
        System.out.println("Digite su correo electrónico: ");
        email = lee.next();
        System.out.println("Digite una contraseña: ");
        pass = lee.next();
        System.out.println("Digite el tipo de usuario 1-Administrador 2-Empleado: ");
        tipo = lee.nextInt();
        if (tipo == 1) {
         Administrador newUser = new Administrador(ID, nombre, fnac, email, "Admin", pass);
         Usuarios.add(newUser);
        } else {
         Empleado newUser = new Empleado(ID, nombre, fnac, email, "Empleado", pass);
         Usuarios.add(newUser);            
        }
        Main.menu();
    }
    static void login(){
    
    int ID = 13;
    int IDinput; 
    String passinput;
        System.out.println("Digite su Cédula (ID): ");
        IDinput = lee.nextInt();
        System.out.println("Digite una contraseña: ");
        passinput = lee.next();
        for (int i = 0; i <Usuarios.size() ; i++) {
            if (Usuarios.get(i).getID() == IDinput && Usuarios.get(i).getContra().equals(passinput)) {
                boolean control = true;
                USER = Usuarios.get(i);
                System.out.println("Bienvenido " + USER.getName());
                if ("Admin" == Usuarios.get(i).getTipo()){
                    while(control){
                        control = menuUsuario(true);
                    }
                } else {
                    while(control){
                        control = menuUsuario(false);
                    }
                }                
            } 

        }
        
    }
   
    public static boolean menuUsuario(boolean Admin){
        int opt;
        if(Admin) {
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
                case 4:
                    Recetas();
                    break;
                case 5:
                    Consultas();
                case 6:
                    return false;
            }
        } else {
            opt = lee.nextInt();
            switch (opt) {
                case 1:
                
                    break;
                case 2:
                
                    break;
                case 3:
                    break;
                case 4:
                
                    break;
                case 5:
                    return false;
        }
        }

        return true;
    }

    public static void LeerPedidos() {
        
    }
     public static void AdministrarPedidos(){
         
     }
     
     public static void Pedidos(){
         
     }
     
     public static void Recetas(){
         
     }
     
     public static void Consultas(){
         
     }
     

    }
    

