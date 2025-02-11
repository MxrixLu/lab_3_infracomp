import java.util.HashMap;

public class Cajero extends Thread {
    private Integer id;
    private Double factorDeCansancio = 1.0;

    public Cajero(Integer id) {
        this.id = id;
    }

    public void run(){
        while(true){
            System.out.println("Cajero " + id + " iniciado");
            HashMap<String, Integer> cliente = App.fila.retirarCliente();
            
            if (cliente == null) {
                System.out.println("Cajero " + id + " finaliza, no hay más clientes.");
                break; 
            }
        
        
            Double tiempoDeProcesamiento =cliente.get("procesamientoBasico")* factorDeCansancio;
            Double tiempoDormir= cliente.get("procesamientoBasico")*0.01 + factorDeCansancio;
            
            try {
                Thread.sleep(tiempoDormir.longValue()); 
            
            } catch (InterruptedException e) {  
                e.printStackTrace();
            }
        System.out.println("El cajero" + id + " atiende al cliente " +
                cliente.get("uid")  + "(tiempo de procesamiento base: " + cliente.get("procesamientoBasico") + "ms) factor de cansancio actual: "
                +  factorDeCansancio + " tiempo de procesamiento actual: "+ tiempoDeProcesamiento);
               
        
    }
}
}
