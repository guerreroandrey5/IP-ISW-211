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
    
    public Empleado(Usuario user){
        boolean control = true;
        while(control){
            control = menu();
        }
    }
    
    public Empleado(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String Contrase){
        super(Ced, Nombre, Fecha, Correo, Tipo, Contrase);

    }
    
        public boolean menu(){
        int opt;
        System.out.println("Bienvenido " + getName());
        opt = lee.nextInt();
        switch (opt) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
            case 4:
                
                break;
            case 5:
                return false;
        }
        return true;
    }
}
