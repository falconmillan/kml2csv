/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kml2csv;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
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
    
   
}
