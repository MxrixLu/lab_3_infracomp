public class App {

    public static Fila fila = new Fila();
    public static int numero_cajeros = 5; 
    public static int numero_clientes = 7;
    public static void main(String[] args) throws Exception {
        
        Clientes generadorClientes = new Clientes(numero_clientes);
        for(int i = 0; i < numero_cajeros ; i++){
            Cajero cajero = new Cajero(i);
            cajero.start();
        }
        generadorClientes.start();

    }
}
