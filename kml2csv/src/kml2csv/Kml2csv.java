/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kml2csv;

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
      System.out.println(kp.getDom().getDocumentURI());
    }
    
}
