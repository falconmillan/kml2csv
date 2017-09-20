/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiloejemplodead;

/**
 *
 * @author jcfalcon
 */
public class HiloEjemploDead extends Thread {

    private boolean stopHilo= false; 
	public void pararHilo() { 		
            stopHilo = true;
        } 
    @Override
	public void run() { 
		while (!stopHilo) {     System.out.println("En el Hilo");     } 
	} 
	public static void main(String[] args) { 
		HiloEjemploDead h = new HiloEjemploDead (); 
		h.start(); 
		for(int i=0;i<100000; i++) ;	//no hago nada 
		h.pararHilo(); //parar el hilo
	}
    
}
