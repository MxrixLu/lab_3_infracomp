
import java.util.ArrayList;
import java.util.HashMap;

public class Fila {
    
    public static ArrayList<HashMap<String, Integer>> filaClientes = new ArrayList<HashMap<String, Integer>>();
    private boolean terminado = false;

    public Fila() {
    }

    public synchronized void agregarCliente(HashMap<String, Integer> cliente) {
        
        filaClientes.add(cliente);
        if (filaClientes.size() == 1) {
            notify();
        }
    }

    public synchronized void terminar() {
        terminado = true;
        notifyAll();
    }
    
    public synchronized HashMap<String, Integer> atenderCliente(Integer uid){   
        if (filaClientes.isEmpty()){
           System.out.println("No hay clientes en la fila");
        } 
        for (HashMap<String, Integer> cliente : filaClientes) {
            if (cliente.get("uid") == uid) {
                return cliente;
            }
        }  
        return null;
    }


    public synchronized HashMap<String, Integer> retirarCliente(){
        while(filaClientes.isEmpty() && !terminado){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (filaClientes.isEmpty() && terminado) {
            return null;
        }
        HashMap<String, Integer> cliente = filaClientes.get(0);
        filaClientes.remove(0);
        return cliente;
        }
 }
        