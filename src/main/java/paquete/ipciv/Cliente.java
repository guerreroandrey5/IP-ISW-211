/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

/**
 *
 * @author guerr
 */
public class Cliente extends Usuario {
    protected String direcc
            ;
    public Cliente(int Ced, String Nombre, String Fecha, String Correo, String Tipo, String direcc , String Contrase){       
        super(Ced, Nombre, Fecha, Correo, Tipo, Contrase); 
        this.direcc = direcc;

    }
    
    public String getDirection(){
        return this.direcc;
    }

    @Override
    public String toString() {
        return "Cédula: " + ID + ", Nombre: " + Name + ", Fecha de Nacimiento: " + FechaNacimiento + ", Email: " + Correo + ", Dirección de Domicilio: " + direcc; 
    }
    
}
