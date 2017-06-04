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
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author medio
 */
public class Proyectos {
static String femp="C:\\Users\\jcfalcon\\Documents\\documentosJava\\empleado.csv";
static String fdep="C:\\Users\\jcfalcon\\Documents\\documentosJava\\departamento.csv";
static String fpry="C:\\Users\\jcfalcon\\Documents\\documentosJava\\proyecto.csv";
static String relempry="C:\\Users\\jcfalcon\\Documents\\documentosJava\\relproyemp.csv";
static String database="C:\\Users\\jcfalcon\\Documents\\documentosJava\\proyectos.neodatis";
static List <Departamento> ldep;
static List <Empleado> lemp;
static List <Proyecto> lpry;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    /*ldep=fromCSV2Departamento(",",fdep);
    lemp=fromCSV2Empleado(",",femp);
    lpry=fromCSV2Proyecto(",",fpry);
    fromCSV2rel(",",relempry);
    cargaNeodatis(database);
    System.out.println("Todo ha ido conforme lo esperado. Base de datos cargada");
        */
    Consultas c= new Consultas (database);
    c.consulta1("empleado10");
    c.consulta2();
    c.consulta3();
    c.consulta4();
    
        
        
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
               e.setCategoria(cadena[2]);
               e.setAntiguedad(Integer.parseInt(cadena[3]));
               Departamento d;
               d=findDepartamento(ldep,Integer.parseInt(cadena[4]));
               //añado el departamento al empleado y el empleado al departamento
               if(d!=null)e.setDep(d);
               if(d!=null)d.getEmpleados().add(e);
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
 static public List<Departamento> fromCSV2Departamento(String separador,String file){
//fichero de texto
 File f = new File(file);
 java.io.FileReader canal;
 List <Departamento> r= new ArrayList<>();       
        try {
           canal = new FileReader(f);       
           java.io.BufferedReader micanal = new BufferedReader(canal);
           //pierdo la primera línea
           micanal.readLine();
           int i=0;
           while(micanal.ready()){
               Departamento e= new Departamento();
               String [] cadena=micanal.readLine().split(separador);
               e.setIdd(Integer.parseInt(cadena[0]));
               e.setNombre(cadena[1]);              
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
 static public List<Proyecto> fromCSV2Proyecto(String separador,String file){
//fichero de texto
 File f = new File(file);
 java.io.FileReader canal;
 List <Proyecto> r= new ArrayList<>();       
        try {
           canal = new FileReader(f);       
           java.io.BufferedReader micanal = new BufferedReader(canal);
           //pierdo la primera línea
           micanal.readLine();
           int i=0;
           while(micanal.ready()){
               Proyecto e= new Proyecto();
               String [] cadena=micanal.readLine().split(separador);
               e.setIdp(Integer.parseInt(cadena[0]));
               e.setNombre(cadena[1]);              
               e.setDescripcion(cadena[2]);
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
 static public void fromCSV2rel(String separador,String file){
//fichero de texto
 File f = new File(file);
 java.io.FileReader canal;
      
        try {
           canal = new FileReader(f);       
           java.io.BufferedReader micanal = new BufferedReader(canal);
           //pierdo la primera línea
           micanal.readLine();
           int i=0;
           while(micanal.ready()){
               
               String [] cadena=micanal.readLine().split(separador);
               Empleado e;
               Proyecto p;
               e=findEmpleado(lemp,Integer.parseInt(cadena[1]));
               p=findProyecto(lpry,Integer.parseInt(cadena[0]));
               if(!e.isProyecto(p))e.getProyectos().add(p);
               if(!p.isEmpleado(e)){
                   p.getEmpleados().add(e);
                   p.setAcabado(logic(cadena[2]));
               }
              
               i=i+1;
           }
         } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyectos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Proyectos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
 static public void cargaNeodatis(String base){
     ODB db =ODBFactory.open(base);
     for(Departamento x:ldep)db.store(x);
     for(Empleado x:lemp)db.store(x);
     for(Proyecto x:lpry)db.store(x);
     db.close();
         }
 
 static public Departamento findDepartamento(List<Departamento> l, int idd){
     Departamento r;r=null;
     for(Departamento x:l)if(x.getIdd()==idd)r=x;     
     return r;
             
 }
 static public Empleado findEmpleado(List<Empleado> l, int ide){
     Empleado r;r=null;
     for(Empleado x:l)if(x.getIde()==ide)r=x;     
     return r;
             
 }
 static public Proyecto findProyecto(List<Proyecto> l, int idp){
     Proyecto r;r=null;
     for(Proyecto x:l)if(x.getIdp()==idp)r=x;     
     return r;
             
 }
 static public boolean logic(String s){
     boolean r=true;
     if(s.compareTo("0")==0)r=false;
     return r;
 }
  
}
