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
public class PingPong extends Thread {
private String word; // Lo que va a escribir.
private int delay;// Tiempo entre escrituras

public PingPong(String queDecir,int cadaCuantosMs){
word = queDecir; delay = cadaCuantosMs;  
};
@Override
public void run(){  
//Se sobrescribe run() de Thread
while (true){
System.out.println(word + " "); 
try{
sleep(delay);
} catch (InterruptedException e)
{ return; }
}//fin while
}//fin run
}//fin clase
