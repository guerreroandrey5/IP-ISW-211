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
    Usuario User = new Usuario();

    public static void main(String[] args) {
        // TODO code application logic here
         Main.menu();
    }
    static void menu(){
        int opc = Main.valor();
        switch (opc)
        {
            case 1:
            Main.Reg();
            break;
            case 2:
           //Main.login();
            break;
        default:
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
    int ID; String nombre, fnac, email, pass;
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
        Main.menu();
    }
    static void login(){
    int ID = 13;
    int IDinput; String passinput;
    String pass = "abc";
        System.out.println("Digite su Cédula (ID): ");
        IDinput = lee.nextInt();
        System.out.println("Digite una contraseña: ");
        passinput = lee.next();
        if (IDinput == ID && passinput == pass){
        }
    }
    //<editor-fold defaultstate="collapsed" desc="Menú Administrador">
    static void calcmenu(){
    int opcs = Main.valors();
        switch (opcs)
        {
            case 1:
            //Main.lpedi();
            break;
            case 2:
            //Main.apcar();
            break;
            case 3:
            //Main.pedi();
            break;
            case 4:
            //Main.rec();
            break;
            case 5:
            //Main.consul();
            break;
            case 6:
            Main.menu();
            break;
        default:
        }
    }
    static int valors(){
        int opcs;
        System.out.println("Leer Pedidos (1)");
        System.out.println("Aprobar/Rechazar Cartas (2)");
        System.out.println("Pedidos (3)");
        System.out.println("Recetas (4)");
        System.out.println("Consultas (5)");
        System.out.println("Regresar al inicio de sesión (6)");
        opcs = lee.nextInt();
        return opcs;
    }

    }
    

