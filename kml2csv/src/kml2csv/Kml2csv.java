/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kml2csv;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.*;
import org.w3c.dom.Element;

/**
 *
 * @author jcfalcon
 */
public class Kml2csv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String base="C:\\Users\\jcfalcon\\Documents\\documentosJava\\";
        String file="26_may._2017_8_07_39.kml";
        KmlParser kp= new KmlParser(base+file);
        
        NodeList l =kp.get("gx:Track");
        for (int i=0; i<l.getLength();i++){
            
        System.out.println("Nuevo"+" "+i);
        Element e;
        Node n=l.item(i);
        e=(Element)n; 
        NodeList child=e.getChildNodes();
            for (int j=0; j<child.getLength();j++){
                Node m=child.item(j);
                Element elemento;
                elemento=(Element) m;
                if(elemento.getLocalName().compareTo("gx:coord")==0){
                    System.out.print(kp.extraerCoordenadas(e));
                }
                if(m.getLocalName().compareTo("when")==0){
                    System.out.print(kp.extraerTiempo(e));   
                }     
            }
        System.out.println();
        }
    }
    
}
