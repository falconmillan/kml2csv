/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectos;


import java.util.Iterator;
import java.util.List;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import static proyectos.Proyectos.ldep;

/**
 *
 * @author jcfalcon
 */
public class Consultas {
    private String basededatos;
    private String salida;

    public Consultas(String basededatos) {
        this.basededatos = basededatos;
    }

    public String getBasededatos() {
        return basededatos;
    }

    public void setBasededatos(String basededatos) {
        this.basededatos = basededatos;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    public void consulta1(String nick){
     ODB  db;
     db =ODBFactory.open(basededatos);
     if(!basededatos.isEmpty()){         
         ICriterion criterio = Where.equal("nick",nick);
         IQuery query = new CriteriaQuery(Empleado.class, criterio);
         Objects <Empleado> e = db.getObjects(query);
         Empleado dummy;
         if(e.size()==1){
             dummy=e.next();
             String datos="ID:"+dummy.getIde()+" NICK: "+dummy.getNick();
             datos=datos+" DEPARTAMENTO: "+dummy.getDep().getNombre()
                     +" CATEGORÍA: "+dummy.getCategoria();
             
             System.out.println(datos);
             Iterator cursor10=dummy.getProyectos().iterator();
             while(cursor10.hasNext()){
                 Proyecto p;
                 p=(Proyecto)cursor10.next();
                 String datapry= "\tNOMBRE_PROYECTO:"+p.getNombre()+
                         " DESCRIPCION: "+p.getDescripcion();
                 System.out.println(datapry);
                 
             }
         }else{
             System.out.println("Consulta1.Se esperaba un solo resultado.");
         }
         
         
         db.close();
     }else{
         System.out.println("Consulta1.Base de datos nula.");
     }
    }
    public void consulta2(){
      ODB  db;
      db =ODBFactory.open(basededatos);
     if(!basededatos.isEmpty()){
         ICriterion criterio = Where.equal("acabado",false);
         IQuery query = new CriteriaQuery(Proyecto.class, criterio);
         Objects <Proyecto> plist = db.getObjects(query);
         Iterator cursor = plist.iterator();
         while(cursor.hasNext()){
             Proyecto p= (Proyecto)cursor.next();
             if(p.getEmpleados().size()<=3){
                 String total="Proyecto: "+p.getNombre();
                 total=total+" Descripcion: "+p.getDescripcion();
                 total=total+"Participantes: "+p.getEmpleados().size();
                 System.out.println(total);
             }
         }
        
     }else{
         System.out.println("Consulta2.Error al abrir base de datos."); 
     } 
     db.close();
    }
    public void consulta3(){
      ODB  db;
      db =ODBFactory.open(basededatos);
     if(!basededatos.isEmpty()){
         IQuery query = new CriteriaQuery(Departamento.class);
         Objects <Departamento> dlist = db.getObjects(query);
         Iterator cursor = dlist.iterator();
         while(cursor.hasNext()){
             Departamento d= (Departamento)cursor.next();
             List <Empleado> e; e=d.jefes();  
             for(Empleado x: e){
                 String total="DEPARTAMENTO: "+d.getNombre();
                 total=total+" Nombre Jefe: "+x.getNick();                 
                 total=total+" Antiguedad: "+x.getAntiguedad();
                 System.out.println(total);
             }
             
            
         }
     
     }else{
         System.out.println("Consulta2.Error al abrir base de datos."); 
     }  
     db.close();
    }
     public void consulta4(){
      ODB  db;
     db =ODBFactory.open(basededatos);
     if(!basededatos.isEmpty()){         
         
         IQuery query = new CriteriaQuery(Empleado.class);
         Objects <Empleado> e = db.getObjects(query);
         Iterator cursor=e.iterator();
         int jefe=0;int oficial=0;int becario=0;
         while(cursor.hasNext()){
             Empleado dummy; dummy=(Empleado) cursor.next();
             String cat; cat=dummy.getCategoria();
             if(cat.compareTo("jefe")==0)jefe=jefe+1;
             if(cat.compareTo("becario")==0)becario=becario+1;
             if(cat.compareTo("oficial")==0)oficial=oficial+1;  
             }
         int total= jefe+oficial+becario;      
         System.out.println("Jefes: "+jefe+" Porcentaje%: "+ (((double) jefe)/total)*100.0);
         System.out.println("Oficiales: "+oficial+" Porcentaje%: "+ (((double) oficial)/total)*100.0);
         System.out.println("Becarios: "+becario+" Porcentaje%: "+ (((double) becario)/total)*100.0);
         
         db.close();
     }else{
         System.out.println("Consulta4.Base de datos nula.");
     }
    }
}
