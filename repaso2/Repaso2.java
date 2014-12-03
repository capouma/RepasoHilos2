/*
 * Programa en Java que cree 4 hilos que acceden a una variable compartida que es un contador.
 * Cada uno de los hilos accede cuatro veces al contador y aumenta en una unidad su valor.
 */
package repaso2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author findag
 */
public class Repaso2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Contador contador = new Contador();
        
        // Creamos 4 hilos distintos con dos parametros, nombre de hilo y el recurso al cual quieren acceder en este caso a la clase Contador.
        Hilo hilo1 = new Hilo("Hilo 1", contador);
        Hilo hilo2 = new Hilo("Hilo 2", contador);
        Hilo hilo3 = new Hilo("Hilo 3", contador);
        Hilo hilo4 = new Hilo("Hilo 4", contador);
        
        // Lanzamos los hilos.
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        
        try {
            // Lanzamos los join

            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Repaso2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
