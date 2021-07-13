/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;

/**
 *
 * @author guerreroandrey5
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
        return "Cédula: " + getID() + ", Nombre: " + getName() + ", Fecha de Nacimiento: " + getFecha() + ", Email: " + getCorreo() + ", Dirección de Domicilio: " + getDirection(); 
    }
    
}
