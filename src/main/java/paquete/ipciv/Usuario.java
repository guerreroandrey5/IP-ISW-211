/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Cris
 */
public class Usuario {
    public Scanner lee = new Scanner(System.in);  
    private int ID;
    private String Name;
    private String FechaNacimiento;
    private String Correo;
    private String Type;
    private String Password;
    private ArrayList Usuarios = new ArrayList();
    
    public Usuario(){
        this.ID = 0;
        this.Correo = "";
        this.FechaNacimiento = "";
        this.Name = "";
        this.Password = "";
        this.Type = "";
    }
    
    public Usuario(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase){
        this.ID = Ced;
        this.Correo = Correo;
        this.FechaNacimiento = Fecha;
        this.Name = Nombre; 
        this.Password = Contrase;
        this.Type = Tipo;
    }
    
    public void AgregarUsuario(Usuario user){
        this.Usuarios.add(user);
    }
}
