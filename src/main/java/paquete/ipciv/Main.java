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
    public static Usuario User = new Usuario();

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
           Main.login();
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
         User.AgregarUsuario(newUser);
        } else {
         Empleado newUser = new Empleado(ID, nombre, fnac, email, "Empleado", pass);
         User.AgregarUsuario(newUser);            
        }
        Main.menu();
    }
    static void login(){
    ArrayList<Usuario> Usuarios = User.GetUsuarios();
    int ID = 13;
    int IDinput; String passinput;
    String pass = "abc";
        System.out.println("Digite su Cédula (ID): ");
        IDinput = lee.nextInt();
        System.out.println("Digite una contraseña: ");
        passinput = lee.next();
        for (int i = 0; i <Usuarios.size() ; i++) {
            if (Usuarios.get(i).getID() == IDinput && Usuarios.get(i).getContra() == pass) {
                if ("Admin" == Usuarios.get(i).getTipo()){
                    Administrador Admin = new Administrador(Usuarios.get(i));
                } else {
                    Empleado Empleado = new Empleado(Usuarios.get(i));
                }                
            } else {
                System.out.println("Nombre de usuario o contraseña incorrectos");
            }

        }
        
    }
   


    }
    

