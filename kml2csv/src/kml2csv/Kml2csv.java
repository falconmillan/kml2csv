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
        Node e;
      
        e=l.item(i);
        if(e.hasChildNodes()){
            NodeList child=e.getChildNodes();
            for (int j=0; j<child.getLength();j++){
                Node m=child.item(j);
                //Element elemento;
                //elemento=(Element) m;
                if(m.getNodeType()==Node.ELEMENT_NODE){
                    if(m.getNodeName().compareTo("gx:coord")==0){
                        System.out.print(kp.extraerCoordenadas(m));
                    }
                    if(m.getNodeName().compareTo("when")==0){
                        System.out.print(kp.extraerTiempo(m));
                        System.out.println("");
                    } 
                    /*System.out.print("URI: ");System.out.print(m.getBaseURI());
                    System.out.print("name : ");System.out.print(m.getLocalName());
                    System.out.print("Name: ");System.out.print(m.getNodeName());
                    System.out.print("Value: ");System.out.println(m.getNodeValue());
                    */
                    
                }
            }
        
        }else{
            System.out.println("mala solucion");
        }
        }
        
    }
    
}
