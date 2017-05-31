/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author medio
 */
public class Proyectos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String femp="C:\\Users\\medio.PC14\\Desktop\\empleado.csv";
        List <Empleado> l=fromCSV2Empleado(",",femp);
        for(int i=0;i<l.size();i++){
           System.out.println(l.get(i).getCategoría());
        }
    }
 static public List<Empleado> fromCSV2Empleado(String separador,String file){
//fichero de texto
 File f = new File(file);
 java.io.FileReader canal;
 List <Empleado> r= new ArrayList<>();       
        try {
           canal = new FileReader(f);       
           java.io.BufferedReader micanal = new BufferedReader(canal);
           //pierdo la primera línea
           micanal.readLine();
           int i=0;
           while(micanal.ready()){
               Empleado e= new Empleado();
               String [] cadena=micanal.readLine().split(separador);
               e.setIde(Integer.parseInt(cadena[0]));
               e.setNick(cadena[1]);              
               e.setCategoría(cadena[2]);
               e.setAntigüedad(Integer.parseInt(cadena[3]));
               e.setIdd(Integer.parseInt(cadena[4]));
               r.add(e);
               i=i+1;
           }
         } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyectos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Proyectos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
