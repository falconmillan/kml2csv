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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author jcfalcon
 */
public class KmlParser {
    private Document dom;

    public KmlParser(String file) {
        setDom(file);
    }

    public Document getDom() {
        return dom;
    }

    public void setDom(String inputFile){
    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
    
    DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
            this.dom = db.parse(new File(inputFile)); 
            dom.getDocumentElement().normalize();

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(KmlParser.class.getName()).log(Level.SEVERE, null, ex);        
        }
    }
   public NodeList get(String type){
       return dom.getElementsByTagName(type);
   } 
   public String extraerCoordenadas(Node m){
       String r="",t;
       t=m.getTextContent();t.trim();
       String [] v = t.split(" ");
       for(int i=0; i<v.length;i++){
           r=r+v[i];
           if(i<v.length-1)r=r+",";
       }
       
       
       return r;
   }
   public String extraerTiempo(Node m){
       String r=m.getTextContent();
       r=r.replace('T', ',');
       r=r.replace('Z', ' ');
       
       return r;
   }
   public void toCSV(Node e, String file){
       
            try {
                BufferedWriter sa= new BufferedWriter(new FileWriter(new File(file)));
            
            sa.write("LONGITUD,"+"LATITUD,"+"ALTITUD,"+"DIA,"+"HORA");
            sa.newLine();
            if(e.hasChildNodes()){
                NodeList child=e.getChildNodes();
                for (int j=0; j<child.getLength();j++){
                    Node m=child.item(j);                   
                    if(m.getNodeType()==Node.ELEMENT_NODE){
                        if(m.getNodeName().compareTo("gx:coord")==0){
                            sa.write(this.extraerCoordenadas(m)+",");                     
                        }
                        if(m.getNodeName().compareTo("when")==0){
                            sa.write(this.extraerTiempo(m));
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
            }
        
   }
}
