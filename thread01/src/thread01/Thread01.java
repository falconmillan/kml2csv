/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread01;

/**
 *
 * @author jcfalcon
 */
public class Thread01 extends Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PingPong t1 = new PingPong("PING",300);
        PingPong t2= new PingPong("PONG",100);
        // Activación
        t1.start();
        t2.start();
        // Espera 2 segundos
        
        try{ sleep(1200);
        }catch (InterruptedException e){}
// Finaliza la ejecución de los threads
t1.interrupt(); 
t2.interrupt();
}
}
   
