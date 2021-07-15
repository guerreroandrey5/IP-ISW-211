package paquete.ipciv;

import java.util.*;
import static paquete.ipciv.Usuario.getNameClient;

/**
 *
 * @author guerreroandrey5
 */
public class Main {

    /**
     * Estos Arrays tienen la funcion de almacenar a los Usuarios, recetas, pedidos y clientes del sistema.
     */
//<editor-fold defaultstate="collapsed" desc="ArrayLists">
    protected static ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
    protected static ArrayList<Pedido> Pedidos = new ArrayList<Pedido>();
    protected static ArrayList<Receta> Recetas = new ArrayList<Receta>();
    protected static Inventario newInv;
    
//</editor-fold>
    /**
     * Un scanner para leer los valores que ingresa el usuario
     */
    protected static Scanner lee = new Scanner(System.in);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Main.fload();
         Main.menu();        
    }
    /*
    * El menú principal del sistema tiene 3 opciones, el Login, el Registro y
    * una frase motivacional para los trabajadores. 
    */
    static void menu(){
        while (true) {
        int opc = Main.valor();
        switch (opc)
        {
            case 1:
            Main.login();            
            break;
            
            case 2:
            System.out.println("Hoy será un día maravilloso!");         
            break;
            
            case 3:
            Main.RegEmpl();
            break;
            
        default:
        }            
        }
    }
    
//<editor-fold defaultstate="collapsed" desc="Métodos">
    static int valor(){
        int opc;
        System.out.println("\n  Bienvenido al sistema de la Fábrica de Muebles\n");
        System.out.println("    1-Login    ");
        System.out.println("    2-Registro    ");
        System.out.println("    3-Mensaje Motivacional    ");
        opc = lee.nextInt();
        return opc;
    }
    /*
    * El metodo login realiza un compararcion en el Array de usuarios y verifica
    * si el usuario y contraseña corresponder con los almacenados.
    */    
    static void login(){
    int IDinput; 
    String passinput;
        System.out.println("Digite su Cédula (ID): ");
        IDinput = lee.nextInt();
        System.out.println("Digite una contraseña: ");
        passinput = lee.next();
        for (int i = 0; i <Usuarios.size() ; i++) {
            if (Usuarios.get(i).getID() == IDinput && Usuarios.get(i).getContra().equals(passinput)) {
                if ("Admin" == Usuarios.get(i).getTipo()){
                    System.out.println("Bienvenido Administrador " + Usuarios.get(i).getName());
                    Administrador USER = new Administrador(Usuarios.get(i));
                    boolean control = true;
                    while(control){
                        control = USER.Menu();
                    }
                } else if ("Empleado" == Usuarios.get(i).getTipo()){
                    System.out.println("Bienvenido Empleado " + Usuarios.get(i).getName());
                    Empleado USER = new Empleado(Usuarios.get(i));
                    boolean control = true;
                    while(control){
                        control = USER.Menu();
                    }
                } 
                
            } 
        }       
    }
    
    /**
     * El metodo Registro, al ingresar el valor de "ID" el sistema verifica si
     * ese "ID" ya existe en el sistema, en caso de encontrarlo, devuelve un
     * error, en caso de no existir el registro continua normalmente.
     */
    public static void RegEmpl() {
        int ID; String nombre, fnac, email, pass;
        System.out.println("Digite su Cédula: ");
        ID = lee.nextInt();
        String name = getNameClient(ID);              
        if (name.equals("")){
              System.out.println("Digite su nombre completo (Si desea utilizar espacios, utlice guiones en lugar de espacios): ");
        nombre = lee.next();
        System.out.println("Digite su fecha de nacimiento (dd/mm/aaaa): ");
        fnac = lee.next();
        System.out.println("Digite su correo electrónico : ");
        email = lee.next();
        System.out.println("Digite una contraseña: ");
        pass = lee.next();
        Usuario newUser = new Usuario(ID, nombre, fnac, email, "Empleado", pass);
        Main.Usuarios.add(newUser);            
        } else {
            System.out.println("El Empleado ya se encuentra registrado en el sistema.");
        }
        
     }
    /**
     * El metodo FirstLoad carga algunos datos en elos Arrays para su
     * funcionamiento, carga los datos para el inventario de un random, el admin
     * un usuario y un cliente.
     */
    static void fload(){
        
        int n1 = (int) (Math.random()*150+45);
        int n2 = (int) (Math.random()*150+43);
        int n3 = (int) (Math.random()*150+40);
        int n4 = (int) (Math.random()*150+46);
        int n5 = (int) (Math.random()*150+44);
        
        Administrador newUserad = new Administrador(23, "Pedro", "06/11/2002", "admin@mueblesitos.siuuu", "Admin", "123");
        Empleado newUserem = new Empleado(20, "Esteban", "20/06/2000", "worker@mueblesitos.siuuu", "Empleado", "13");
        Cliente newUsercl = new Cliente(22, "Piter", "20/06/2000", "Piter@haus.com", "Cliente", "Choza","");
        Receta newRecipe1 = new Receta("Mesita Gamer", /*Madera*/10, /*Metal*/0, /*Pintura*/20, /*Clavos*/10, /*Tornillos*/0);
        Receta newRecipe2 = new Receta("Banquito de Metal Reforzado Gamer", /*Madera*/0, /*Metal*/20, /*Pintura*/15, /*Clavos*/0, /*Tornillos*/20);
        Receta newRecipe3 = new Receta("Estantería Gamer", /*Madera*/10, /*Metal*/0, /*Pintura*/10, /*Clavos*/8, /*Tornillos*/0);
        newInv = new Inventario(/*Madera*/n1, /*Metal*/n2, /*Pintura*/n3, /*Clavos*/n4, /*Tornillos*/n5);
        Usuarios.add(newUserad); 
        Usuarios.add(newUsercl);
        Usuarios.add(newUserem);
        Recetas.add(newRecipe1); 
        Recetas.add(newRecipe2);
        Recetas.add(newRecipe3);
    }
    
    //</editor-fold>
    
}
