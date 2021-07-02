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
            System.out.println("Registrar Clientes (1)");
            System.out.println("Realizar/Finalizar Pedido (2)");
            System.out.println("Imprimir Váucher/Etiqueta (3)");
            System.out.println("Regresar al inicio de sesión (4)");
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
                return false;
        }
        return true;
    }
     public static void RegClient() {
        
     }
     public static void ReaFinPed(){   
     }
     
     public static void PrintEti(){
         
     }
     
}
