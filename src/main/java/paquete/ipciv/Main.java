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

    public static Scanner lee = new Scanner(System.in);
    public static ArrayList<Usuario> Usuarios = new ArrayList();
    
    public static void main(String[] args) {
        // TODO code application logic here
        Administrador newUserad = new Administrador(23, "Pedro", "06/11/2002", "admin@mueblesitos.siuuu", "Admin", "123");
        Empleado newUserem = new Empleado(20, "Esteban", "20/06/2000", "worker@mueblesitos.siuuu", "Empleado", "13");
        Usuarios.add(newUserad); 
        Usuarios.add(newUserem);
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
            //case 2:
            //Main.login();
            //break;
        default:
        }            
        }
    }

    static int valor(){
        int opc;
        System.out.println("Bienvenido al sistema de la Fábrica de Muebles");
        System.out.println("Login (1)");
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
            System.out.println(Usuarios.get(i).getContra().equals(passinput));
            if (Usuarios.get(i).getID() == IDinput && Usuarios.get(i).getContra().equals(passinput)) {
                System.out.println("Bienvenido " + Usuarios.get(i).getName());
                if ("Admin" == Usuarios.get(i).getTipo()){
                    Administrador USER = new Administrador(Usuarios.get(i));
                    boolean control = true;
                    while(control){
                        control = USER.Menu();
                    }
                } else {
                    Empleado USER = new Empleado(Usuarios.get(i));
                }                
            } 
        }       
    }
}
    

