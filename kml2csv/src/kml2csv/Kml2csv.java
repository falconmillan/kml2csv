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
        /*
        String base="C:\\Users\\jcfalcon\\Documents\\documentosJava\\";
        String file="26_may._2017_8_07_39.kml";
        KmlParser kp= new KmlParser(base+file);
        NodeList l =kp.get("gx:Track");
        for (int i=0; i<l.getLength();i++)kp.toCSV(l.item(i), base+"track"+i+".csv");
        */
        Principal f=new Principal();
        f.setVisible(true);
    }
    
}
