/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kml2csv;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                kp.toCSV(l.item(i), base+"track"+i+".csv");
           /* try {
                BufferedWriter sa= new BufferedWriter(new FileWriter(new File(base+"track"+i+".csv")));
            
            sa.write("LONGITUD,"+"LATITUD,"+"ALTITUD,"+"DIA,"+"HORA");
            sa.newLine();
            Node e;
            e=l.item(i);
            if(e.hasChildNodes()){
                NodeList child=e.getChildNodes();
                for (int j=0; j<child.getLength();j++){
                    Node m=child.item(j);                   
                    if(m.getNodeType()==Node.ELEMENT_NODE){
                        if(m.getNodeName().compareTo("gx:coord")==0){
                            sa.write(kp.extraerCoordenadas(m)+",");                     
                        }
                        if(m.getNodeName().compareTo("when")==0){
                            sa.write(kp.extraerTiempo(m));
                            sa.newLine();
                        } 
                    }
                }
            }else{
                System.out.println("mala solucion");
            }
            sa.close();
            } catch (IOException ex) {
                Logger.getLogger(Kml2csv.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }
    
}
