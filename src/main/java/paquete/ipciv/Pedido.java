/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.ipciv;
import java.util.Scanner;
/**
 *
 * @author Cris
 */
public class Pedido {
    public static Scanner leer = new Scanner(System.in);
    private int ID_Cliente;
    private int Tipo_mueble;
    private String Estado;
    protected String ID;
    
    public Pedido(){
    this.ID = "";
    this.ID_Cliente = 0;
    this.Tipo_mueble = 0;
    this.Estado = "";
    }
    
    public Pedido(int IDC, String estado, int Tipo, String id){
    this.ID = id;
    this.ID_Cliente = IDC;
    this.Tipo_mueble = Tipo;
    this.Estado = estado;
    }

    //<editor-fold defaultstate="collapsed" desc="Gets & Sets">
    public String getNombre_Cliente() {
        return Usuario.getNameClient(ID_Cliente);
    }
    
    public String getData_Cliente() {
        return Usuario.getEtiquetaCliente(ID_Cliente);
    }

    public String getTipo_mueble() {
        String Mueble;
        Mueble = Main.Recetas.get((this.Tipo_mueble - 1)).getNmueble();
        return Mueble;
    }
    
    public int getTipo_muebleIndx() {
        return (this.Tipo_mueble -1);
    }

    public String getEstado() {
        return Estado;
    }
    
    public void setEstado(String state) {
            this.Estado = state;
  
    }

    public String getID() {
        return ID;
    }

    /* Permite obtener la informacion del pedido y presentarla en la consola */
    public String getInfoPedido() {
        String info = "ID pedido: " + getID() + "\n" +
                "Nombre del Cliente: " + getNombre_Cliente() + "\n" +
                "Estado: " + getEstado() + "\n" +
                "Tipo de mueble: " + getTipo_mueble() + "\n";
        return info;
    }  
    //</editor-fold>
    
}
