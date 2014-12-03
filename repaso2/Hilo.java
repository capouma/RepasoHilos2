/*
 * Creamos la clase Hilo que es la encargada de contenter el proceso a realizar de nuestos hilos.
 */
package repaso2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author findag
 */
public class Hilo extends Thread
{
    Contador contador;
    public Hilo(String nombreHilo, Contador contador)
    {
        super(nombreHilo);
        this.contador = contador;
    }
    
    @Override
    public void run()
    {
        // Creamos un bucle for que se encargara de incrementar nuestro contador en un total de 4.
        for(int i = 0; i < 4; i++)
        {
            
            /*  Para que nuestro contador funcione correctamente necesitamos usar synchronized
            *   synchronized se encarga de que los hilos accedan uno a uno a los recursos y no se pisen entre ellos.
            */
            synchronized(contador)
            {
                try
                {
                    // Recogemos el valor de la variable contador de la clase Contador y le sumamos 1.
                    int agrega = contador.getContador() + 1;
                    
                    // Dormimos un rato el proceso.
                    sleep((long) (Math.random() * 100));
                    
                    //Agregamos el valor de la variable agrega a la variable contador por medio de su set. 
                    contador.setContador(agrega);
                    
                    // Imprimimos el valor de contador para cada hilo en cada vuelta.
                    System.out.println("El contador en estos momentos es: " + contador.getContador() + " para el " + getName());
                    
                    // Dormimos nuevamente el proceso para que se ejecute un poco mas despacio.
                    sleep((long) (Math.random() * 100));

                }
                catch (InterruptedException ex)
                {
                    System.out.println("Fallo. " + ex);
                }                
            }
        }
        
        // Terminamos nuestro hilo con un mensaje
        System.out.println("Fin del " + getName());
        
    }

}
